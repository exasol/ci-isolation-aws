<!-- @formatter:off -->
# Dependencies

## Compile Dependencies

| Dependency                              | License                          |
| --------------------------------------- | -------------------------------- |
| [software.amazon.awscdk:aws-cdk-lib][0] | [Apache License 2.0][1]          |
| [software.constructs:constructs][2]     | [Apache License 2.0][1]          |
| [Gson][3]                               | [Apache-2.0][4]                  |
| [error-reporting-java][5]               | [MIT License][6]                 |
| [SnakeYAML][7]                          | [Apache License, Version 2.0][8] |

## Test Dependencies

| Dependency                                           | License                           |
| ---------------------------------------------------- | --------------------------------- |
| [JUnit Jupiter API][9]                               | [Eclipse Public License v2.0][10] |
| [Hamcrest][11]                                       | [BSD-3-Clause][12]                |
| [AWS Java SDK :: Services :: AWS IAM][13]            | [Apache License, Version 2.0][14] |
| [AWS Java SDK :: Services :: AWS STS][13]            | [Apache License, Version 2.0][14] |
| [AWS Java SDK :: Services :: AWS CloudFormation][13] | [Apache License, Version 2.0][14] |
| [AWS Java SDK :: Services :: AWS Code Build][13]     | [Apache License, Version 2.0][14] |
| [SLF4J JDK14 Provider][15]                           | [MIT][16]                         |

## Plugin Dependencies

| Dependency                                              | License                                     |
| ------------------------------------------------------- | ------------------------------------------- |
| [SonarQube Scanner for Maven][17]                       | [GNU LGPL 3][18]                            |
| [Apache Maven Toolchains Plugin][19]                    | [Apache-2.0][4]                             |
| [Apache Maven Compiler Plugin][20]                      | [Apache-2.0][4]                             |
| [Apache Maven Enforcer Plugin][21]                      | [Apache-2.0][4]                             |
| [Maven Flatten Plugin][22]                              | [Apache Software License][4]                |
| [org.sonatype.ossindex.maven:ossindex-maven-plugin][23] | [ASL2][8]                                   |
| [Maven Surefire Plugin][24]                             | [Apache-2.0][4]                             |
| [Versions Maven Plugin][25]                             | [Apache License, Version 2.0][4]            |
| [duplicate-finder-maven-plugin Maven Mojo][26]          | [Apache License 2.0][27]                    |
| [Apache Maven Artifact Plugin][28]                      | [Apache-2.0][4]                             |
| [Apache Maven Deploy Plugin][29]                        | [Apache-2.0][4]                             |
| [Apache Maven GPG Plugin][30]                           | [Apache-2.0][4]                             |
| [Apache Maven Source Plugin][31]                        | [Apache-2.0][4]                             |
| [Apache Maven Javadoc Plugin][32]                       | [Apache-2.0][4]                             |
| [Central Publishing Maven Plugin][33]                   | [The Apache License, Version 2.0][4]        |
| [Maven Failsafe Plugin][34]                             | [Apache-2.0][4]                             |
| [JaCoCo :: Maven Plugin][35]                            | [EPL-2.0][36]                               |
| [Quality Summarizer Maven Plugin][37]                   | [MIT License][38]                           |
| [error-code-crawler-maven-plugin][39]                   | [MIT License][40]                           |
| [Git Commit Id Maven Plugin][41]                        | [GNU Lesser General Public License 3.0][42] |
| [Exec Maven Plugin][43]                                 | [Apache License 2][4]                       |
| [Project Keeper Maven plugin][44]                       | [The MIT License][45]                       |
| [Apache Maven Clean Plugin][46]                         | [Apache-2.0][4]                             |
| [Apache Maven Resources Plugin][47]                     | [Apache-2.0][4]                             |
| [Apache Maven Install Plugin][48]                       | [Apache-2.0][4]                             |
| [Apache Maven Site Plugin][49]                          | [Apache-2.0][4]                             |

[0]: https://github.com/aws/aws-cdk
[1]: https://www.apache.org/licenses/LICENSE-2.0
[2]: https://github.com/aws/constructs
[3]: https://github.com/google/gson
[4]: https://www.apache.org/licenses/LICENSE-2.0.txt
[5]: https://github.com/exasol/error-reporting-java/
[6]: https://github.com/exasol/error-reporting-java/blob/main/LICENSE
[7]: https://bitbucket.org/snakeyaml/snakeyaml
[8]: http://www.apache.org/licenses/LICENSE-2.0.txt
[9]: https://junit.org/
[10]: https://www.eclipse.org/legal/epl-v20.html
[11]: http://hamcrest.org/JavaHamcrest/
[12]: https://raw.githubusercontent.com/hamcrest/JavaHamcrest/master/LICENSE
[13]: https://aws.amazon.com/sdkforjava
[14]: https://aws.amazon.com/apache2.0
[15]: http://www.slf4j.org
[16]: https://opensource.org/license/mit
[17]: https://docs.sonarsource.com/sonarqube-server/latest/extension-guide/developing-a-plugin/plugin-basics/sonar-scanner-maven/sonar-maven-plugin/
[18]: http://www.gnu.org/licenses/lgpl.txt
[19]: https://maven.apache.org/plugins/maven-toolchains-plugin/
[20]: https://maven.apache.org/plugins/maven-compiler-plugin/
[21]: https://maven.apache.org/enforcer/maven-enforcer-plugin/
[22]: https://www.mojohaus.org/flatten-maven-plugin/
[23]: https://sonatype.github.io/ossindex-maven/maven-plugin/
[24]: https://maven.apache.org/surefire/maven-surefire-plugin/
[25]: https://www.mojohaus.org/versions/versions-maven-plugin/
[26]: https://basepom.github.io/duplicate-finder-maven-plugin
[27]: http://www.apache.org/licenses/LICENSE-2.0.html
[28]: https://maven.apache.org/plugins/maven-artifact-plugin/
[29]: https://maven.apache.org/plugins/maven-deploy-plugin/
[30]: https://maven.apache.org/plugins/maven-gpg-plugin/
[31]: https://maven.apache.org/plugins/maven-source-plugin/
[32]: https://maven.apache.org/plugins/maven-javadoc-plugin/
[33]: https://central.sonatype.org
[34]: https://maven.apache.org/surefire/maven-failsafe-plugin/
[35]: https://www.jacoco.org/jacoco/trunk/doc/maven.html
[36]: https://www.eclipse.org/legal/epl-2.0/
[37]: https://github.com/exasol/quality-summarizer-maven-plugin/
[38]: https://github.com/exasol/quality-summarizer-maven-plugin/blob/main/LICENSE
[39]: https://github.com/exasol/error-code-crawler-maven-plugin/
[40]: https://github.com/exasol/error-code-crawler-maven-plugin/blob/main/LICENSE
[41]: https://github.com/git-commit-id/git-commit-id-maven-plugin
[42]: http://www.gnu.org/licenses/lgpl-3.0.txt
[43]: https://www.mojohaus.org/exec-maven-plugin
[44]: https://github.com/exasol/project-keeper/
[45]: https://github.com/exasol/project-keeper/blob/main/LICENSE
[46]: https://maven.apache.org/plugins/maven-clean-plugin/
[47]: https://maven.apache.org/plugins/maven-resources-plugin/
[48]: https://maven.apache.org/plugins/maven-install-plugin/
[49]: https://maven.apache.org/plugins/maven-site-plugin/
