package com.exasol.ciisolation.aws.cleanup;

import org.jetbrains.annotations.NotNull;

import com.exasol.errorreporting.ExaError;

import software.amazon.awscdk.services.codebuild.BuildSpec;

/**
 * This class builds a config for an AWS CodeBuild that runs aws-nuke for cleaning up the AWS account.
 */
class AwsAccountCleanerBuildSpec extends BuildSpec {
    public static final String AWS_NUKE_CONFIG = "aws-nuke-config.yml";
    private final String buildSpec;
    private final String accountId;

    /**
     * Create a new instance of {@link AwsAccountCleanerBuildSpec}.
     * 
     * @param accountId aws account id
     */
    AwsAccountCleanerBuildSpec(final String accountId) {
        this.accountId = accountId;
        this.buildSpec = new BuildSpecBuilder()//
                .addInstallSteps(getInstallSteps())
                .addInstallSteps("aws-nuke --config " + AWS_NUKE_CONFIG + " --force --force-sleep 3 --no-dry-run")//
                .build();
    }

    @NotNull
    private String[] getInstallSteps() {
        return new String[] { getWriteToFileCommand(getAwsNukeConfig(), AWS_NUKE_CONFIG), //
                "cat aws-nuke-config.yml", //
                "wget -q https://github.com/rebuy-de/aws-nuke/releases/download/v2.15.0/aws-nuke-v2.15.0-linux-amd64.tar.gz -O aws-nuke.tar.gz", //
                "tar -xvzf aws-nuke.tar.gz", //
                "mv aws-nuke-v2.15.0-linux-amd64 /bin/aws-nuke", //
                "chmod +x /bin/aws-nuke" };
    }

    private String getWriteToFileCommand(final String content, final String fileName) {
        if (content.contains("\nEOL\n")) {
            throw new IllegalArgumentException(ExaError.messageBuilder("E-CI2-AWS-2").message(
                    "Failed to build write-to-file-command. The content contained '\\nEOF\\n' which is not allowed. Content:\n {{content}}",
                    content).toString());
        }
        return "cat >> '" + fileName.replace("'", "") + "' <<-EOF\n" + content + "\nEOF\n";
    }

    private String getAwsNukeConfig() {
        return new StringResourceReader().readResourceAsString(AWS_NUKE_CONFIG).replace("ACCOUNT_ID", this.accountId);
    }

    @Override
    public @NotNull String toBuildSpec() {
        return this.buildSpec;
    }

    @Override
    public @NotNull Boolean getIsImmediate() {
        return true;
    }
}
