package com.exasol.ciisolation.aws.ciuser;

import com.exasol.ciisolation.aws.PolicyReader;
import org.junit.jupiter.api.Test;
import software.amazon.awscdk.App;
import software.amazon.awscdk.assertions.Template;
import software.amazon.awscdk.services.iam.PolicyDocument;

import java.util.Map;

import static com.exasol.ciisolation.aws.ciuser.CiUserStack.OUTPUT_CI_ROLE_NAME;
import static com.exasol.ciisolation.aws.ciuser.CiUserStack.OUTPUT_CI_USER_NAME;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CiUserStackTest {

    private final PolicyReader policyReader = new PolicyReader();

    @Test
    void testStack() {
        final CiUserStack stack = new CiUserStack(new App(), CiUserStack.CiUserStackProps.builder().projectName("dummy-project")
                .addRequiredPermissions(policyReader.readPolicyFromResources("test-permissions.json")).build());

        final Template template = Template.fromStack(stack);
        assertOutputs(template, OUTPUT_CI_USER_NAME);
    }

    @Test
    void testStackWithRole() {
        final PolicyDocument permissions = policyReader.readPolicyFromResources("test-permissions.json");
        final CiUserStack stack = new CiUserStack(new App(), CiUserStack.CiUserStackProps.builder().projectName("dummy-project")
                .createRole(true)
                .addRoleExternalId("12345")
                .addRequiredPermissions(permissions)
                .addRoleRequiredPermissions(permissions).build());

        final Template template = Template.fromStack(stack);
        assertOutputs(template, OUTPUT_CI_USER_NAME, OUTPUT_CI_ROLE_NAME);
    }

    @Test
    void testStackWithoutRoleCannotHaveExternalIds() {
        final CiUserStack.DefaultCiUserStackProps.Builder builder = CiUserStack.CiUserStackProps.builder().projectName("dummy-project")
                .createRole(false)
                .addRoleExternalId("12345");
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, builder::build);
        assertThat(exception.getMessage(), equalTo("Only when createRole is true roleExternalIds can be set"));
    }

    @Test
    void testStackWithoutRoleCannotHaveRolePermissions() {
        final PolicyDocument permissions = policyReader.readPolicyFromResources("test-permissions.json");
        final CiUserStack.DefaultCiUserStackProps.Builder builder = CiUserStack.CiUserStackProps.builder().projectName("dummy-project")
                .createRole(false)
                .addRoleRequiredPermissions(permissions);
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, builder::build);
        assertThat(exception.getMessage(), equalTo("Only when createRole is true roleRequiredPermissions can be set"));
    }

    private void assertOutputs(final Template template, final String... outputNames) {
        final Map<String, Map<String, Object>> outputs = template.findOutputs("*");
        assertThat(outputs.keySet(), contains(outputNames));
    }
}
