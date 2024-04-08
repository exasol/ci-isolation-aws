# CI Isolation AWS 2.0.3, released 2024-04-08

Code name: Fix CVE-2024-29025 in `io.netty:netty-codec-http:jar:4.1.100.Final:test`

## Summary

This release fixes vulnerability CVE-2024-29025 in `io.netty:netty-codec-http:jar:4.1.100.Final:test`.

## Security

* #31: Fixed CVE-2024-29025 in `io.netty:netty-codec-http:jar:4.1.100.Final:test`

## Dependency Updates

### Compile Dependency Updates

* Updated `software.amazon.awscdk:aws-cdk-lib:2.110.0` to `2.136.0`

### Test Dependency Updates

* Updated `org.junit.jupiter:junit-jupiter-api:5.10.1` to `5.10.2`
* Updated `org.slf4j:slf4j-jdk14:2.0.9` to `2.0.12`
* Updated `software.amazon.awssdk:cloudformation:2.21.27` to `2.25.26`
* Updated `software.amazon.awssdk:codebuild:2.21.27` to `2.25.26`
* Updated `software.amazon.awssdk:iam:2.21.27` to `2.25.26`
* Updated `software.amazon.awssdk:sts:2.21.27` to `2.25.26`

### Plugin Dependency Updates

* Updated `com.exasol:error-code-crawler-maven-plugin:1.3.1` to `2.0.2`
* Updated `com.exasol:project-keeper-maven-plugin:2.9.16` to `4.3.0`
* Updated `org.apache.maven.plugins:maven-compiler-plugin:3.11.0` to `3.13.0`
* Updated `org.apache.maven.plugins:maven-gpg-plugin:3.1.0` to `3.2.2`
* Updated `org.apache.maven.plugins:maven-javadoc-plugin:3.6.2` to `3.6.3`
* Updated `org.apache.maven.plugins:maven-surefire-plugin:3.2.2` to `3.2.5`
* Added `org.apache.maven.plugins:maven-toolchains-plugin:3.1.0`
* Updated `org.codehaus.mojo:flatten-maven-plugin:1.5.0` to `1.6.0`
* Updated `org.codehaus.mojo:versions-maven-plugin:2.16.1` to `2.16.2`
* Updated `org.jacoco:jacoco-maven-plugin:0.8.11` to `0.8.12`
* Updated `org.sonarsource.scanner.maven:sonar-maven-plugin:3.10.0.2594` to `3.11.0.3922`
