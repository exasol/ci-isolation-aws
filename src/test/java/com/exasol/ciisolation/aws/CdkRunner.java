package com.exasol.ciisolation.aws;

import static software.amazon.awssdk.services.cloudformation.model.StackStatus.*;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.jetbrains.annotations.NotNull;

import com.exasol.errorreporting.ExaError;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import software.amazon.awscdk.core.App;
import software.amazon.awscdk.core.Stack;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.services.cloudformation.CloudFormationClient;
import software.amazon.awssdk.services.cloudformation.model.*;

public class CdkRunner {
    private static final Logger LOGGER = Logger.getLogger(CdkRunner.class.getName());
    private final ObjectMapper json = new ObjectMapper().configure(SerializationFeature.INDENT_OUTPUT, true);
    private final CloudFormationClient cloudFormation;
    private final String owner;

    public CdkRunner(final AwsCredentialsProvider credentialsProvider, final String owner) {
        this.cloudFormation = CloudFormationClient.builder().credentialsProvider(credentialsProvider).build();
        this.owner = owner;
    }

    public StackDeployment deployStackIfNotExists(final App app, final Stack stack) {
        final String template = getStackTemplate(app, stack);
        final String stackName = stack.getStackName();
        if (describeStack(stackName).isPresent()) {
            LOGGER.warning("Stack already exists. We will reuse it and not deploy again!");
        } else {
            deployStack(template, stackName);
        }
        final Map<String, String> outputs = describeStack(stackName).orElseThrow().outputs().stream()
                .collect(Collectors.toMap(Output::outputKey, Output::outputValue));
        return new StackDeployment(this.cloudFormation, stackName, outputs);
    }

    private void deployStack(final String template, final String stackName) {
        this.cloudFormation.createStack(CreateStackRequest.builder().stackName(stackName).templateBody(template)
                .capabilities(Capability.CAPABILITY_NAMED_IAM)
                .parameters(Parameter.builder().parameterKey("exaOwner").parameterValue(this.owner).build()).build());
        LOGGER.info("Waiting for CloudFormations to create the stack");
        while (!isStackDone(stackName)) {
            sleepFor(1000);
        }
        LOGGER.info("Stack created.");
    }

    private void sleepFor(final long millis) {
        try {
            Thread.sleep(millis);
        } catch (final InterruptedException exception) {
            Thread.currentThread().interrupt();
        }
    }

    private boolean isStackDone(final String stackName) {
        final Optional<software.amazon.awssdk.services.cloudformation.model.Stack> stack = describeStack(stackName);
        if (stack.isPresent()) {
            final StackStatus stackStatus = stack.get().stackStatus();
            if (stackStatus == StackStatus.CREATE_COMPLETE) {
                return true;
            } else if (Set.of(CREATE_IN_PROGRESS, IMPORT_COMPLETE, IMPORT_IN_PROGRESS).contains(stackStatus)) {
                return false;
            } else {
                throw new IllegalStateException(ExaError.messageBuilder("F-CI2-AWS-6")
                        .message("Stack creation failed (status: {{stack status}}).", stackStatus).toString());
            }
        } else {
            return false;
        }
    }

    @NotNull
    private Optional<software.amazon.awssdk.services.cloudformation.model.Stack> describeStack(final String stackName) {
        try {
            return this.cloudFormation.describeStacks(DescribeStacksRequest.builder().stackName(stackName).build())
                    .stacks().stream().findAny();
        } catch (final CloudFormationException exception) {
            if (exception.getMessage().contains("does not exist")) {
                return Optional.empty();
            } else {
                throw exception;
            }
        }
    }

    private String getStackTemplate(final App app, final Stack stack) {
        try {
            return this.json.writeValueAsString(app.synth().getStackArtifact(stack.getArtifactId()).getTemplate());
        } catch (final JsonProcessingException exception) {
            throw new IllegalStateException(ExaError.messageBuilder("F-CI2-AWS-5")
                    .message("Failed to render stack as CloudFormation JSON template.").toString(), exception);
        }
    }

    public static class StackDeployment implements AutoCloseable {
        private final CloudFormationClient cloudFormation;
        private final String stackName;
        private final Map<String, String> outputs;

        private StackDeployment(final CloudFormationClient cloudFormation, final String stackName,
                final Map<String, String> outputs) {
            this.cloudFormation = cloudFormation;
            this.stackName = stackName;
            this.outputs = outputs;
        }

        public Map<String, String> getOutputs() {
            return this.outputs;
        }

        @Override
        public void close() {
            this.cloudFormation.deleteStack(DeleteStackRequest.builder().stackName(this.stackName).build());
            LOGGER.info("Stack deleted.");
        }
    }
}
