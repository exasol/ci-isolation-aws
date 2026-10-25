# CI Isolation AWS 3.0.2, released 2026-??-??

Code name: Fixed vulnerability CVE-2026-110879 in com.fasterxml.jackson.core:jackson-databind:jar:2.22.2:compile

## Summary

This release fixes the following vulnerability:

### CVE-2026-110879 (CWE-502) in dependency `com.fasterxml.jackson.core:jackson-databind:jar:2.22.2:compile`
jackson-databind - Deserialization of Untrusted Data
#### References
* https://guide.sonatype.com/vulnerability/CVE-2026-110879?component-type=maven&component-name=com.fasterxml.jackson.core%2Fjackson-databind&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-110879
* https://github.com/FasterXML/jackson/wiki/Jackson-Release-2.18.12
* https://github.com/FasterXML/jackson-databind/pull/6287

## Security

* #122: Fixed vulnerability CVE-2026-110879 in dependency `com.fasterxml.jackson.core:jackson-databind:jar:2.22.2:compile`

## Dependency Updates

### Compile Dependency Updates

* Updated `com.google.code.gson:gson:2.14.0` to `2.15.0`
* Updated `org.yaml:snakeyaml:2.6` to `2.7`
* Updated `software.amazon.awscdk:aws-cdk-lib:2.266.0` to `2.274.0`

### Test Dependency Updates

* Updated `org.slf4j:slf4j-jdk14:2.0.18` to `2.0.20`
* Updated `software.amazon.awssdk:cloudformation:2.54.2` to `2.57.3`
* Updated `software.amazon.awssdk:codebuild:2.54.2` to `2.57.3`
* Updated `software.amazon.awssdk:iam:2.54.2` to `2.57.3`
* Updated `software.amazon.awssdk:signin:2.54.2` to `2.57.3`
* Updated `software.amazon.awssdk:sts:2.54.2` to `2.57.3`

### Plugin Dependency Updates

* Updated `com.exasol:project-keeper-maven-plugin:5.7.4` to `5.8.1`
