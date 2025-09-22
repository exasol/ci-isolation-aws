# CI Isolation AWS 2.1.4, released 2025-??-??

Code name: Fixed vulnerability CVE-2025-58056 in io.netty:netty-codec-http:jar:4.1.118.Final:test

## Summary

This release fixes the following vulnerability:

### CVE-2025-58056 (CWE-444) in dependency `io.netty:netty-codec-http:jar:4.1.118.Final:test`
Netty is an asynchronous event-driven network application framework for development of maintainable high performance protocol servers and clients. In versions 4.1.124.Final, and 4.2.0.Alpha3 through 4.2.4.Final, Netty incorrectly accepts standalone newline characters (LF) as a chunk-size line terminator, regardless of a preceding carriage return (CR), instead of requiring CRLF per HTTP/1.1 standards. When combined with reverse proxies that parse LF differently (treating it as part of the chunk extension), attackers can craft requests that the proxy sees as one request but Netty processes as two, enabling request smuggling attacks. This is fixed in versions 4.1.125.Final and 4.2.5.Final.
#### References
* https://ossindex.sonatype.org/vulnerability/CVE-2025-58056?component-type=maven&component-name=io.netty%2Fnetty-codec-http&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2025-58056
* https://github.com/netty/netty/security/advisories/GHSA-fghv-69vj-qj49

## Security

* #51: Fixed vulnerability CVE-2025-58056 in dependency `io.netty:netty-codec-http:jar:4.1.118.Final:test`

## Dependency Updates

### Compile Dependency Updates

* Updated `com.google.code.gson:gson:2.12.1` to `2.13.2`
* Updated `org.yaml:snakeyaml:2.4` to `2.5`
* Updated `software.amazon.awscdk:aws-cdk-lib:2.189.0` to `2.215.0`

### Test Dependency Updates

* Updated `org.junit.jupiter:junit-jupiter-api:5.12.1` to `5.13.4`
* Updated `software.amazon.awssdk:cloudformation:2.31.20` to `2.34.0`
* Updated `software.amazon.awssdk:codebuild:2.31.20` to `2.34.0`
* Updated `software.amazon.awssdk:iam:2.31.20` to `2.34.0`
* Updated `software.amazon.awssdk:sts:2.31.20` to `2.34.0`
