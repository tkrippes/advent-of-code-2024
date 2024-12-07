package tkrippes.com.github.adventofcode2024.day04;

import tkrippes.com.github.adventofcode2024.day04.parser.WordSearchParser;
import tkrippes.com.github.adventofcode2024.day04.solver.WordSearchSolver;

import java.io.IOException;

public class Main {
    private static final String inputFileName = "../../input/input.txt";
    private static final String wordToCount = "XMAS";

    public static void main(String[] args) {
        System.out.println("Result of part 1: " + part1());
        System.out.println("Result of part 2: " + part2());
    }

    private static int part1() {
        WordSearchParser parser = new WordSearchParser();
        WordSearch wordSearch;
        try {
            wordSearch = parser.parse(inputFileName);
        } catch (IOException e) {
            e.printStackTrace();

            return 0;
        }

        return new WordSearchSolver().solve(wordSearch, wordToCount);
    }

    private static int part2() {
        // TODO
        return 0;
    }
}
