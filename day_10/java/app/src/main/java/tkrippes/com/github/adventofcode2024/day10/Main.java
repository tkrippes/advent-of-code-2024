package tkrippes.com.github.adventofcode2024.day10;

import tkrippes.com.github.adventofcode2024.day10.parser.TopographicMapParser;
import tkrippes.com.github.adventofcode2024.day10.solver.TrailheadRatingSolver;
import tkrippes.com.github.adventofcode2024.day10.solver.TrailheadScoreSolver;

import java.util.function.Function;

public class Main {
    private static final String inputFileName = "../../input/input.txt";

    public static void main(String[] args) {
        System.out.println("Result of day 10 part 1: " + result(TrailheadScoreSolver::solve));
        System.out.println("Result of day 10 part 2: " + result(TrailheadRatingSolver::solve));
    }

    private static int result(Function<TopographicMap, Integer> solve) {
        TopographicMap map;
        try {
            map = TopographicMapParser.parse(inputFileName);
        } catch (Exception e) {
            e.printStackTrace();

            return 0;
        }

        return solve.apply(map);
    }
}
