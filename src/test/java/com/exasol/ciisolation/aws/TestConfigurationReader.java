package com.exasol.ciisolation.aws;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

import com.exasol.errorreporting.ExaError;

public class TestConfigurationReader {
    TestConfiguration readConfig() {
        final Map<String, String> configuration = readYaml();
        return new TestConfiguration(getParameter(configuration, "profile"), getParameter(configuration, "owner"));
    }

    private String getParameter(final Map<String, String> configuration, final String parameter) {
        final String value = configuration.get(parameter);
        if (value == null) {
            throw new IllegalArgumentException(ExaError.messageBuilder("E-CI2-AWS-8").message(
                    "Invalid test_config.yaml. The configuration does not contain the required property {{missing property}}.",
                    parameter).toString());
        } else {
            return value;
        }
    }

    private Map<String, String> readYaml() {
        final Yaml yaml = new Yaml();
        try (final FileReader fileReader = new FileReader("test_config.yaml")) {
            return yaml.load(fileReader);
        } catch (final IOException exception) {
            throw new IllegalStateException(ExaError.messageBuilder("E-CI2-AWS-7")
                    .message("Could not open test_config.yaml.")
                    .mitigation("Please create the file according to the description in the README.md.").toString(),
                    exception);
        }
    }
}
