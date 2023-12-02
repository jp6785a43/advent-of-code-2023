package com.github.jp6785a43.aoc2023.day1;

import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * The calibration value can be found by combining the first digit and the last digit (in that order)
 * to form a single two-digit number.
 *
 * What is the sum of all calibration values?
 */
public class Part1 {

    public int solveSimply(Path path) throws IOException {
        var lines = Files.readAllLines(path);

        List<Integer> calibrationValues = new ArrayList<>();

        for (var line : lines) {
            List<Character> thisLine = new ArrayList<>();
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);

                if (List.of('1', '2', '3', '4', '5', '6', '7', '8', '9').contains(c)) {
                    thisLine.add(c);
                }
            }

            var first = thisLine.get(0);
            var last = thisLine.get(thisLine.size() - 1);
            calibrationValues.add(Integer.parseInt("" + first + last));
        }

        Integer sum = calibrationValues.stream().mapToInt(Integer::intValue).sum();

        return sum;
    }

    public int solveCreatively(Path path) throws IOException {
        var lines = Files.readAllLines(path);

        return lines.stream()
                .map(l -> CharBuffer.wrap(l.toCharArray()).chars()
                            .filter(c -> c >= (int) '1' && c <= (int) '9')
                            .mapToObj(i -> (char) i)
                            .toList()
                )
                .map(l -> "" + l.get(0) + l.get(l.size() - 1))
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
