# CI Isolation AWS 3.0.1, released 2026-??-??

Code name: Fixed vulnerabilities CVE-2026-19032, CVE-2026-68497, CVE-2026-64607

## Summary

This release fixes the following 3 vulnerabilities:

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

## Security

* #91: Fixed vulnerability CVE-2026-19032 in dependency `com.fasterxml.jackson.core:jackson-databind:jar:2.22.1:compile`
* #92: Fixed vulnerability CVE-2026-68497 in dependency `com.fasterxml.jackson.core:jackson-databind:jar:2.22.1:compile`
* #93: Fixed vulnerability CVE-2026-64607 in dependency `org.apache.httpcomponents.client5:httpclient5:jar:5.6.2:test`

## Dependency Updates

### Compile Dependency Updates

* Updated `software.amazon.awscdk:aws-cdk-lib:2.262.1` to `2.265.0`
* Updated `software.constructs:constructs:10.7.1` to `10.8.1`

### Test Dependency Updates

* Updated `org.junit.jupiter:junit-jupiter-api:6.1.2` to `6.1.3`
* Updated `software.amazon.awssdk:cloudformation:2.49.4` to `2.53.1`
* Updated `software.amazon.awssdk:codebuild:2.49.4` to `2.53.1`
* Updated `software.amazon.awssdk:iam:2.49.4` to `2.53.1`
* Updated `software.amazon.awssdk:signin:2.49.4` to `2.53.1`
* Updated `software.amazon.awssdk:sts:2.49.4` to `2.53.1`
