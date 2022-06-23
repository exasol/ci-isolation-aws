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
| [Gson][10]                                 | [Apache-2.0][11]                  |
| [error-reporting-java][12]                 | [MIT][13]                         |
| [SnakeYAML][14]                            | [Apache License, Version 2.0][15] |

## Test Dependencies

| Dependency                                           | License                           |
| ---------------------------------------------------- | --------------------------------- |
| [JUnit Jupiter API][16]                              | [Eclipse Public License v2.0][17] |
| [JUnit Jupiter Engine][16]                           | [Eclipse Public License v2.0][17] |
| [Hamcrest][20]                                       | [BSD License 3][21]               |
| [AWS Java SDK :: Services :: AWS IAM][22]            | [Apache License, Version 2.0][23] |
| [Apache Commons Codec][24]                           | [Apache License, Version 2.0][11] |
| [AWS Java SDK :: Services :: AWS STS][22]            | [Apache License, Version 2.0][23] |
| [AWS Java SDK :: Services :: AWS CloudFormation][22] | [Apache License, Version 2.0][23] |
| [AWS Java SDK :: Services :: AWS Code Build][22]     | [Apache License, Version 2.0][23] |

## Plugin Dependencies

| Dependency                                              | License                                        |
| ------------------------------------------------------- | ---------------------------------------------- |
| [SonarQube Scanner for Maven][32]                       | [GNU LGPL 3][33]                               |
| [Apache Maven Compiler Plugin][34]                      | [Apache License, Version 2.0][11]              |
| [Apache Maven Enforcer Plugin][36]                      | [Apache License, Version 2.0][11]              |
| [Maven Flatten Plugin][38]                              | [Apache Software Licenese][15]                 |
| [Exec Maven Plugin][40]                                 | [Apache License 2][15]                         |
| [Project keeper maven plugin][42]                       | [The MIT License][43]                          |
| [org.sonatype.ossindex.maven:ossindex-maven-plugin][44] | [ASL2][15]                                     |
| [Reproducible Build Maven Plugin][46]                   | [Apache 2.0][15]                               |
| [Maven Surefire Plugin][48]                             | [Apache License, Version 2.0][11]              |
| [Versions Maven Plugin][50]                             | [Apache License, Version 2.0][11]              |
| [Apache Maven Deploy Plugin][52]                        | [Apache License, Version 2.0][11]              |
| [Apache Maven GPG Plugin][54]                           | [Apache License, Version 2.0][11]              |
| [Apache Maven Source Plugin][56]                        | [Apache License, Version 2.0][11]              |
| [Apache Maven Javadoc Plugin][58]                       | [Apache License, Version 2.0][11]              |
| [Nexus Staging Maven Plugin][60]                        | [Eclipse Public License][61]                   |
| [JaCoCo :: Maven Plugin][62]                            | [Eclipse Public License 2.0][63]               |
| [error-code-crawler-maven-plugin][64]                   | [MIT][13]                                      |
| [Maven Clean Plugin][66]                                | [The Apache Software License, Version 2.0][15] |
| [Maven Resources Plugin][68]                            | [The Apache Software License, Version 2.0][15] |
| [Maven JAR Plugin][70]                                  | [The Apache Software License, Version 2.0][15] |
| [Maven Install Plugin][72]                              | [The Apache Software License, Version 2.0][15] |
| [Maven Site Plugin 3][74]                               | [The Apache Software License, Version 2.0][15] |

[12]: https://github.com/exasol/error-reporting-java
[15]: http://www.apache.org/licenses/LICENSE-2.0.txt
[48]: https://maven.apache.org/surefire/maven-surefire-plugin/
[60]: http://www.sonatype.com/public-parent/nexus-maven-plugins/nexus-staging/nexus-staging-maven-plugin/
[66]: http://maven.apache.org/plugins/maven-clean-plugin/
[22]: https://aws.amazon.com/sdkforjava
[13]: https://opensource.org/licenses/MIT
[38]: https://www.mojohaus.org/flatten-maven-plugin/
[40]: http://www.mojohaus.org/exec-maven-plugin
[24]: https://commons.apache.org/proper/commons-codec/
[42]: https://github.com/exasol/project-keeper/
[50]: http://www.mojohaus.org/versions-maven-plugin/
[21]: http://opensource.org/licenses/BSD-3-Clause
[34]: https://maven.apache.org/plugins/maven-compiler-plugin/
[63]: https://www.eclipse.org/legal/epl-2.0/
[10]: https://github.com/google/gson
[52]: https://maven.apache.org/plugins/maven-deploy-plugin/
[61]: http://www.eclipse.org/legal/epl-v10.html
[33]: http://www.gnu.org/licenses/lgpl.txt
[1]: https://www.apache.org/licenses/LICENSE-2.0
[62]: https://www.jacoco.org/jacoco/trunk/doc/maven.html
[23]: https://aws.amazon.com/apache2.0
[43]: https://github.com/exasol/project-keeper/blob/main/LICENSE
[46]: http://zlika.github.io/reproducible-build-maven-plugin
[70]: http://maven.apache.org/plugins/maven-jar-plugin/
[11]: https://www.apache.org/licenses/LICENSE-2.0.txt
[32]: http://sonarsource.github.io/sonar-scanner-maven/
[36]: https://maven.apache.org/enforcer/maven-enforcer-plugin/
[17]: https://www.eclipse.org/legal/epl-v20.html
[72]: http://maven.apache.org/plugins/maven-install-plugin/
[14]: https://bitbucket.org/snakeyaml/snakeyaml
[16]: https://junit.org/junit5/
[44]: https://sonatype.github.io/ossindex-maven/maven-plugin/
[54]: https://maven.apache.org/plugins/maven-gpg-plugin/
[56]: https://maven.apache.org/plugins/maven-source-plugin/
[20]: http://hamcrest.org/JavaHamcrest/
[74]: http://maven.apache.org/plugins/maven-site-plugin/
[68]: http://maven.apache.org/plugins/maven-resources-plugin/
[58]: https://maven.apache.org/plugins/maven-javadoc-plugin/
[0]: https://github.com/aws/aws-cdk
[64]: https://github.com/exasol/error-code-crawler-maven-plugin
