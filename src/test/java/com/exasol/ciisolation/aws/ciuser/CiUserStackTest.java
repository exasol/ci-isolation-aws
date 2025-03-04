package com.exasol.ciisolation.aws.ciuser;

import com.exasol.ciisolation.aws.PolicyReader;
import org.junit.jupiter.api.Test;
import software.amazon.awscdk.App;
import software.amazon.awscdk.assertions.Template;

import java.util.Map;

import static com.exasol.ciisolation.aws.ciuser.CiUserStack.OUTPUT_CI_ROLE_ARN;
import static com.exasol.ciisolation.aws.ciuser.CiUserStack.OUTPUT_CI_USER_NAME;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

class CiUserStackTest {

    @Test
    void testStack() {
        final PolicyReader policyReader = new PolicyReader();
        final CiUserStack stack = new CiUserStack(new App(), CiUserStack.CiUserStackProps.builder().projectName("dummy-project")
                .addRequiredPermissions(policyReader.readPolicyFromResources("test-permissions.json")).build());

        final Template template = Template.fromStack(stack);
        assertOutputs(template, OUTPUT_CI_USER_NAME);
    }

    @Test
    void testStackWithRole() {
        final PolicyReader policyReader = new PolicyReader();
        final CiUserStack stack = new CiUserStack(new App(), CiUserStack.CiUserStackProps.builder().projectName("dummy-project")
                .createRole(true)
                .addRequiredPermissions(policyReader.readPolicyFromResources("test-permissions.json")).build());

        final Template template = Template.fromStack(stack);
        assertOutputs(template, OUTPUT_CI_USER_NAME, OUTPUT_CI_ROLE_ARN);
    }

    private void assertOutputs(final Template template, final String... outputNames) {
        final Map<String, Map<String, Object>> outputs = template.findOutputs("*");
        assertThat(outputs.keySet(), contains(outputNames));
    }
}
