package com.exasol.ciisolation.aws;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

import com.exasol.errorreporting.ExaError;
import com.google.gson.Gson;

/**
 * This class reads a JSON files from resources.
 */
class ResourceAsJsonReader {

    /**
     * Read a JSON files from resources.
     * 
     * @param resourceName resource name
     * @return read JSON as Java object structure (Objects as Map, Arrays as List, ...)
     */
    Object readResourceAsJsonObjects(final String resourceName) {
        final String jsonString = getResourceAsString(resourceName);
        return (new Gson()).fromJson(jsonString, Object.class);
    }

    private String getResourceAsString(final String resourceName) {
        try (final InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(resourceName)) {
            if (resourceAsStream == null) {
                throw new IllegalArgumentException(ExaError.messageBuilder("E-CI2AWS-9")
                        .message("Resource {{resource name}} not found", resourceName).toString());
            }
            return new String(Objects.requireNonNull(resourceAsStream).readAllBytes(), StandardCharsets.UTF_8);
        } catch (final IOException exception) {
            throw new IllegalStateException(exception);
        }
    }
}
