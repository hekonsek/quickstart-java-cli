package com.github.hekonsek.quickstart.stdinout;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StdInOut {

    private final InputStream input;

    private final String pattern;

    public StdInOut(InputStream input, String pattern) {
        this.input = input;
        this.pattern = pattern;
    }

    public StdInOut(String pattern) {
        this(System.in, pattern);
    }

    boolean matchesPattern(String line) {
        return line.contains(pattern);
    }

    public void filter() {
        try {
            try (var reader = new BufferedReader(new InputStreamReader(input))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (matchesPattern(line)) {
                        System.out.println(line);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String... args) throws IOException {
        var pattern = args[0];
        new StdInOut(pattern).filter();
    }

}