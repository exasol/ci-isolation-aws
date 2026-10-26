# CI Isolation AWS 3.0.2, released 2026-10-26

Code name: Fix 20 vulnerabilities in Jackson and Netty dependencies

## Summary

This release fixes 20 reported vulnerabilities in Jackson compile and Netty test dependencies.

- Fixes #97
- Fixes #98
- Fixes #100
- Fixes #101
- Fixes #102
- Fixes #104
- Fixes #105
- Fixes #106
- Fixes #107
- Fixes #108
- Fixes #109
- Fixes #113
- Fixes #114
- Fixes #115
- Fixes #116
- Fixes #117
- Fixes #118
- Fixes #119
- Fixes #120
- Fixes #122

## Security

* #122: Fixed CVE-2026-110879 (unsafe deserialization, CWE-502, 9.2) in `com.fasterxml.jackson.core:jackson-databind:jar:2.22.2:compile`
* #100: Fixed CVE-2026-91776 (unbounded type ID cache growth, CWE-770, 6.9) in `com.fasterxml.jackson.core:jackson-databind:jar:2.22.2:compile`
* #101: Fixed CVE-2026-91777 (denial of service, CWE-407, 6.9) in `com.fasterxml.jackson.core:jackson-databind:jar:2.22.2:compile`
* #102: Fixed CVE-2026-68498 (unbounded resource allocation, CWE-770, 8.7) in `com.fasterxml.jackson.core:jackson-core:jar:2.22.1:compile`
* #104: Fixed CVE-2026-89407 (regex denial of service, CWE-1333, 7.5) in `com.fasterxml.jackson.core:jackson-core:jar:2.22.1:compile`
* #105: Fixed CVE-2026-89425 (unbounded error token allocation, CWE-400, 7.5) in `com.fasterxml.jackson.core:jackson-core:jar:2.22.1:compile`
* #97: Fixed CVE-2026-89044 (HTTP request smuggling, CWE-444, 6.5) in `io.netty:netty-codec-http2:jar:4.2.17.Final:test`
* #106: Fixed CVE-2026-93492 (HPACK resource exhaustion, CWE-1035, 5.3) in `io.netty:netty-codec-http2:jar:4.2.17.Final:test`
* #107: Fixed CVE-2026-93567 (CONNECT authority validation, CWE-20, 7.5) in `io.netty:netty-codec-http2:jar:4.2.17.Final:test`
* #108: Fixed CVE-2026-93568 (Extended CONNECT misinterpretation, CWE-20, 7.5) in `io.netty:netty-codec-http2:jar:4.2.17.Final:test`
* #109: Fixed CVE-2026-93579 (invalid HTTP/2 header characters, CWE-1035, 6.5) in `io.netty:netty-codec-http2:jar:4.2.17.Final:test`
* #98: Fixed CVE-2026-89044 (HTTP request smuggling, CWE-444, 6.5) in `io.netty:netty-codec-http:jar:4.2.17.Final:test`
* #113: Fixed CVE-2026-93488 (unbounded SPDY streams, CWE-770, 7.5) in `io.netty:netty-codec-http:jar:4.2.17.Final:test`
* #114: Fixed CVE-2026-93491 (unbounded HTTP request queue, CWE-770, 7.5) in `io.netty:netty-codec-http:jar:4.2.17.Final:test`
* #115: Fixed CVE-2026-93558 (WebSocket queue exhaustion, CWE-1035, 7.5) in `io.netty:netty-codec-http:jar:4.2.17.Final:test`
* #116: Fixed CVE-2026-93562 (HTTP request smuggling, CWE-1035, 6.9) in `io.netty:netty-codec-http:jar:4.2.17.Final:test`
* #117: Fixed CVE-2026-93565 (RTSP method token smuggling, CWE-1035, 7.5) in `io.netty:netty-codec-http:jar:4.2.17.Final:test`
* #118: Fixed CVE-2026-93574 (HTTP request smuggling, CWE-444, 6.9) in `io.netty:netty-codec-http:jar:4.2.17.Final:test`
* #119: Fixed CVE-2026-93566 (HTTP request/response smuggling, CWE-444, 6.9) in `io.netty:netty-codec-http:jar:4.2.17.Final:test`
* #120: Fixed CVE-2026-93573 (HTTP interpretation conflict, CWE-436, 6.5) in `io.netty:netty-codec-http:jar:4.2.17.Final:test`

## Dependency Updates

### Plugin Dependency Updates

* Updated `com.exasol:error-code-crawler-maven-plugin:2.1.0` to `2.1.2`
* Updated `com.exasol:project-keeper-maven-plugin:5.7.4` to `5.8.1`
* Updated `io.github.git-commit-id:git-commit-id-maven-plugin:10.0.0` to `10.0.1`
* Updated `org.apache.maven.plugins:maven-artifact-plugin:3.6.1` to `3.7.0`
* Updated `org.apache.maven.plugins:maven-compiler-plugin:3.15.0` to `3.16.0`
* Updated `org.apache.maven.plugins:maven-deploy-plugin:3.1.4` to `3.2.0`
* Updated `org.apache.maven.plugins:maven-install-plugin:3.1.4` to `3.2.0`
* Updated `org.apache.maven.plugins:maven-surefire-plugin:3.5.6` to `3.6.0`
* Updated `org.apache.maven.plugins:maven-toolchains-plugin:3.2.0` to `3.3.0`
* Updated `org.codehaus.mojo:build-helper-maven-plugin:3.6.1` to `3.6.2`
* Updated `org.codehaus.mojo:flatten-maven-plugin:1.7.3` to `1.8.0`
* Updated `org.codehaus.mojo:versions-maven-plugin:2.21.0` to `2.23.0`
* Updated `org.sonarsource.scanner.maven:sonar-maven-plugin:5.7.0.6970` to `5.8.0.7211`
* Updated `org.sonatype.central:central-publishing-maven-plugin:0.11.0` to `0.12.0`
