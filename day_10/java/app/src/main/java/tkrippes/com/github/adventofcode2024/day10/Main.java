package tkrippes.com.github.adventofcode2024.day10;

import tkrippes.com.github.adventofcode2024.day10.parser.TopographicMapParser;
import tkrippes.com.github.adventofcode2024.day10.solver.TrailheadScoreSolver;

public class Main {
    private static final String inputFileName = "../../input/input.txt";

    public static void main(String[] args) {
        System.out.println("Result of day 10 part 1: " + resultPart1());
    }

    private static int resultPart1() {
        TopographicMap map;
        try {
            map = TopographicMapParser.parse(inputFileName);
        } catch (Exception e) {
            e.printStackTrace();

            return 0;
        }

        return TrailheadScoreSolver.solve(map);
    }
}
