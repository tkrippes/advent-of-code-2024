package tkrippes.com.github.adventofcode2024.day11;

import tkrippes.com.github.adventofcode2024.day11.parser.PlutonianPebblesParser;
import tkrippes.com.github.adventofcode2024.day11.solver.StoneCountSolver;

import java.util.List;

public class Main {
    private static final String inputFileName = "../../input/input.txt";

    public static void main(String[] args) {
        System.out.println("Result of day 11 part 1: " + resultPart1());
    }

    private static int resultPart1() {
        List<PlutonianPebble> stones;
        try {
            stones = PlutonianPebblesParser.parse(inputFileName);
        } catch (Exception e) {
            e.printStackTrace();

            return 0;
        }

        return StoneCountSolver.solve(stones);
    }
}
