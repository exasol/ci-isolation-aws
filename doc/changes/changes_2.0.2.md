# CI Isolation AWS 2.0.2, released 2023-11-21

Code name: Upgrade dependencies on top of 2.0.1

## Summary

This release upgrades dependencies.

**Note:** we ignore vulnerability CVE-2023-4586 in transitive test dependency `io.netty:netty-handler` used by `software.amazon.awssdk` because the AWS SDK is not affected by this vulnerability, see https://github.com/aws/aws-sdk-java-v2/issues/4584 for details.

## Features

* #29: Ignored vulnerability CVE-2023-4586 in test dependency `io.netty:netty-handler`

## Dependency Updates

### Compile Dependency Updates

* Updated `org.yaml:snakeyaml:2.0` to `2.2`
* Updated `software.amazon.awscdk:aws-cdk-lib:2.86.0` to `2.110.0`
* Updated `software.constructs:constructs:10.2.67` to `10.3.0`

### Test Dependency Updates

* Updated `org.junit.jupiter:junit-jupiter-api:5.9.3` to `5.10.1`
* Updated `org.slf4j:slf4j-jdk14:2.0.7` to `2.0.9`
* Updated `software.amazon.awssdk:cloudformation:2.20.97` to `2.21.27`
* Updated `software.amazon.awssdk:codebuild:2.20.97` to `2.21.27`
* Updated `software.amazon.awssdk:iam:2.20.97` to `2.21.27`
* Updated `software.amazon.awssdk:sts:2.20.97` to `2.21.27`

### Plugin Dependency Updates

* Updated `com.exasol:error-code-crawler-maven-plugin:1.2.3` to `1.3.1`
* Updated `com.exasol:project-keeper-maven-plugin:2.9.7` to `2.9.16`
* Updated `org.apache.maven.plugins:maven-enforcer-plugin:3.3.0` to `3.4.1`
* Updated `org.apache.maven.plugins:maven-gpg-plugin:3.0.1` to `3.1.0`
* Updated `org.apache.maven.plugins:maven-javadoc-plugin:3.5.0` to `3.6.2`
* Updated `org.apache.maven.plugins:maven-surefire-plugin:3.0.0` to `3.2.2`
* Updated `org.basepom.maven:duplicate-finder-maven-plugin:1.5.1` to `2.0.1`
* Updated `org.codehaus.mojo:flatten-maven-plugin:1.4.1` to `1.5.0`
* Updated `org.codehaus.mojo:versions-maven-plugin:2.15.0` to `2.16.1`
* Updated `org.jacoco:jacoco-maven-plugin:0.8.9` to `0.8.11`
* Updated `org.sonarsource.scanner.maven:sonar-maven-plugin:3.9.1.2184` to `3.10.0.2594`
