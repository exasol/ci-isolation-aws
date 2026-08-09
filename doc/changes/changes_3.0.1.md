# CI Isolation AWS 3.0.1, released 2026-??-??

Code name: Fixed vulnerability CVE-2026-59903 in io.netty:netty-codec-http:jar:4.2.16.Final:test

## Summary

This release fixes the following vulnerability:

### CVE-2026-59903 (CWE-524) in dependency `io.netty:netty-codec-http:jar:4.2.16.Final:test`
io.netty:netty-codec-http - Use of Cache Containing Sensitive Information
#### References
* https://guide.sonatype.com/vulnerability/CVE-2026-59903?component-type=maven&component-name=io.netty%2Fnetty-codec-http&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-59903
* https://github.com/netty/netty/security/advisories/GHSA-8c42-7qj2-3j46

## Security

* #89: Fixed vulnerability CVE-2026-59903 in dependency `io.netty:netty-codec-http:jar:4.2.16.Final:test`

## Dependency Updates

### Compile Dependency Updates

* Updated `software.amazon.awscdk:aws-cdk-lib:2.262.1` to `2.263.0`
* Updated `software.constructs:constructs:10.7.1` to `10.8.1`

### Test Dependency Updates

* Updated `org.junit.jupiter:junit-jupiter-api:6.1.2` to `6.1.3`
* Updated `software.amazon.awssdk:cloudformation:2.49.4` to `2.51.3`
* Updated `software.amazon.awssdk:codebuild:2.49.4` to `2.51.3`
* Updated `software.amazon.awssdk:iam:2.49.4` to `2.51.3`
* Updated `software.amazon.awssdk:signin:2.49.4` to `2.51.3`
* Updated `software.amazon.awssdk:sts:2.49.4` to `2.51.3`
