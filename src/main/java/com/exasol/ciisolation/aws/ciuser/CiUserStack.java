package com.exasol.ciisolation.aws.ciuser;

import java.util.*;

import org.jetbrains.annotations.NotNull;

import com.exasol.ciisolation.aws.TaggedStack;
import com.exasol.ciisolation.aws.cleanup.AccountCleanupStack;

import software.amazon.awscdk.core.CfnOutput;
import software.amazon.awscdk.core.Construct;
import software.amazon.awscdk.services.iam.*;

/**
 * This class defines a CloudFormation stack with a user for CI testing. Typically this stack is used from a project
 * specific CI CDK setup.
 */
public class CiUserStack extends TaggedStack {
    /** The output name of the CI user name */
    public static final String OUTPUT_CI_USER_NAME = "ciUserName";
    private static final String PROTECTED = "protected-";

    /**
     * Creates a new stack for the CI user.
     * @param scope the scope
     * @param props the properties
     */
    public CiUserStack(final Construct scope, final CiUserStackProps props) {
        super(scope, PROTECTED + props.projectName() + "-ci-setup", null, props.projectName());
        defineResources(props);
    }

    private void defineResources(final CiUserStackProps props) {
        final String ciUserName = PROTECTED + props.projectName() + "-ci-user";
        final IManagedPolicy denyChangingProtectedResourcesPolicy = ManagedPolicy.fromManagedPolicyName(this,
                AccountCleanupStack.DENY_CHANGING_PROTECTED_RESOURCE_POLICY,
                AccountCleanupStack.DENY_CHANGING_PROTECTED_RESOURCE_POLICY);
        final User ciUser = new User(this, ciUserName, UserProps.builder().userName(ciUserName).build());
        ciUser.addManagedPolicy(denyChangingProtectedResourcesPolicy);
        tagResource(ciUser);
        final List<ManagedPolicy> policies = createPolicies(props);
        addPolicies(ciUser, policies);
        CfnOutput.Builder.create(this, OUTPUT_CI_USER_NAME).value(ciUser.getUserName()).build();
    }

    @NotNull
    private List<ManagedPolicy> createPolicies(final CiUserStackProps props) {
        final List<ManagedPolicy> policies = new ArrayList<>();
        int counter = 1;
        for (final PolicyDocument requiredPermission : props.requiredPermissions()) {
            final String name = PROTECTED + props.projectName() + "-ci-user-policy-" + counter;
            policies.add(createManagedPolicy(requiredPermission, name));
            counter++;
        }
        return policies;
    }

    private void addPolicies(final User ciUser, final List<ManagedPolicy> policies) {
        for (final ManagedPolicy policy : policies) {
            tagResource(policy);
            ciUser.addManagedPolicy(policy);
        }
    }

    @NotNull
    private ManagedPolicy createManagedPolicy(final PolicyDocument policyDocument, final String name) {
        final ManagedPolicy managedPolicy = new ManagedPolicy(this, name,
                ManagedPolicyProps.builder().document(policyDocument).managedPolicyName(name).build());
        tagResource(managedPolicy);
        return managedPolicy;
    }

    /**
     * Interface for configuration of {@link CiUserStack}.
     */
    public interface CiUserStackProps {
        /**
         * Create a builder.
         *
         * @return builder
         */
        static DefaultCiUserStackProps.Builder builder() {
            return new DefaultCiUserStackProps.Builder();
        }

        /**
         * Get the project name.
         *
         * @return name of the project.
         */
        String projectName();

        /**
         * Get AWS permissions required for this CI user.
         *
         * @return permissions
         */
        List<PolicyDocument> requiredPermissions();
    }

    /**
     * Properties for the {@link CiUserStack}.
     */
    public static class DefaultCiUserStackProps implements CiUserStackProps {
        private final String projectName;
        private final List<PolicyDocument> requiredPermissions;

        private DefaultCiUserStackProps(final Builder builder) {
            this.projectName = builder.projectName;
            this.requiredPermissions = builder.requiredPermissions;
        }

        @Override
        public String projectName() {
            return this.projectName;
        }

        @Override
        public List<PolicyDocument> requiredPermissions() {
            return this.requiredPermissions;
        }

        /**
         * Builder for {@link DefaultCiUserStackProps}.
         */
        public static class Builder {
            private final List<PolicyDocument> requiredPermissions = new ArrayList<>();
            private String projectName;

            /**
             * Set the project name.
             *
             * @param projectName project name
             * @return self for fluent programming
             */
            public Builder projectName(final String projectName) {
                this.projectName = projectName;
                return this;
            }

            /**
             * Add permissions to the CI user.
             *
             * @param requiredPermissions AWS permissions
             * @return self for fluent programming
             */
            public Builder addRequiredPermissions(final PolicyDocument... requiredPermissions) {
                this.requiredPermissions.addAll(Arrays.asList(requiredPermissions));
                return this;
            }

            /**
             * Build the @link CiUserStackProps}.
             *
             * @return built {@link CiUserStackProps}
             */
            public CiUserStackProps build() {
                return new DefaultCiUserStackProps(this);
            }
        }
    }
}
