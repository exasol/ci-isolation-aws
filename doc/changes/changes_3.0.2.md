# CI Isolation AWS 3.0.2, released 2026-09-16

Code name: Fixed vulnerabilities CVE-2026-89044, CVE-2026-89044, CVE-2026-19032, CVE-2026-68497, CVE-2026-64607, CVE-2026-59903

## Summary

This release fixes the following 6 vulnerabilities:

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

### CVE-2026-19032 (CWE-470) in dependency `com.fasterxml.jackson.core:jackson-databind:jar:2.22.1:compile`
com.fasterxml.jackson.core/jackson-databind - Unrestricted URI schemes in Path deserialization
#### References
* https://guide.sonatype.com/vulnerability/CVE-2026-19032?component-type=maven&component-name=com.fasterxml.jackson.core%2Fjackson-databind&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-19032
* https://github.com/FasterXML/jackson-databind/pull/6129

### CVE-2026-68497 (CWE-770) in dependency `com.fasterxml.jackson.core:jackson-databind:jar:2.22.1:compile`
jackson-databind - Allocation of Resources Without Limits or Throttling
#### References
* https://guide.sonatype.com/vulnerability/CVE-2026-68497?component-type=maven&component-name=com.fasterxml.jackson.core%2Fjackson-databind&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-68497
* https://github.com/FasterXML/jackson-databind/pull/6127

### CVE-2026-64607 (CWE-772) in dependency `org.apache.httpcomponents.client5:httpclient5:jar:5.6.2:test`
HttpClient based on the classic i/o model fails to correctly release the underlying connection back to the connection manager if it encounters an invalid or unsupported `Content-Encoding` header value in the response message.Â Please note this defect does not affect HttpClient based on the async i/o model.

This issue affects Apache HttpComponents Client: from 5.0-alpha1 through 5.6.2.
#### References
* https://guide.sonatype.com/vulnerability/CVE-2026-64607?component-type=maven&component-name=org.apache.httpcomponents.client5%2Fhttpclient5&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-64607
* https://github.com/advisories/GHSA-hjcp-jmpx-g3qm

### CVE-2026-59903 (CWE-524) in dependency `io.netty:netty-codec-http:jar:4.2.16.Final:test`
io.netty:netty-codec-http - Use of Cache Containing Sensitive Information
#### References
* https://guide.sonatype.com/vulnerability/CVE-2026-59903?component-type=maven&component-name=io.netty%2Fnetty-codec-http&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-59903
* https://github.com/netty/netty/security/advisories/GHSA-8c42-7qj2-3j46

## Security

* #89: Fixed vulnerability CVE-2026-59903 in dependency `io.netty:netty-codec-http:jar:4.2.16.Final:test`
* #91: Fixed vulnerability CVE-2026-19032 in dependency `com.fasterxml.jackson.core:jackson-databind:jar:2.22.1:compile`
* #92: Fixed vulnerability CVE-2026-68497 in dependency `com.fasterxml.jackson.core:jackson-databind:jar:2.22.1:compile`
* #93: Fixed vulnerability CVE-2026-64607 in dependency `org.apache.httpcomponents.client5:httpclient5:jar:5.6.2:test`
* #97: Fixed vulnerability CVE-2026-89044 in dependency `io.netty:netty-codec-http2:jar:4.2.17.Final:test`
* #98: Fixed vulnerability CVE-2026-89044 in dependency `io.netty:netty-codec-http:jar:4.2.17.Final:test`

## Dependency Updates

### Compile Dependency Updates

* Updated `org.yaml:snakeyaml:2.6` to `2.7`
* Updated `software.amazon.awscdk:aws-cdk-lib:2.266.0` to `2.269.0`

### Test Dependency Updates

* Updated `org.slf4j:slf4j-jdk14:2.0.18` to `2.0.19`
* Updated `software.amazon.awssdk:cloudformation:2.54.2` to `2.54.19`
* Updated `software.amazon.awssdk:codebuild:2.54.2` to `2.54.19`
* Updated `software.amazon.awssdk:iam:2.54.2` to `2.54.19`
* Updated `software.amazon.awssdk:signin:2.54.2` to `2.54.19`
* Updated `software.amazon.awssdk:sts:2.54.2` to `2.54.19`

### Plugin Dependency Updates

* Updated `com.exasol:error-code-crawler-maven-plugin:2.1.0` to `2.1.1`
* Updated `com.exasol:project-keeper-maven-plugin:5.7.4` to `5.7.5`
* Updated `io.github.git-commit-id:git-commit-id-maven-plugin:10.0.0` to `10.0.1`
* Updated `org.apache.maven.plugins:maven-toolchains-plugin:3.2.0` to `3.3.0`
* Updated `org.codehaus.mojo:flatten-maven-plugin:1.7.3` to `1.8.0`
