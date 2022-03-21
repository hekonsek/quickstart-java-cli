package com.github.hekonsek.quickstart.cli;

import java.io.*;

public class Grep {

    private final InputStream input;

    private final PrintStream output;

    private final String pattern;

    public Grep(InputStream input, PrintStream output, String pattern) {
        this.input = input;
        this.output = output;
        this.pattern = pattern;
    }

    public Grep(String pattern) {
        this(System.in, System.out, pattern);
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
                        output.println(line);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String... args) throws IOException {
        var pattern = args[0];
        new Grep(pattern).filter();
    }

}