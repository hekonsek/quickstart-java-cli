package com.github.hekonsek.quickstart.stdinout;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StdInOutTest {

    StdInOut stdInOut = new StdInOut("foo");

    @Test
    void shouldMatchPattern() {
        // Given
        var line = "line with foo";

        // When
        var matches = stdInOut.matchesPattern(line);

        // Then
        assertThat(matches).isTrue();
    }

}
