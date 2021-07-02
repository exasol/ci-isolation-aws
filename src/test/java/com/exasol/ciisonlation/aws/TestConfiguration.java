package com.exasol.ciisonlation.aws;

public class TestConfiguration {
    private final String awsProfile;
    private final String owner;

    public TestConfiguration(final String awsProfile, final String owner) {
        this.awsProfile = awsProfile;
        this.owner = owner;
    }

    public String getAwsProfile() {
        return this.awsProfile;
    }

    public String getOwner() {
        return this.owner;
    }
}
