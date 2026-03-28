# CI Isolation AWS 2.2.1, released 2026-??-??

Code name: Fixed vulnerabilities CVE-2026-33870, CVE-2026-33871

## Summary

This release fixes the following 2 vulnerabilities:

### CVE-2026-33870 (CWE-444) in dependency `io.netty:netty-codec-http:jar:4.1.130.Final:test`
netty-codec-http - Inconsistent Interpretation of HTTP Requests ('HTTP Request/Response Smuggling')
#### References
* https://ossindex.sonatype.org/vulnerability/CVE-2026-33870?component-type=maven&component-name=io.netty%2Fnetty-codec-http&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-33870
* https://github.com/advisories/GHSA-pwqr-wmgm-9rr8
* https://gitlab.com/gitlab-org/advisories-community/-/blob/main/maven/io.netty/netty-codec-http/CVE-2026-33870.yml
* https://osv-vulnerabilities.storage.googleapis.com/Maven/GHSA-pwqr-wmgm-9rr8.json
* https://www.sonatype.com/products/sonatype-guide/oss-index-users

### CVE-2026-33871 (CWE-770) in dependency `io.netty:netty-codec-http2:jar:4.1.130.Final:test`
io.netty:netty-codec-http2 - Allocation of Resources Without Limits or Throttling
#### References
* https://ossindex.sonatype.org/vulnerability/CVE-2026-33871?component-type=maven&component-name=io.netty%2Fnetty-codec-http2&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-33871
* https://github.com/advisories/GHSA-w9fj-cfpg-grvv
* https://www.sonatype.com/products/sonatype-guide/oss-index-users

## Security

* #55: Fixed vulnerability CVE-2026-33870 in dependency `io.netty:netty-codec-http:jar:4.1.130.Final:test`
* #56: Fixed vulnerability CVE-2026-33871 in dependency `io.netty:netty-codec-http2:jar:4.1.130.Final:test`

## Dependency Updates

### Compile Dependency Updates

* Updated `software.amazon.awscdk:aws-cdk-lib:2.242.0` to `2.245.0`
* Updated `software.constructs:constructs:10.5.1` to `10.6.0`

### Test Dependency Updates

* Updated `org.junit.jupiter:junit-jupiter-api:5.13.4` to `6.0.3`
* Updated `software.amazon.awssdk:cloudformation:2.42.10` to `2.42.23`
* Updated `software.amazon.awssdk:codebuild:2.42.10` to `2.42.23`
* Updated `software.amazon.awssdk:iam:2.42.10` to `2.42.23`
* Updated `software.amazon.awssdk:sts:2.42.10` to `2.42.23`
