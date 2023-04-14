package com.exasol.ciisolation.aws;

import static com.exasol.ciisolation.aws.cleanup.AccountCleanupStack.AWS_ACCOUNT_CLEANUP_RUNNER;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.*;

import com.exasol.ciisolation.aws.ciuser.CiUserStack;

import software.amazon.awscdk.App;
import software.amazon.awssdk.auth.credentials.*;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.codebuild.CodeBuildClient;
import software.amazon.awssdk.services.codebuild.model.DeleteProjectRequest;
import software.amazon.awssdk.services.codebuild.model.StartBuildRequest;
import software.amazon.awssdk.services.iam.IamClient;
import software.amazon.awssdk.services.iam.model.*;
import software.amazon.awssdk.services.sts.StsClient;

/**
 * This tests verify that the ci-user can not run actions more than allowed.
 * <p>
 * For running this test you need an admin user. For that reason we do not run this test in CI.
 * </p>
 */
class PermissionBoundaryIT {
    private static CdkRunner.StackDeployment deployment;
    private static StaticCredentialsProvider ciUserCredentialsProvider;
    private static IamClient iamAdmin;
    private static IamClient iamCiUser;
    private static AccessKey ciUserAccessKey;
    private static String ciUserName;

    @BeforeAll
    static void beforeAll() throws InterruptedException {
        final TestConfiguration testConfiguration = new TestConfigurationReader().readConfig();
        final ProfileCredentialsProvider adminCredentialsProvider = ProfileCredentialsProvider
                .create(testConfiguration.getAwsProfile());
        final CdkRunner cdkRunner = new CdkRunner(adminCredentialsProvider, testConfiguration.getOwner());
        final App app = new App();
        final CiUserStack stack = new CiUserStack(app, CiUserStack.CiUserStackProps.builder().projectName("test")
                .addRequiredPermissions(new PolicyReader().readPolicyFromResources("admin-policy.json")).build());
        deployment = cdkRunner.deployStackIfNotExists(app, stack);
        iamAdmin = IamClient.builder().region(Region.AWS_GLOBAL).credentialsProvider(adminCredentialsProvider).build();
        ciUserName = getCiUserName();
        ciUserAccessKey = iamAdmin.createAccessKey(CreateAccessKeyRequest.builder().userName(ciUserName).build())
                .accessKey();
        ciUserCredentialsProvider = StaticCredentialsProvider
                .create(AwsBasicCredentials.create(ciUserAccessKey.accessKeyId(), ciUserAccessKey.secretAccessKey()));
        iamCiUser = IamClient.builder().region(Region.AWS_GLOBAL).credentialsProvider(ciUserCredentialsProvider)
                .build();
        Thread.sleep(20 * 1000);// wait 20s for AWS to sync (it's an eventual consistent system...)
    }

    private static String getCiUserName() {
        final String ciUserName = deployment.getOutputs().get(CiUserStack.OUTPUT_CI_USER_NAME);
        if (ciUserName == null) {
            throw new IllegalStateException("Failed to get ci username from outputs.");
        }
        return ciUserName;
    }

    @AfterAll
    static void afterAll() {
        iamAdmin.deleteAccessKey(DeleteAccessKeyRequest.builder().userName(ciUserName)
                .accessKeyId(ciUserAccessKey.accessKeyId()).build());
        deployment.close();
    }

    @Test
    void testDetachRoleIsNotAllowed() {
        final String accountID = fetchAccountId();
        final Exception exception = assertThrows(Exception.class,
                () -> iamCiUser.detachUserPolicy(DetachUserPolicyRequest.builder().userName("protected-test-ci-user")
                        .policyArn("arn:aws:iam::" + accountID + ":policy/protected-test-ci-user-policy-1").build()));
        assertThat(exception.getMessage(), containsString("with an explicit deny"));
    }

    @Test
    void testCiUserCanNotDeleteCleanUpCodebuild() {
        final CodeBuildClient codeBuild = CodeBuildClient.builder().credentialsProvider(ciUserCredentialsProvider)
                .build();
        final Exception exception = assertThrows(Exception.class,
                () -> codeBuild.deleteProject(DeleteProjectRequest.builder().name(AWS_ACCOUNT_CLEANUP_RUNNER).build()));
        assertThat(exception.getMessage(), containsString("is not authorized"));
    }

    @Test
    void testCiUserCanRunCleanUpCodebuild() {
        final CodeBuildClient codeBuild = CodeBuildClient.builder().credentialsProvider(ciUserCredentialsProvider)
                .build();
        assertDoesNotThrow(() -> codeBuild
                .startBuild(StartBuildRequest.builder().projectName(AWS_ACCOUNT_CLEANUP_RUNNER).build()));
    }

    @Test
    void testCiUserCanNotCreateProtectedUser() {
        final String userName = "protected-my-user";
        try {
            final Exception exception = assertThrows(Exception.class,
                    () -> iamCiUser.createUser(CreateUserRequest.builder().userName(userName).build()));
            assertThat(exception.getMessage(), containsString("with an explicit deny"));
        } finally {
            deleteUSerIfExists(userName);
        }
    }

    @Test
    void testCiUserCanCreateUser() {
        final String userName = "test-user";
        try {
            assertDoesNotThrow(() -> iamCiUser.createUser(CreateUserRequest.builder().userName(userName).build()));
        } finally {
            deleteUSerIfExists(userName);
        }
    }

    private void deleteUSerIfExists(final String userName) {
        try {
            iamAdmin.deleteUser(DeleteUserRequest.builder().userName(userName).build());
        } catch (final NoSuchEntityException exception) {
            // ignore
        }
    }

    private String fetchAccountId() {
        final StsClient sts = StsClient.builder().region(Region.AWS_GLOBAL)
                .credentialsProvider(ciUserCredentialsProvider).build();
        return sts.getCallerIdentity().account();
    }
}
