package com.exasol.ciisolation.aws.ciuser;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

import com.exasol.ciisolation.aws.PolicyReader;

import software.amazon.awscdk.App;

class CiUserStackTest {
    @Test
    void synthStack() {
        final App app = new App();
        final PolicyReader policyReader = new PolicyReader();
        new CiUserStack(app, CiUserStack.CiUserStackProps.builder().projectName("dummy-project")
                .addRequiredPermissions(policyReader.readPolicyFromResources("test-permissions.json")).build());
        assertDoesNotThrow(() -> app.synth());
    }
}
