# CI Isolation AWS 2.2.2, released 2026-??-??

Code name: Fixed vulnerability CVE-2026-48043 in io.netty:netty-codec-http2:jar:4.2.12.Final:test

## Summary

This release fixes the following vulnerability:

### CVE-2026-48043 (CWE-400) in dependency `io.netty:netty-codec-http2:jar:4.2.12.Final:test`
io.netty : netty-codec-http2 - Denial of Service (DoS)
#### References
* https://guide.sonatype.com/vulnerability/CVE-2026-48043?component-type=maven&component-name=io.netty%2Fnetty-codec-http2&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-48043
* https://github.com/netty/netty/security/advisories/GHSA-c2gf-v879-257j

## Security

* #69: Fixed vulnerability CVE-2026-48043 in dependency `io.netty:netty-codec-http2:jar:4.2.12.Final:test`

## Dependency Updates

### Compile Dependency Updates

* Updated `com.google.code.gson:gson:2.13.2` to `2.14.0`
* Updated `software.amazon.awscdk:aws-cdk-lib:2.245.0` to `2.258.0`

### Test Dependency Updates

* Updated `org.junit.jupiter:junit-jupiter-api:5.13.4` to `6.1.0`
* Updated `org.slf4j:slf4j-jdk14:2.0.17` to `2.0.18`
* Updated `software.amazon.awssdk:cloudformation:2.42.24` to `2.46.6`
* Updated `software.amazon.awssdk:codebuild:2.42.24` to `2.46.6`
* Updated `software.amazon.awssdk:iam:2.42.24` to `2.46.6`
* Updated `software.amazon.awssdk:sts:2.42.24` to `2.46.6`

### Plugin Dependency Updates

* Updated `com.exasol:project-keeper-maven-plugin:5.4.6` to `5.6.2`
