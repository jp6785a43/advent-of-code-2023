package com.github.jp6785a43.aoc2023.day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Part2 {

    private static final Map<String, Integer> digits = Map.of(
            "one", 1,
            "two", 2,
            "three", 3,
            "four", 4,
            "five", 5,
            "six", 6,
            "seven", 7,
            "eight", 8,
            "nine", 9
    );

    private boolean isDigit(char c) {
        return c >= '1' && c <= '9';
    }

    private boolean isDigit(String s) {
        return digits.containsKey(s.toLowerCase());
    }

    public int solveSimply(Path path) throws IOException {
        var lines = Files.readAllLines(path);

        List<Integer> calibrationValues = new ArrayList<>();

        for (var line : lines) {
            List<Integer> thisLine = new ArrayList<>();

            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);

                if (isDigit(c)) {
                    thisLine.add(Integer.parseInt("" + c));
                } else {
                    String val = "";
                    for (int ix = i; ix < line.length(); ix++) {
                        if (isDigit(val)) {
                            // something like 'six'
                            break;
                        } else {
                            // take non-digits to see if they form a word that is a digit
                            val += line.charAt(ix);
                        }
                    }

                    if (isDigit(val)) {
                        thisLine.add(digits.get(val.toLowerCase()));
                        /*
                         Let the outer loop continue with the next value.
                         There are some overlapping digits, like:
                              oneight which we want to find as one and eight, separately.
                        */
                        i = i + 1;
                    }
                }
            }

            var first = thisLine.get(0);
            var last = thisLine.get(thisLine.size() - 1);
            var calibrationValue = Integer.parseInt("" + first + last);
            calibrationValues.add(calibrationValue);
        }

        return calibrationValues.stream().mapToInt(Integer::intValue).sum();
    }
}
