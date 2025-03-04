# CI Isolation AWS 2.1.0, released 2025-03-05

Code name: Support creation of roles

## Summary

This release adds the possibility to create roles with the CiUserStack using the `createRole` property and the
`roleRequiredPermissions` to set specific permissions for the role.

It also sets up the `SECURITY.md` for the repository. 

## Features

* #40: Support the creation of Roles in the CiUserStack 

## Dependency Updates

### Compile Dependency Updates

* Updated `org.yaml:snakeyaml:2.3` to `2.4`
* Updated `software.amazon.awscdk:aws-cdk-lib:2.178.2` to `2.181.1`

### Test Dependency Updates

* Updated `org.slf4j:slf4j-jdk14:2.0.16` to `2.0.17`
* Updated `software.amazon.awssdk:cloudformation:2.30.20` to `2.30.32`
* Updated `software.amazon.awssdk:codebuild:2.30.20` to `2.30.32`
* Updated `software.amazon.awssdk:iam:2.30.20` to `2.30.32`
* Updated `software.amazon.awssdk:sts:2.30.20` to `2.30.32`
