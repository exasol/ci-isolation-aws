package com.exasol.ciisolation.aws.ciuser;

import java.util.*;

import org.jetbrains.annotations.NotNull;

import com.exasol.ciisolation.aws.TaggedStack;
import com.exasol.ciisolation.aws.cleanup.AccountCleanupStack;

import software.amazon.awscdk.CfnOutput;
import software.amazon.awscdk.services.iam.*;
import software.constructs.Construct;

/**
 * This class defines a CloudFormation stack with a user for CI testing. Typically, this stack is used from a project
 * specific CI CDK setup.
 */
public class CiUserStack extends TaggedStack {
    /** The output name of the CI userName */
    public static final String OUTPUT_CI_USER_NAME = "ciUserName";
    /** The output ARN of the CI role */
    public static final String OUTPUT_CI_ROLE_ARN = "ciRoleArn";

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
        final IManagedPolicy denyChangingProtectedResourcesPolicy = ManagedPolicy.fromManagedPolicyName(this,
                AccountCleanupStack.DENY_CHANGING_PROTECTED_RESOURCE_POLICY,
                AccountCleanupStack.DENY_CHANGING_PROTECTED_RESOURCE_POLICY);

        final User ciUser = defineUser(props);
        setupResource(ciUser, denyChangingProtectedResourcesPolicy);
        CfnOutput.Builder.create(this, OUTPUT_CI_USER_NAME).value(ciUser.getUserName()).build();

        if (props.createRole()) {
            final Role ciRole = defineRole(props);
            setupResource(ciRole, denyChangingProtectedResourcesPolicy);
            CfnOutput.Builder.create(this, OUTPUT_CI_ROLE_ARN).value(ciRole.getRoleArn()).build();
        }
    }

    private void setupResource(final IIdentity identity, final IManagedPolicy denyChangingProtectedResourcesPolicy) {
        identity.addManagedPolicy(denyChangingProtectedResourcesPolicy);
        tagResource(identity);
    }

    private @NotNull User defineUser(final CiUserStackProps props) {
        final String ciUserName = PROTECTED + props.projectName() + "-ci-user";
        final User ciUser = new User(this, ciUserName, UserProps.builder().userName(ciUserName).build());
        setupManagedPolicies(ciUser, props.requiredPermissions());
        return ciUser;
    }

    private @NotNull Role defineRole(final CiUserStackProps props) {
        final String ciRoleName = PROTECTED + props.projectName() + "-ci-role";
        final RoleProps roleProps = RoleProps.builder()
                .roleName(ciRoleName)
                .assumedBy(new AccountPrincipal(this.getAccount()))
                .build();
        final Role ciRole = new Role(this, ciRoleName, roleProps);
        setupManagedPolicies(ciRole, props.roleRequiredPermissions());
        return ciRole;
    }

    private void setupManagedPolicies(final IIdentity identity, final List<PolicyDocument> requiredPermissions) {
        final List<ManagedPolicy> policies = createPolicies(identityName(identity), requiredPermissions);
        addPolicies(identity, policies);
    }

    @NotNull
    private List<ManagedPolicy> createPolicies(final String resourceName, final List<PolicyDocument> requiredPermissions) {
        final List<ManagedPolicy> policies = new ArrayList<>();
        int counter = 1;
        for (final PolicyDocument requiredPermission : requiredPermissions) {
            final String name = resourceName + "-policy-" + counter;
            policies.add(createManagedPolicy(requiredPermission, name));
            counter++;
        }
        return policies;
    }

    private void addPolicies(final IIdentity identity, final List<ManagedPolicy> policies) {
        for (final ManagedPolicy policy : policies) {
            tagResource(policy);
            identity.addManagedPolicy(policy);
        }
    }

    @NotNull
    private ManagedPolicy createManagedPolicy(final PolicyDocument policyDocument, final String name) {
        final ManagedPolicy managedPolicy = new ManagedPolicy(this, name,
                ManagedPolicyProps.builder().document(policyDocument).managedPolicyName(name).build());
        tagResource(managedPolicy);
        return managedPolicy;
    }

    private String identityName(final IIdentity identity) {
        if (identity instanceof User) {
            return ((User) identity).getUserName();
        } else if (identity instanceof Role) {
            return ((Role) identity).getRoleName();
        } else {
            throw new IllegalArgumentException("Unexpected identity class: " + identity.getClass().getName());
        }
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
         * Whether a Role should be created by the stack.
         *
         * @return true if a role should be created, false (default) otherwise.
         */
        boolean createRole();

        /**
         * Get AWS permissions required for this CI user.
         *
         * @return permissions
         */
        List<PolicyDocument> requiredPermissions();

        /**
         * Get AWS permissions required for the CI Role.
         *
         * @return permissions
         */
        List<PolicyDocument> roleRequiredPermissions();
    }

    /**
     * Properties for the {@link CiUserStack}.
     */
    public static class DefaultCiUserStackProps implements CiUserStackProps {
        private final String projectName;
        private final boolean createRole;
        private final List<PolicyDocument> requiredPermissions;
        private final List<PolicyDocument> roleRequiredPermissions;

        private DefaultCiUserStackProps(final Builder builder) {
            this.projectName = builder.projectName;
            this.createRole = builder.createRole;
            this.requiredPermissions = builder.requiredPermissions;
            this.roleRequiredPermissions = builder.roleRequiredPermissions;
            if (!roleRequiredPermissions.isEmpty() && !createRole) {
                throw new IllegalArgumentException("Only when createRole is true roleRequiredPermissions can be set");
            }
        }

        @Override
        public boolean createRole() {
            return createRole;
        }

        @Override
        public String projectName() {
            return this.projectName;
        }

        @Override
        public List<PolicyDocument> requiredPermissions() {
            return this.requiredPermissions;
        }

        @Override
        public List<PolicyDocument> roleRequiredPermissions() {
            return roleRequiredPermissions;
        }

        /**
         * Builder for {@link DefaultCiUserStackProps}.
         */
        public static class Builder {
            private final List<PolicyDocument> requiredPermissions = new ArrayList<>();
            private final List<PolicyDocument> roleRequiredPermissions = new ArrayList<>();
            private String projectName;
            private boolean createRole;

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
             * Set whether to create a role in the stack.
             *
             * @param createRole true to create a role, false (default) otherwise
             * @return self for fluent programming
             */
            public Builder createRole(final boolean createRole) {
                this.createRole = createRole;
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
             * Add permissions to the CI Role.
             * Should only be used if {@code createRole} is set to true.
             *
             * @param roleRequiredPermissions AWS permissions
             * @return self for fluent programming
             */
            public Builder addRoleRequiredPermissions(final PolicyDocument... roleRequiredPermissions) {
                this.roleRequiredPermissions.addAll(Arrays.asList(roleRequiredPermissions));
                return this;
            }

            /**
             * Build the {@link CiUserStackProps}.
             *
             * @return built {@link CiUserStackProps}
             */
            public CiUserStackProps build() {
                return new DefaultCiUserStackProps(this);
            }
        }
    }
}
