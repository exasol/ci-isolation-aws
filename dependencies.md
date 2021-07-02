<!-- @formatter:off -->
# Dependencies

## Compile Dependencies

| Dependency                                 | License                           |
| ------------------------------------------ | --------------------------------- |
| [software.amazon.awscdk:core][0]           | [Apache License 2.0][1]           |
| [software.amazon.awscdk:iam][0]            | [Apache License 2.0][1]           |
| [software.amazon.awscdk:codebuild][0]      | [Apache License 2.0][1]           |
| [software.amazon.awscdk:events][0]         | [Apache License 2.0][1]           |
| [software.amazon.awscdk:events-targets][0] | [Apache License 2.0][1]           |
| [Gson][10]                                 | [Apache 2.0][11]                  |
| [error-reporting-java][12]                 | [MIT][13]                         |
| [SnakeYAML][14]                            | [Apache License, Version 2.0][15] |

## Test Dependencies

| Dependency                                           | License                           |
| ---------------------------------------------------- | --------------------------------- |
| [JUnit Jupiter API][16]                              | [Eclipse Public License v2.0][17] |
| [JUnit Jupiter Engine][16]                           | [Eclipse Public License v2.0][17] |
| [Hamcrest][20]                                       | [BSD License 3][21]               |
| [AWS Java SDK :: Services :: AWS IAM][22]            | [Apache License, Version 2.0][23] |
| [AWS Java SDK :: Services :: AWS STS][22]            | [Apache License, Version 2.0][23] |
| [AWS Java SDK :: Services :: AWS CloudFormation][22] | [Apache License, Version 2.0][23] |
| [AWS Java SDK :: Services :: AWS Code Build][22]     | [Apache License, Version 2.0][23] |

## Plugin Dependencies

| Dependency                                              | License                                        |
| ------------------------------------------------------- | ---------------------------------------------- |
| [Apache Maven Compiler Plugin][30]                      | [Apache License, Version 2.0][11]              |
| [Exec Maven Plugin][32]                                 | [Apache License 2][15]                         |
| [Project keeper maven plugin][34]                       | [MIT][13]                                      |
| [Versions Maven Plugin][36]                             | [Apache License, Version 2.0][11]              |
| [org.sonatype.ossindex.maven:ossindex-maven-plugin][38] | [ASL2][15]                                     |
| [Apache Maven Enforcer Plugin][40]                      | [Apache License, Version 2.0][11]              |
| [Maven Surefire Plugin][42]                             | [Apache License, Version 2.0][11]              |
| [JaCoCo :: Maven Plugin][44]                            | [Eclipse Public License 2.0][45]               |
| [Apache Maven GPG Plugin][46]                           | [Apache License, Version 2.0][15]              |
| [Maven Deploy Plugin][48]                               | [The Apache Software License, Version 2.0][15] |
| [Nexus Staging Maven Plugin][50]                        | [Eclipse Public License][51]                   |
| [Apache Maven Source Plugin][52]                        | [Apache License, Version 2.0][11]              |
| [Apache Maven Javadoc Plugin][54]                       | [Apache License, Version 2.0][11]              |
| [error-code-crawler-maven-plugin][56]                   | [MIT][13]                                      |
| [Reproducible Build Maven Plugin][58]                   | [Apache 2.0][15]                               |
| [Maven Clean Plugin][60]                                | [The Apache Software License, Version 2.0][15] |
| [Maven Resources Plugin][62]                            | [The Apache Software License, Version 2.0][15] |
| [Maven JAR Plugin][64]                                  | [The Apache Software License, Version 2.0][15] |
| [Maven Install Plugin][66]                              | [The Apache Software License, Version 2.0][15] |
| [Maven Site Plugin 3][68]                               | [The Apache Software License, Version 2.0][15] |

[34]: https://github.com/exasol/project-keeper-maven-plugin
[44]: https://www.eclemma.org/jacoco/index.html
[14]: http://www.snakeyaml.org
[1]: http://www.apache.org/licenses/LICENSE-2.0
[12]: https://github.com/exasol/error-reporting-java
[15]: http://www.apache.org/licenses/LICENSE-2.0.txt
[42]: https://maven.apache.org/surefire/maven-surefire-plugin/
[50]: http://www.sonatype.com/public-parent/nexus-maven-plugins/nexus-staging/nexus-staging-maven-plugin/
[10]: https://github.com/google/gson/gson
[60]: http://maven.apache.org/plugins/maven-clean-plugin/
[22]: https://aws.amazon.com/sdkforjava
[13]: https://opensource.org/licenses/MIT
[32]: http://www.mojohaus.org/exec-maven-plugin
[36]: http://www.mojohaus.org/versions-maven-plugin/
[21]: http://opensource.org/licenses/BSD-3-Clause
[30]: https://maven.apache.org/plugins/maven-compiler-plugin/
[46]: http://maven.apache.org/plugins/maven-gpg-plugin/
[45]: https://www.eclipse.org/legal/epl-2.0/
[51]: http://www.eclipse.org/legal/epl-v10.html
[23]: https://aws.amazon.com/apache2.0
[58]: http://zlika.github.io/reproducible-build-maven-plugin
[64]: http://maven.apache.org/plugins/maven-jar-plugin/
[11]: https://www.apache.org/licenses/LICENSE-2.0.txt
[40]: https://maven.apache.org/enforcer/maven-enforcer-plugin/
[17]: https://www.eclipse.org/legal/epl-v20.html
[66]: http://maven.apache.org/plugins/maven-install-plugin/
[16]: https://junit.org/junit5/
[38]: https://sonatype.github.io/ossindex-maven/maven-plugin/
[52]: https://maven.apache.org/plugins/maven-source-plugin/
[20]: http://hamcrest.org/JavaHamcrest/
[48]: http://maven.apache.org/plugins/maven-deploy-plugin/
[68]: http://maven.apache.org/plugins/maven-site-plugin/
[62]: http://maven.apache.org/plugins/maven-resources-plugin/
[54]: https://maven.apache.org/plugins/maven-javadoc-plugin/
[0]: https://github.com/aws/aws-cdk
[56]: https://github.com/exasol/error-code-crawler-maven-plugin
