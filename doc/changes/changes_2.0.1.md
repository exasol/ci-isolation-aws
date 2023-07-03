# CI Isolation AWS 2.0.1, released 2023-07-03

Code name: Update dependencies on top of 2.0.0

## Summary

This releases fixes vulnerabilities in the following dependencies:

* `software.amazon.awscdk:aws-cdk-lib:jar:2.74.0` (compile dependency)
  * CVE-2023-35165, severity CWE-266: Incorrect Privilege Assignment (6.6)
* `io.netty:netty-handler` (test dependency)
  * CVE-2023-34462, severity CWE-770: Allocation of Resources Without Limits or Throttling (6.5)

## Security

* #27: Updated dependencies

## Dependency Updates

### Compile Dependency Updates

* Updated `software.amazon.awscdk:aws-cdk-lib:2.74.0` to `2.86.0`
* Updated `software.constructs:constructs:10.1.310` to `10.2.67`

### Test Dependency Updates

* Updated `org.junit.jupiter:junit-jupiter-api:5.9.2` to `5.9.3`
* Updated `software.amazon.awssdk:cloudformation:2.20.46` to `2.20.97`
* Updated `software.amazon.awssdk:codebuild:2.20.46` to `2.20.97`
* Updated `software.amazon.awssdk:iam:2.20.46` to `2.20.97`
* Updated `software.amazon.awssdk:sts:2.20.46` to `2.20.97`
