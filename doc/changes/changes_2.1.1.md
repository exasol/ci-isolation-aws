# CI Isolation AWS 2.1.1, released 2025-03-06

Code name: Allow user to assume role

## Summary

This release fixes an issue with the new create role feature. By default, the created user was not 
allowed to assume the role, only the root user in the account.
With the fix the created user can assume the role.

## Bugfixes

* #42: User is not allowed to assume role

## Dependency Updates

### Compile Dependency Updates

* Updated `software.amazon.awscdk:aws-cdk-lib:2.181.1` to `2.182.0`

### Test Dependency Updates

* Updated `software.amazon.awssdk:cloudformation:2.30.32` to `2.31.20`
* Updated `software.amazon.awssdk:codebuild:2.30.32` to `2.31.20`
* Updated `software.amazon.awssdk:iam:2.30.32` to `2.31.20`
* Updated `software.amazon.awssdk:sts:2.30.32` to `2.31.20`

### Plugin Dependency Updates

* Updated `com.exasol:project-keeper-maven-plugin:4.5.0` to `5.0.1`
