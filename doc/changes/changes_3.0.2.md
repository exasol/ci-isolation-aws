# CI Isolation AWS 3.0.2, released 2026-??-??

Code name: Fixed vulnerabilities CVE-2026-89044, CVE-2026-89044

## Summary

This release fixes the following 2 vulnerabilities:

### CVE-2026-89044 (CWE-444) in dependency `io.netty:netty-codec-http2:jar:4.2.17.Final:test`
Netty versions 4.1.133.Final through 4.1.137.Final and 4.2.13.Final through 4.2.17.Final fail to properly validate the final transfer coding in the Transfer-Encoding header, allowing attackers to smuggle requests by using malformed encoding declarations. Attackers can split Transfer-Encoding headers across multiple lines or use values like 'chunked, xchunked' to bypass validation and decode messages as chunked when the final coding is not chunked, enabling request smuggling attacks.
#### References
* https://guide.sonatype.com/vulnerability/CVE-2026-89044?component-type=maven&component-name=io.netty%2Fnetty-codec-http2&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-89044
* https://github.com/netty/netty/releases/tag/netty-4.1.138.Final
* https://github.com/netty/netty/releases/tag/netty-4.2.18.Final
* https://github.com/netty/netty/security/advisories/GHSA-hcvj-94mj-jp5c

### CVE-2026-89044 (CWE-444) in dependency `io.netty:netty-codec-http:jar:4.2.17.Final:test`
Netty versions 4.1.133.Final through 4.1.137.Final and 4.2.13.Final through 4.2.17.Final fail to properly validate the final transfer coding in the Transfer-Encoding header, allowing attackers to smuggle requests by using malformed encoding declarations. Attackers can split Transfer-Encoding headers across multiple lines or use values like 'chunked, xchunked' to bypass validation and decode messages as chunked when the final coding is not chunked, enabling request smuggling attacks.
#### References
* https://guide.sonatype.com/vulnerability/CVE-2026-89044?component-type=maven&component-name=io.netty%2Fnetty-codec-http&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-89044
* https://github.com/netty/netty/releases/tag/netty-4.1.138.Final
* https://github.com/netty/netty/releases/tag/netty-4.2.18.Final
* https://github.com/netty/netty/security/advisories/GHSA-hcvj-94mj-jp5c

## Security

* #97: Fixed vulnerability CVE-2026-89044 in dependency `io.netty:netty-codec-http2:jar:4.2.17.Final:test`
* #98: Fixed vulnerability CVE-2026-89044 in dependency `io.netty:netty-codec-http:jar:4.2.17.Final:test`

## Dependency Updates

### Compile Dependency Updates

* Updated `org.yaml:snakeyaml:2.6` to `2.7`
* Updated `software.amazon.awscdk:aws-cdk-lib:2.266.0` to `2.269.0`

### Test Dependency Updates

* Updated `org.slf4j:slf4j-jdk14:2.0.18` to `2.0.19`
* Updated `software.amazon.awssdk:cloudformation:2.54.2` to `2.54.17`
* Updated `software.amazon.awssdk:codebuild:2.54.2` to `2.54.17`
* Updated `software.amazon.awssdk:iam:2.54.2` to `2.54.17`
* Updated `software.amazon.awssdk:signin:2.54.2` to `2.54.17`
* Updated `software.amazon.awssdk:sts:2.54.2` to `2.54.17`

### Plugin Dependency Updates

* Updated `com.exasol:project-keeper-maven-plugin:5.7.4` to `5.7.5`
