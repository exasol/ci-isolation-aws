# CI Isolation AWS 2.0.5, released 2025-02-14

Code name: Fixed CVE-2025-24970 and CVE-2025-25193

## Summary

This update fixes CVE-2025-24970 and CVE-2025-25193 in transitive `netty` dependency.
It also updates other dependencies.

## Security

* #36: Fixed CVE-2025-25193
* #37: Fixed CVE-2025-24970

## Dependency Updates

### Compile Dependency Updates

* Updated `com.google.code.gson:gson:2.11.0` to `2.12.1`
* Updated `software.amazon.awscdk:aws-cdk-lib:2.167.1` to `2.178.2`

### Test Dependency Updates

* Updated `org.junit.jupiter:junit-jupiter-api:5.11.3` to `5.11.4`
* Updated `software.amazon.awssdk:cloudformation:2.29.15` to `2.30.20`
* Updated `software.amazon.awssdk:codebuild:2.29.15` to `2.30.20`
* Updated `software.amazon.awssdk:iam:2.29.15` to `2.30.20`
* Updated `software.amazon.awssdk:sts:2.29.15` to `2.30.20`

### Plugin Dependency Updates

* Updated `com.exasol:project-keeper-maven-plugin:4.4.0` to `4.5.0`
* Updated `org.apache.maven.plugins:maven-deploy-plugin:3.1.2` to `3.1.3`
* Updated `org.apache.maven.plugins:maven-javadoc-plugin:3.10.1` to `3.11.1`
* Updated `org.apache.maven.plugins:maven-site-plugin:3.9.1` to `3.21.0`
* Updated `org.apache.maven.plugins:maven-surefire-plugin:3.5.1` to `3.5.2`
* Updated `org.codehaus.mojo:versions-maven-plugin:2.17.1` to `2.18.0`
* Updated `org.sonarsource.scanner.maven:sonar-maven-plugin:4.0.0.4121` to `5.0.0.4389`
