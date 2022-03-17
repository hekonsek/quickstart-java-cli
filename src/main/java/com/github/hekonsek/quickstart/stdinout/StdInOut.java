package com.github.hekonsek.quickstart.stdinout;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StdInOut {

    public static void main(String... args) throws IOException {
        var pattern = args[0];

        String line;
        var stdin = new BufferedReader(new InputStreamReader(System.in));
        while((line = stdin.readLine()) != null) {
            if( line.contains(pattern) ) {
                System.out.println(line);
            }
        }
        stdin.close();
    }

}