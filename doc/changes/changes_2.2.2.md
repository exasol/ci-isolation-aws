# CI Isolation AWS 2.2.2, released 2026-??-??

Code name: Fixed vulnerabilities CVE-2026-42580, CVE-2026-42581, CVE-2026-42584, CVE-2026-42585, CVE-2026-42587, CVE-2026-42583, CVE-2026-42587, CVE-2026-42577

## Summary

This release fixes the following 8 vulnerabilities:

### CVE-2026-42580 (CWE-190) in dependency `io.netty:netty-codec-http:jar:4.2.12.Final:test`
Netty is an asynchronous, event-driven network application framework. Prior to 4.2.13.Final and 4.1.133.Final, Netty's chunk size parser silently overflows int, enabling request smuggling attacks. This vulnerability is fixed in 4.2.13.Final and 4.1.133.Final.
#### References
* https://guide.sonatype.com/vulnerability/CVE-2026-42580?component-type=maven&component-name=io.netty%2Fnetty-codec-http&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-42580
* https://github.com/advisories/GHSA-m4cv-j2px-7723

### CVE-2026-42581 (CWE-444) in dependency `io.netty:netty-codec-http:jar:4.2.12.Final:test`
Netty is an asynchronous, event-driven network application framework. Prior to 4.2.13.Final and 4.1.133.Final, HttpObjectDecoder strips a conflicting Content-Length header when a request carries both Transfer-Encoding: chunked and Content-Length, but only for HTTP/1.1 messages. The guard is absent for HTTP/1.0. An attacker that sends an HTTP/1.0 request with both headers causes Netty to decode the body as chunked while leaving Content-Length intact in the forwarded HttpMessage. Any downstream proxy or handler that trusts Content-Length over Transfer-Encoding will disagree on message boundaries, enabling request smuggling. This vulnerability is fixed in 4.2.13.Final and 4.1.133.Final.
#### References
* https://guide.sonatype.com/vulnerability/CVE-2026-42581?component-type=maven&component-name=io.netty%2Fnetty-codec-http&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-42581
* https://github.com/advisories/GHSA-xxqh-mfjm-7mv9

### CVE-2026-42584 (CWE-444) in dependency `io.netty:netty-codec-http:jar:4.2.12.Final:test`
Netty is an asynchronous, event-driven network application framework. Prior to 4.2.13.Final and 4.1.133.Final, HttpClientCodec pairs each inbound response with an outbound request by queue.poll() once per response, including for 1xx. If the client pipelines GET then HEAD and the server sends 103, then 200 with GET body, then 200 for HEAD, the queue pairs HEAD with the first 200. The HEAD rule then skips reading that messageâs body, so the GET entity bytes stay on the stream and the following 200 is parsed from the wrong offset. This vulnerability is fixed in 4.2.13.Final and 4.1.133.Final.
#### References
* https://guide.sonatype.com/vulnerability/CVE-2026-42584?component-type=maven&component-name=io.netty%2Fnetty-codec-http&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-42584
* https://github.com/advisories/GHSA-57rv-r2g8-2cj3

### CVE-2026-42585 (CWE-444) in dependency `io.netty:netty-codec-http:jar:4.2.12.Final:test`
Netty is an asynchronous, event-driven network application framework. Prior to 4.2.13.Final and 4.1.133.Final, Netty incorrectly parses malformed Transfer-Encoding, enabling request smuggling attacks. This vulnerability is fixed in 4.2.13.Final and 4.1.133.Final.
#### References
* https://guide.sonatype.com/vulnerability/CVE-2026-42585?component-type=maven&component-name=io.netty%2Fnetty-codec-http&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-42585
* https://github.com/netty/netty/security/advisories/GHSA-38f8-5428-x5cv
* https://github.com/advisories/GHSA-38f8-5428-x5cv

### CVE-2026-42587 (CWE-400) in dependency `io.netty:netty-codec-http:jar:4.2.12.Final:test`
Netty is an asynchronous, event-driven network application framework. Prior to 4.2.13.Final and 4.1.133.Final, HttpContentDecompressor accepts a maxAllocation parameter to limit decompression buffer size and prevent decompression bomb attacks. This limit is correctly enforced for gzip and deflate encodings via ZlibDecoder, but is silently ignored when the content encoding is br (Brotli), zstd, or snappy. An attacker can bypass the configured decompression limit by sending a compressed payload with Content-Encoding: br instead of Content-Encoding: gzip, causing unbounded memory allocation and out-of-memory denial of service. The same vulnerability exists in DelegatingDecompressorFrameListener for HTTP/2 connections. This vulnerability is fixed in 4.2.13.Final and 4.1.133.Final.

Sonatype's research suggests that this CVE's details differ from those defined at NVD. See https://guide.sonatype.com/vulnerability/CVE-2026-42587 for details
#### References
* https://guide.sonatype.com/vulnerability/CVE-2026-42587?component-type=maven&component-name=io.netty%2Fnetty-codec-http&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-42587
* https://github.com/advisories/GHSA-f6hv-jmp6-3vwv

