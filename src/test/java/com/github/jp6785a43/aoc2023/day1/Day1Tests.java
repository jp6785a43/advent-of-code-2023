package com.github.jp6785a43.aoc2023.day1;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class Day1Tests {
    private Part1 part1 = new Part1();
    private Part2 part2 = new Part2();

    @Test
    void solvePart1() throws IOException {
        var path = Path.of("input", "day1", "input.txt");

        assertEquals(54968, part1.solveSimply(path));
        assertEquals(54968, part1.solveCreatively(path));
    }

    @Test
    void solvePart2() throws IOException {
        var path = Path.of("input", "day1", "input.txt");

        log.info("{}", part2.solveSimply(path));

        assertEquals(54094, part2.solveSimply(path));
    }

    @Test
    void solvePart2Regression() throws IOException {
        var path = Path.of("input", "day1", "part-2-example.txt");

        assertEquals(281, part2.solveSimply(path));
    }

    @Test
    void solvePart2_9g() throws IOException {
        var path = Path.of("input", "day1", "9g.txt");

        assertEquals(99, part2.solveSimply(path));
    }

    @Test
    void solvePart2_oneight() throws IOException {
        var path = Path.of("input", "day1", "oneight.txt");

        assertEquals(
                76 + 84 + 58 + 48 + 22 + 78 + 45 + 31
                , part2.solveSimply(path));
    }
}