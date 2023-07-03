package com.exasol.ciisolation.aws.cleanup;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.exasol.errorreporting.ExaError;

import software.amazon.awscdk.services.codebuild.BuildSpec;
import software.constructs.Construct;

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
                "export version=2.21.2", //
                "wget --quiet https://github.com/rebuy-de/aws-nuke/releases/download/v${version}/aws-nuke-v${version}-linux-amd64.tar.gz --output-document=aws-nuke.tar.gz", //
                "echo \"1a2ba281d5baac1119b40da3a4b08de28221d0ce55a92169aa99f2b86ff991c2  aws-nuke.tar.gz\" | shasum --check --algorithm 256 --binary",
                "tar -xvzf aws-nuke.tar.gz", //
                "mv aws-nuke-v${version}-linux-amd64 /bin/aws-nuke", //
                "chmod +x /bin/aws-nuke" };
    }

    private String getWriteToFileCommand(final String content, final String fileName) {
        if (content.contains("\nEOL\n")) {
            throw new IllegalArgumentException(ExaError.messageBuilder("E-CI2AWS-2").message(
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
    public @NotNull String toBuildSpec(@Nullable final Construct scope) {
        return this.toBuildSpec();
    }

    @Override
    public @NotNull Boolean getIsImmediate() {
        return true;
    }
}
