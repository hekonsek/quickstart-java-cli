package com.github.hekonsek.quickstart.cli;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.assertj.core.api.Assertions.assertThat;

public class GrepTest {

    @Test
    void shouldMatchPatternForLine() {
        // Given
        var grep = new Grep("foo");
        var line = "line with foo";

        // When
        var matches = grep.matchesPattern(line);

        // Then
        assertThat(matches).isTrue();
    }

    @Test
    void shouldFilterOut() {
        // Given
        var outputArray = new ByteArrayOutputStream();
        var output = new PrintStream(outputArray);
        var input = "foo\nbar".getBytes(UTF_8);
        var grep = new Grep(new ByteArrayInputStream(input), output, "foo");

        // When
        grep.filter();

        // Then
        var trimmedOutput = outputArray.toString(UTF_8).trim();
        assertThat(trimmedOutput).isEqualTo("foo");
    }

}
