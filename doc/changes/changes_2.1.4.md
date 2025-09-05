# CI Isolation AWS 2.1.4, released 2025-??-??

Code name: Fixed vulnerability CVE-2025-58057 in io.netty:netty-codec:jar:4.1.118.Final:test

## Summary

This release fixes the following vulnerability:

### CVE-2025-58057 (CWE-409) in dependency `io.netty:netty-codec:jar:4.1.118.Final:test`
netty-codec - Improper Handling of Highly Compressed Data (Data Amplification)
#### References
* https://ossindex.sonatype.org/vulnerability/CVE-2025-58057?component-type=maven&component-name=io.netty%2Fnetty-codec&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2025-58057
* https://github.com/netty/netty/security/advisories/GHSA-3p8m-j85q-pgmj

## Security

* #49: Fixed vulnerability CVE-2025-58057 in dependency `io.netty:netty-codec:jar:4.1.118.Final:test`

## Dependency Updates

### Compile Dependency Updates

* Updated `com.google.code.gson:gson:2.12.1` to `2.13.1`
* Updated `org.yaml:snakeyaml:2.4` to `2.5`
* Updated `software.amazon.awscdk:aws-cdk-lib:2.189.0` to `2.214.0`

### Test Dependency Updates

* Updated `org.junit.jupiter:junit-jupiter-api:5.12.1` to `5.13.4`
* Updated `software.amazon.awssdk:cloudformation:2.31.20` to `2.33.3`
* Updated `software.amazon.awssdk:codebuild:2.31.20` to `2.33.3`
* Updated `software.amazon.awssdk:iam:2.31.20` to `2.33.3`
* Updated `software.amazon.awssdk:sts:2.31.20` to `2.33.3`
