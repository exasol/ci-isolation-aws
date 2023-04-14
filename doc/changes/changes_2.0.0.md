# CI Isolation AWS 2.0.0, released 2023-04-14

Code name: Upgrade to AWS CDK v2

## Summary

This release upgrades AWS CDK from v1 to v2 which is a breaking change. See the [AWS CDK migration guide](https://docs.aws.amazon.com/cdk/v2/guide/migrating-v2.html) for details.

## Features

* #24: Upgraded to AWS CDK v2

## Bugfixes

* #23: Removed exclude for "E-PK-CORE-53 dependencies.md file has outdated content"

## Dependency Updates

### Compile Dependency Updates

* Added `software.amazon.awscdk:aws-cdk-lib:2.74.0`
* Removed `software.amazon.awscdk:codebuild:1.197.0`
* Removed `software.amazon.awscdk:core:1.197.0`
* Removed `software.amazon.awscdk:events-targets:1.197.0`
* Removed `software.amazon.awscdk:events:1.197.0`
* Removed `software.amazon.awscdk:iam:1.197.0`
* Added `software.constructs:constructs:10.1.310`

### Test Dependency Updates

* Removed `org.junit.jupiter:junit-jupiter-engine:5.9.2`
* Added `org.slf4j:slf4j-jdk14:2.0.7`
* Updated `software.amazon.awssdk:cloudformation:2.20.24` to `2.20.46`
* Updated `software.amazon.awssdk:codebuild:2.20.24` to `2.20.46`
* Updated `software.amazon.awssdk:iam:2.20.24` to `2.20.46`
* Updated `software.amazon.awssdk:sts:2.20.24` to `2.20.46`

### Plugin Dependency Updates

* Updated `com.exasol:error-code-crawler-maven-plugin:1.2.2` to `1.2.3`
* Updated `com.exasol:project-keeper-maven-plugin:2.9.4` to `2.9.7`
* Updated `org.apache.maven.plugins:maven-compiler-plugin:3.10.1` to `3.11.0`
* Updated `org.apache.maven.plugins:maven-deploy-plugin:3.1.0` to `3.1.1`
* Updated `org.apache.maven.plugins:maven-enforcer-plugin:3.2.1` to `3.3.0`
* Updated `org.apache.maven.plugins:maven-javadoc-plugin:3.4.1` to `3.5.0`
* Updated `org.apache.maven.plugins:maven-surefire-plugin:3.0.0-M8` to `3.0.0`
* Added `org.basepom.maven:duplicate-finder-maven-plugin:1.5.1`
* Updated `org.codehaus.mojo:flatten-maven-plugin:1.3.0` to `1.4.1`
* Updated `org.codehaus.mojo:versions-maven-plugin:2.14.2` to `2.15.0`
* Updated `org.jacoco:jacoco-maven-plugin:0.8.8` to `0.8.9`
