package tkrippes.com.github.adventofcode2024.day12;

import tkrippes.com.github.adventofcode2024.day12.parser.GardenPlotsParser;
import tkrippes.com.github.adventofcode2024.day12.solver.PriceSolverV1;
import tkrippes.com.github.adventofcode2024.day12.solver.PriceSolverV2;

import java.util.function.Function;

public class Main {
    private static final String inputFileName = "../../input/input.txt";

    public static void main(String[] args) {
        System.out.println("Result of day 12 part 1: " + result(PriceSolverV1::solve));
        System.out.println("Result of day 12 part 2: " + result(PriceSolverV2::solve));
    }

    private static long result(Function<GardenPlots, Long> solve) {
        GardenPlots plots;
        try {
            plots = GardenPlotsParser.parse(inputFileName);
        } catch (Exception e) {
            e.printStackTrace();

            return 0;
        }

        return solve.apply(plots);
    }
}
