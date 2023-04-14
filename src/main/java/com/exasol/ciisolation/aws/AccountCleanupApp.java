package com.exasol.ciisolation.aws;

import com.exasol.ciisolation.aws.cleanup.AccountCleanupStack;

import software.amazon.awscdk.App;

/**
 * Entry point class of the CDK app.
 */
public class AccountCleanupApp {
    /**
     * Entry point of the CDK app.
     * 
     * @param args arguments
     */
    public static void main(final String[] args) {
        final App app = new App();
        new AccountCleanupStack(app);
        app.synth();
    }
}
