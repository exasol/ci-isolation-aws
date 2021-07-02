package com.exasol.ciisonlation.aws.cleanup;

import java.io.StringWriter;
import java.util.*;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

/**
 * This class is a String-Builder for AWS CodeBuild build specs.
 */
class BuildSpecBuilder {
    private final List<String> installSteps = new ArrayList<>();
    private final List<String> buildSteps = new ArrayList<>();

    /**
     * Add installation steps.
     * 
     * @param commands shell commands
     * @return self for fluent programming
     */
    public BuildSpecBuilder addInstallSteps(final String... commands) {
        this.installSteps.addAll(Arrays.asList(commands));
        return this;
    }

    /**
     * Add build steps.
     * 
     * @param commands shell commands
     * @return self for fluent programming
     */
    public BuildSpecBuilder addBuildSteps(final String... commands) {
        this.buildSteps.addAll(Arrays.asList(commands));
        return this;
    }

    /**
     * Build the build spec.
     * 
     * @return built build-spec (string)
     */
    public String build() {
        final Map<String, Object> document = new LinkedHashMap<>();
        document.put("version", 0.2);
        document.put("phases", buildPhases());
        return renderAsYaml(document);
    }

    private String renderAsYaml(final Map<String, Object> document) {
        final DumperOptions options = new DumperOptions();
        options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
        final Yaml yaml = new Yaml(options);
        final StringWriter writer = new StringWriter();
        yaml.dump(document, writer);
        return writer.toString();
    }

    private Object buildPhases() {
        final LinkedHashMap<String, Object> phases = new LinkedHashMap<>();
        if (!this.installSteps.isEmpty()) {
            phases.put("install", buildPhase(this.installSteps));
        }
        if (!this.buildSteps.isEmpty()) {
            phases.put("build", buildPhase(this.buildSteps));
        }
        return phases;
    }

    private Object buildPhase(final List<String> commands) {
        final LinkedHashMap<String, Object> phase = new LinkedHashMap<>();
        phase.put("commands", commands);
        return phase;
    }
}
