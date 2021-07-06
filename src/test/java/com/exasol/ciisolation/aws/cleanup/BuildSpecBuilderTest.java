package com.exasol.ciisolation.aws.cleanup;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;

class BuildSpecBuilderTest {

    @Test
    void testWithPhases() {
        final String buildSpec = new BuildSpecBuilder().addInstallSteps("apt get install nano").addBuildSteps("ls -l")
                .build();
        assertThat(buildSpec, equalTo("version: 0.2\n" + //
                "phases:\n" + //
                "  install:\n" + //
                "    commands:\n" + //
                "    - apt get install nano\n" + //
                "  build:\n" + //
                "    commands:\n" + //
                "    - ls -l\n"));
    }

    @Test
    void testMultiLine() {
        final String buildSpec = new BuildSpecBuilder()
                .addInstallSteps("vim -Nu <(cat <<-EOF\ntest\nEOF\n) -c 'test.txt' > /dev/null").build();
        assertThat(buildSpec, equalTo("version: 0.2\n" + //
                "phases:\n" + //
                "  install:\n" + //
                "    commands:\n" + //
                "    - |-\n" + //
                "      vim -Nu <(cat <<-EOF\n" + //
                "      test\n" + //
                "      EOF\n" + //
                "      ) -c 'test.txt' > /dev/null\n" //
        ));
    }
}