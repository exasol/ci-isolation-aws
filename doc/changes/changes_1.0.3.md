# CI Isolation AWS 1.0.3, released 2023-03-15

Code name: Keep protected roles and CDK Bootstrap stack

## Summary

This release filters roles with "protected" prefix and CDK Bootstrap stack resources. It also upgrades dependency snakeyaml to fix CVE-2022-38752.

## Bugfixes

* #20: Upgrade snakeyaml and other dependencies
* #19: Don't delete roles with "protected" prefix.

## Dependency Updates

### Compile Dependency Updates

* Updated `com.exasol:error-reporting-java:1.0.0` to `1.0.1`
* Updated `com.google.code.gson:gson:2.9.1` to `2.10.1`
* Updated `org.yaml:snakeyaml:1.33` to `2.0`
* Updated `software.amazon.awscdk:codebuild:1.174.0` to `1.197.0`
* Updated `software.amazon.awscdk:core:1.174.0` to `1.197.0`
* Updated `software.amazon.awscdk:events-targets:1.174.0` to `1.197.0`
* Updated `software.amazon.awscdk:events:1.174.0` to `1.197.0`
* Updated `software.amazon.awscdk:iam:1.174.0` to `1.197.0`

### Test Dependency Updates

* Removed `commons-codec:commons-codec:1.15`
* Updated `org.junit.jupiter:junit-jupiter-api:5.9.1` to `5.9.2`
* Updated `org.junit.jupiter:junit-jupiter-engine:5.9.1` to `5.9.2`
* Updated `software.amazon.awssdk:cloudformation:2.17.282` to `2.20.24`
* Updated `software.amazon.awssdk:codebuild:2.17.282` to `2.20.24`
* Updated `software.amazon.awssdk:iam:2.17.282` to `2.20.24`
* Updated `software.amazon.awssdk:sts:2.17.282` to `2.20.24`

### Plugin Dependency Updates

* Updated `com.exasol:error-code-crawler-maven-plugin:1.1.2` to `1.2.2`
* Updated `com.exasol:project-keeper-maven-plugin:2.8.0` to `2.9.4`
* Updated `io.github.zlika:reproducible-build-maven-plugin:0.15` to `0.16`
* Updated `org.apache.maven.plugins:maven-deploy-plugin:3.0.0-M1` to `3.1.0`
* Updated `org.apache.maven.plugins:maven-enforcer-plugin:3.1.0` to `3.2.1`
* Updated `org.apache.maven.plugins:maven-javadoc-plugin:3.4.0` to `3.4.1`
* Updated `org.apache.maven.plugins:maven-surefire-plugin:3.0.0-M5` to `3.0.0-M8`
* Updated `org.codehaus.mojo:exec-maven-plugin:3.0.0` to `3.1.0`
* Updated `org.codehaus.mojo:flatten-maven-plugin:1.2.7` to `1.3.0`
* Updated `org.codehaus.mojo:versions-maven-plugin:2.10.0` to `2.14.2`
