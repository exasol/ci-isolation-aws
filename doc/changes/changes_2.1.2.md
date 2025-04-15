# CI Isolation AWS 2.1.2, released 2025-04-15

Code name: Support External ID to assume Role

## Summary

This release supports specifying External IDs that will be required in the AssumeRole calls.

## Features

* #44: Support External ID to assume role

## Dependency Updates

### Compile Dependency Updates

* Updated `software.amazon.awscdk:aws-cdk-lib:2.182.0` to `2.189.0`

### Test Dependency Updates

* Updated `org.junit.jupiter:junit-jupiter-api:5.11.4` to `5.12.1`
* Updated `software.amazon.awssdk:cloudformation:2.30.34` to `2.31.20`
* Updated `software.amazon.awssdk:codebuild:2.30.34` to `2.31.20`
* Updated `software.amazon.awssdk:iam:2.30.34` to `2.31.20`
* Updated `software.amazon.awssdk:sts:2.30.34` to `2.31.20`

### Plugin Dependency Updates

* Updated `com.exasol:project-keeper-maven-plugin:4.5.0` to `5.0.1`
* Added `io.github.git-commit-id:git-commit-id-maven-plugin:9.0.1`
* Removed `io.github.zlika:reproducible-build-maven-plugin:0.17`
* Added `org.apache.maven.plugins:maven-artifact-plugin:3.6.0`
* Updated `org.apache.maven.plugins:maven-clean-plugin:3.4.0` to `3.4.1`
* Updated `org.apache.maven.plugins:maven-compiler-plugin:3.13.0` to `3.14.0`
* Updated `org.apache.maven.plugins:maven-deploy-plugin:3.1.3` to `3.1.4`
* Updated `org.apache.maven.plugins:maven-install-plugin:3.1.3` to `3.1.4`
* Updated `org.apache.maven.plugins:maven-javadoc-plugin:3.11.1` to `3.11.2`
* Updated `org.codehaus.mojo:flatten-maven-plugin:1.6.0` to `1.7.0`
