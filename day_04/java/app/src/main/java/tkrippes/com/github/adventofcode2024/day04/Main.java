package tkrippes.com.github.adventofcode2024.day04;

import tkrippes.com.github.adventofcode2024.day04.parser.WordSearchParser;
import tkrippes.com.github.adventofcode2024.day04.solver.WordSearchCrossSolver;
import tkrippes.com.github.adventofcode2024.day04.solver.WordSearchSolver;
import tkrippes.com.github.adventofcode2024.day04.solver.WordSearchStraightSolver;

import java.io.IOException;

public class Main {
    private static final String inputFileName = "../../input/input.txt";

    public static void main(String[] args) {
        System.out.println("Result of part 1: " + commonPart(new WordSearchStraightSolver(), "XMAS"));
        System.out.println("Result of part 2: " + commonPart(new WordSearchCrossSolver(), "MAS"));
    }

    private static int commonPart(WordSearchSolver solver, String word) {
        WordSearchParser parser = new WordSearchParser();
        WordSearch wordSearch;
        try {
            wordSearch = parser.parse(inputFileName);
        } catch (IOException e) {
            e.printStackTrace();

            return 0;
        }

        return solver.solve(wordSearch, word);
    }
}
