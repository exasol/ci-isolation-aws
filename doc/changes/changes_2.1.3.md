# CI Isolation AWS 2.1.3, released 2025-??-??

Code name: Fixed vulnerability CVE-2025-55163 in io.netty:netty-codec-http2:jar:4.1.118.Final:test

## Summary

This release fixes the following vulnerability:

### CVE-2025-55163 (CWE-770) in dependency `io.netty:netty-codec-http2:jar:4.1.118.Final:test`
Netty is an asynchronous, event-driven network application framework. Prior to versions 4.1.124.Final and 4.2.4.Final, Netty is vulnerable to MadeYouReset DDoS. This is a logical vulnerability in the HTTP/2 protocol, that uses malformed HTTP/2 control frames in order to break the max concurrent streams limit - which results in resource exhaustion and distributed denial of service. This issue has been patched in versions 4.1.124.Final and 4.2.4.Final.
#### References
* https://ossindex.sonatype.org/vulnerability/CVE-2025-55163?component-type=maven&component-name=io.netty%2Fnetty-codec-http2&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2025-55163
* https://github.com/advisories/GHSA-prj3-ccx8-p6x4

## Security

* #46: Fixed vulnerability CVE-2025-55163 in dependency `io.netty:netty-codec-http2:jar:4.1.118.Final:test`

## Dependency Updates

### Compile Dependency Updates

* Updated `com.google.code.gson:gson:2.12.1` to `2.13.1`
* Updated `software.amazon.awscdk:aws-cdk-lib:2.189.0` to `2.211.0`

### Test Dependency Updates

* Updated `org.junit.jupiter:junit-jupiter-api:5.12.1` to `5.13.4`
* Updated `software.amazon.awssdk:cloudformation:2.31.20` to `2.32.23`
* Updated `software.amazon.awssdk:codebuild:2.31.20` to `2.32.23`
* Updated `software.amazon.awssdk:iam:2.31.20` to `2.32.23`
* Updated `software.amazon.awssdk:sts:2.31.20` to `2.32.23`

### Plugin Dependency Updates

* Updated `com.exasol:project-keeper-maven-plugin:5.0.1` to `5.2.3`