### CVE-2026-42583 (CWE-400) in dependency `io.netty:netty-codec-compression:jar:4.2.12.Final:test`
Netty is an asynchronous, event-driven network application framework. Prior to 4.2.13.Final and 4.1.133.Final, Lz4FrameDecoder allocates a ByteBuf of size decompressedLength (up to 32 MB per block) before LZ4 runs. A peer only needs a 21-byte header plus compressedLength payload bytes - 22 bytes if compressedLength == 1 - to force that allocation. This vulnerability is fixed in 4.2.13.Final and 4.1.133.Final.
#### References
* https://guide.sonatype.com/vulnerability/CVE-2026-42583?component-type=maven&component-name=io.netty%2Fnetty-codec-compression&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-42583
* https://github.com/advisories/GHSA-mj4r-2hfc-f8p6

### CVE-2026-42587 (CWE-400) in dependency `io.netty:netty-codec-http2:jar:4.2.12.Final:test`
Netty is an asynchronous, event-driven network application framework. Prior to 4.2.13.Final and 4.1.133.Final, HttpContentDecompressor accepts a maxAllocation parameter to limit decompression buffer size and prevent decompression bomb attacks. This limit is correctly enforced for gzip and deflate encodings via ZlibDecoder, but is silently ignored when the content encoding is br (Brotli), zstd, or snappy. An attacker can bypass the configured decompression limit by sending a compressed payload with Content-Encoding: br instead of Content-Encoding: gzip, causing unbounded memory allocation and out-of-memory denial of service. The same vulnerability exists in DelegatingDecompressorFrameListener for HTTP/2 connections. This vulnerability is fixed in 4.2.13.Final and 4.1.133.Final.

Sonatype's research suggests that this CVE's details differ from those defined at NVD. See https://guide.sonatype.com/vulnerability/CVE-2026-42587 for details
#### References
* https://guide.sonatype.com/vulnerability/CVE-2026-42587?component-type=maven&component-name=io.netty%2Fnetty-codec-http2&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-42587
* https://github.com/advisories/GHSA-f6hv-jmp6-3vwv

### CVE-2026-42577 (CWE-772) in dependency `io.netty:netty-transport-classes-epoll:jar:4.2.12.Final:test`
Netty is an asynchronous, event-driven network application framework. From 4.2.0.Final to 4.2.13.Final , Netty's epoll transport fails to detect and close TCP connections that receive a RST after being half-closed, leading to stale channels that are never cleaned up and, in some code paths, a 100% CPU busy-loop in the event loop thread. This vulnerability is fixed in 4.2.13.Final.

Sonatype's research suggests that this CVE's details differ from those defined at NVD. See https://guide.sonatype.com/vulnerability/CVE-2026-42577 for details
#### References
* https://guide.sonatype.com/vulnerability/CVE-2026-42577?component-type=maven&component-name=io.netty%2Fnetty-transport-classes-epoll&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-42577
* https://github.com/advisories/GHSA-rwm7-x88c-3g2p

## Security

* #60: Fixed vulnerability CVE-2026-42580 in dependency `io.netty:netty-codec-http:jar:4.2.12.Final:test`
* #61: Fixed vulnerability CVE-2026-42581 in dependency `io.netty:netty-codec-http:jar:4.2.12.Final:test`
* #62: Fixed vulnerability CVE-2026-42584 in dependency `io.netty:netty-codec-http:jar:4.2.12.Final:test`
* #63: Fixed vulnerability CVE-2026-42585 in dependency `io.netty:netty-codec-http:jar:4.2.12.Final:test`
* #64: Fixed vulnerability CVE-2026-42587 in dependency `io.netty:netty-codec-http:jar:4.2.12.Final:test`
* #65: Fixed vulnerability CVE-2026-42583 in dependency `io.netty:netty-codec-compression:jar:4.2.12.Final:test`
* #66: Fixed vulnerability CVE-2026-42587 in dependency `io.netty:netty-codec-http2:jar:4.2.12.Final:test`
* #67: Fixed vulnerability CVE-2026-42577 in dependency `io.netty:netty-transport-classes-epoll:jar:4.2.12.Final:test`

## Dependency Updates

### Compile Dependency Updates

* Updated `com.google.code.gson:gson:2.13.2` to `2.14.0`
* Updated `software.amazon.awscdk:aws-cdk-lib:2.245.0` to `2.258.0`

### Test Dependency Updates

* Updated `org.junit.jupiter:junit-jupiter-api:5.13.4` to `6.1.0`
* Updated `org.slf4j:slf4j-jdk14:2.0.17` to `2.0.18`
* Updated `software.amazon.awssdk:cloudformation:2.42.24` to `2.46.5`
* Updated `software.amazon.awssdk:codebuild:2.42.24` to `2.46.5`
* Updated `software.amazon.awssdk:iam:2.42.24` to `2.46.5`
* Updated `software.amazon.awssdk:sts:2.42.24` to `2.46.5`

### Plugin Dependency Updates

* Updated `com.exasol:project-keeper-maven-plugin:5.4.6` to `5.6.2`
