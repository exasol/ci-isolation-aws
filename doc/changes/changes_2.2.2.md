# CI Isolation AWS 2.2.2, released 2026-06-09

Code name: Fix 10 vulnerabilities in Netty test dependencies

## Summary

This release fixes 10 vulnerabilities in Netty test dependencies.

## Security

* #69: Fixed CVE-2026-48043 in `io.netty:netty-codec-http2:jar:4.2.12.Final:test`
* #67: Fixed CVE-2026-42577 in `io.netty:netty-transport-classes-epoll:jar:4.2.12.Final:test`
* #66: Fixed CVE-2026-42587 in `io.netty:netty-codec-http2:jar:4.2.12.Final:test`
* #65: Fixed CVE-2026-42583 in `io.netty:netty-codec-compression:jar:4.2.12.Final:test`
* #64: Fixed CVE-2026-42587 in `io.netty:netty-codec-http:jar:4.2.12.Final:test`
* #63: Fixed CVE-2026-42585 in `io.netty:netty-codec-http:jar:4.2.12.Final:test`
* #62: Fixed CVE-2026-42584 in `io.netty:netty-codec-http:jar:4.2.12.Final:test`
* #61: Fixed CVE-2026-42581 in `io.netty:netty-codec-http:jar:4.2.12.Final:test`
* #60: Fixed CVE-2026-42580 in `io.netty:netty-codec-http:jar:4.2.12.Final:test`
* #58: Fixed CVE-2026-41417 in `io.netty:netty-codec-http:jar:4.2.12.Final:test`

## Dependency Updates

### Compile Dependency Updates

* Updated `com.google.code.gson:gson:2.13.2` to `2.14.0`
* Updated `software.amazon.awscdk:aws-cdk-lib:2.245.0` to `2.258.1`

### Test Dependency Updates

* Updated `org.junit.jupiter:junit-jupiter-api:5.13.4` to `5.14.4`
* Updated `org.slf4j:slf4j-jdk14:2.0.17` to `2.0.18`
* Updated `software.amazon.awssdk:cloudformation:2.42.24` to `2.46.6`
* Updated `software.amazon.awssdk:codebuild:2.42.24` to `2.46.6`
* Updated `software.amazon.awssdk:iam:2.42.24` to `2.46.6`
* Added `software.amazon.awssdk:signin:2.46.6`
* Updated `software.amazon.awssdk:sts:2.42.24` to `2.46.6`

### Plugin Dependency Updates

* Updated `com.exasol:error-code-crawler-maven-plugin:2.0.6` to `2.0.7`
* Updated `com.exasol:project-keeper-maven-plugin:5.4.6` to `5.6.2`
* Updated `io.github.git-commit-id:git-commit-id-maven-plugin:9.0.2` to `10.0.0`
* Added `org.apache.maven.plugins:maven-failsafe-plugin:3.5.5`
* Updated `org.apache.maven.plugins:maven-resources-plugin:3.4.0` to `3.5.0`
* Updated `org.apache.maven.plugins:maven-surefire-plugin:3.5.4` to `3.5.5`
* Updated `org.codehaus.mojo:exec-maven-plugin:3.1.0` to `3.6.3`
