# CI Isolation AWS 2.2.2, released 2026-??-??

Code name: Fixed vulnerability CVE-2026-41417 in io.netty:netty-codec-http:jar:4.2.12.Final:test

## Summary

This release fixes the following vulnerability:

### CVE-2026-41417 (CWE-93) in dependency `io.netty:netty-codec-http:jar:4.2.12.Final:test`
io.netty:netty-codec-http - CRLF Injection
#### References
* https://guide.sonatype.com/vulnerability/CVE-2026-41417?component-type=maven&component-name=io.netty%2Fnetty-codec-http&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-41417
* https://github.com/advisories/GHSA-v8h7-rr48-vmmv

## Security

* #58: Fixed vulnerability CVE-2026-41417 in dependency `io.netty:netty-codec-http:jar:4.2.12.Final:test`

## Dependency Updates

### Compile Dependency Updates

* Updated `com.google.code.gson:gson:2.13.2` to `2.14.0`
* Updated `software.amazon.awscdk:aws-cdk-lib:2.245.0` to `2.253.0`

### Test Dependency Updates

* Updated `org.junit.jupiter:junit-jupiter-api:5.13.4` to `6.0.3`
* Updated `software.amazon.awssdk:cloudformation:2.42.24` to `2.44.4`
* Updated `software.amazon.awssdk:codebuild:2.42.24` to `2.44.4`
* Updated `software.amazon.awssdk:iam:2.42.24` to `2.44.4`
* Updated `software.amazon.awssdk:sts:2.42.24` to `2.44.4`

### Plugin Dependency Updates

* Updated `com.exasol:project-keeper-maven-plugin:5.4.6` to `5.6.1`
