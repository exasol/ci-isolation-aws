package com.exasol.ciisonlation.aws.cleanup;

import java.io.IOException;
import java.util.Objects;

import com.exasol.errorreporting.ExaError;

/**
 * This class reads a file from the resources as string.
 */
class StringResourceReader {
    /**
     * Read a file from the resources as string.
     * 
     * @param resourceName resource name
     * @return read string
     */
    String readResourceAsString(final String resourceName) {
        try {
            return new String(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(resourceName))
                    .readAllBytes());
        } catch (final IOException | NullPointerException exception) {
            throw new IllegalStateException(ExaError.messageBuilder("F-CI2-AWS-1")
                    .message("Failed to read required resource {{resource}}.", resourceName).ticketMitigation()
                    .toString(), exception);
        }
    }
}
