package com.exasol.ciisolation.aws;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

class AccountCleanupAppTest {
    @Test
    void synthApp() {
        assertDoesNotThrow(() -> AccountCleanupApp.main(null));
    }
}
