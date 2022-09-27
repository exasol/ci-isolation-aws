# CI Isolation AWS 1.0.2, released 2022-09-27

Code name: Fix vulnerabilities in dependencies

## Summary

This release fixes CVE-2022-25857, CVE-2022-38749, CVE-2022-38751, CVE-2022-38752 and CVE-2022-38750 in snakeyaml.

## Features

* #17: Fixed vulnerabilities in dependencies

## Dependency Updates

### Compile Dependency Updates

* Updated `com.exasol:error-reporting-java:0.4.1` to `1.0.0`
* Updated `com.google.code.gson:gson:2.9.0` to `2.9.1`
* Updated `org.yaml:snakeyaml:1.30` to `1.33`
* Updated `software.amazon.awscdk:codebuild:1.161.0` to `1.174.0`
* Updated `software.amazon.awscdk:core:1.161.0` to `1.174.0`
* Updated `software.amazon.awscdk:events-targets:1.161.0` to `1.174.0`
* Updated `software.amazon.awscdk:events:1.161.0` to `1.174.0`
* Updated `software.amazon.awscdk:iam:1.161.0` to `1.174.0`

### Test Dependency Updates

* Updated `org.junit.jupiter:junit-jupiter-api:5.8.2` to `5.9.1`
* Updated `org.junit.jupiter:junit-jupiter-engine:5.8.2` to `5.9.1`
* Updated `software.amazon.awssdk:cloudformation:2.17.217` to `2.17.282`
* Updated `software.amazon.awssdk:codebuild:2.17.217` to `2.17.282`
* Updated `software.amazon.awssdk:iam:2.17.217` to `2.17.282`
* Updated `software.amazon.awssdk:sts:2.17.217` to `2.17.282`

### Plugin Dependency Updates

* Updated `com.exasol:error-code-crawler-maven-plugin:1.1.1` to `1.1.2`
* Updated `com.exasol:project-keeper-maven-plugin:2.4.6` to `2.8.0`
* Updated `org.apache.maven.plugins:maven-enforcer-plugin:3.0.0` to `3.1.0`
