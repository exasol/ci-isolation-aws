package com.exasol.ciisonlation.aws.cleanup;

import java.util.List;

import com.exasol.ciisonlation.aws.TaggedStack;

import software.amazon.awscdk.core.Construct;
import software.amazon.awscdk.services.codebuild.*;
import software.amazon.awscdk.services.events.*;
import software.amazon.awscdk.services.events.targets.CodeBuildProject;
import software.amazon.awscdk.services.iam.*;

/**
 * This class creates an CloudFormation stack for a code build job that deletes all unprotected resources in an AWS
 * account each day at 6:00AM.
 */
public class AccountCleanupStack extends TaggedStack {
    public static final String AWS_ACCOUNT_CLEANUP_ROLE = "protected-aws-account-cleanup-role";
    public static final String AWS_ACCOUNT_CLEANUP_RUNNER = "protected-aws-account-cleanup-runner";
    public static final String DENY_CHANGING_PROTECTED_RESOURCE_POLICY = "protected-deny-changing-protected-resource-policy";
    public static final String CLEANUP_POLICY = "protected-generic-cleanup-policy";
    public static final String CLEANUP_TRIGGER = "protected-cleanup-trigger";
    private static final String CLEANUP_STACK_NAME = "protected-ci-account-cleanup";

    /**
     * Create a new instance of {@link AccountCleanupStack}.
     * 
     * @param scope parent
     */
    public AccountCleanupStack(final Construct scope) {
        super(scope, CLEANUP_STACK_NAME, null, "ci-account-cleanup");
        final Role cleanupRole = new Role(this, AWS_ACCOUNT_CLEANUP_ROLE, RoleProps.builder()
                .roleName(AWS_ACCOUNT_CLEANUP_ROLE).assumedBy(new ServicePrincipal("codebuild.amazonaws.com")).build());

        addCleanupPolicy(cleanupRole);

        tagResource(cleanupRole);
        cleanupRole.addManagedPolicy(createDenyChangeProtectedResourcePolicy());
        final BuildSpec buildSpec = new AwsAccountCleanerBuildSpec(this.getAccount());
        final Project cleanupCodebuild = new Project(this, AWS_ACCOUNT_CLEANUP_RUNNER,
                ProjectProps.builder().buildSpec(buildSpec).projectName(AWS_ACCOUNT_CLEANUP_RUNNER).role(cleanupRole)
                        .environment(BuildEnvironment.builder().buildImage(LinuxBuildImage.STANDARD_5_0).build())
                        .build());
        tagResource(cleanupCodebuild);
        createScheduledTrigger(cleanupCodebuild);
    }

    private void createScheduledTrigger(final Project cleanupCodebuild) {
        final CodeBuildProject codeBuildTarget = CodeBuildProject.Builder.create(cleanupCodebuild).retryAttempts(3)
                .build();
        final Schedule schedule = Schedule
                .cron(CronOptions.builder().minute("0").hour("6").day("*").month("*").year("*").build());
        final Rule trigger = new Rule(this, CLEANUP_TRIGGER, RuleProps.builder().ruleName(CLEANUP_TRIGGER)
                .schedule(schedule).targets(List.of(codeBuildTarget)).build());
        tagResource(trigger);
    }

    private void addCleanupPolicy(final Role cleanupRole) {
        final PolicyStatement policyStatement = new PolicyStatement(PolicyStatementProps.builder().effect(Effect.ALLOW)
                .actions(List.of("iam:ListAccountAliases")).resources(List.of("*")).build());
        final Policy cleanupPolicy = new Policy(this, CLEANUP_POLICY,
                PolicyProps.builder().policyName(CLEANUP_POLICY).statements(List.of(policyStatement)).build());
        tagResource(cleanupPolicy);
        cleanupPolicy.attachToRole(cleanupRole);
    }

    private ManagedPolicy createDenyChangeProtectedResourcePolicy() {
        final ManagedPolicy denyChangeProtectedResourcePolicy = new ManagedPolicy(this,
                DENY_CHANGING_PROTECTED_RESOURCE_POLICY,
                ManagedPolicyProps.builder().managedPolicyName(DENY_CHANGING_PROTECTED_RESOURCE_POLICY).build());
        denyChangeProtectedResourcePolicy
                .addStatements(getStatementDenyingIamOperationsOnResourceStartingWithProtected());
        tagResource(denyChangeProtectedResourcePolicy);
        return denyChangeProtectedResourcePolicy;
    }

    private PolicyStatement getStatementDenyingIamOperationsOnResourceStartingWithProtected() {
        final PolicyStatement policyStatement = new PolicyStatement(
                PolicyStatementProps.builder().effect(Effect.DENY).build());
        policyStatement.addActions("iam:*", "codebuild:DeleteWebhook", "codebuild:DeleteBuildBatch",
                "codebuild:DeleteReportGroup", "codebuild:StopBuild", "codebuild:PutResourcePolicy",
                "codebuild:DeleteReport", "codebuild:DeleteProject", "codebuild:BatchDeleteBuilds",
                "codebuild:CreateProject", "codebuild:DeleteResourcePolicy", "codebuild:DeleteSourceCredentials",
                "cloudformation:*", "logs:Delete*", "events:*");
        policyStatement.addResources("arn:aws:iam::*:user/protected-*");
        policyStatement.addResources("arn:aws:iam::*:policy/protected-*");
        policyStatement.addResources("arn:aws:iam::*:role/protected-*");
        policyStatement.addResources("arn:aws:iam::*:role/OrganizationAccountAccessRole");
        policyStatement.addResources("arn:aws:iam::*:role/OrganizationIAMRoleAccess");
        policyStatement.addResources("arn:aws:codebuild:*:*:project/protected-*");
        policyStatement.addResources("arn:aws:cloudformation:*:*:stack/protected-*");
        policyStatement.addResources("arn:aws:logs:*:*:log-group/protected-*");
        policyStatement.addResources("arn:aws:events:*:*:rule/protected-*");

        return policyStatement;
    }
}
