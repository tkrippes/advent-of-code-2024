package tkrippes.com.github.adventofcode2024.day08;

import tkrippes.com.github.adventofcode2024.day08.parser.AntennaMapParser;
import tkrippes.com.github.adventofcode2024.day08.solver.AntinodesResonantHarmonicsSolver;
import tkrippes.com.github.adventofcode2024.day08.solver.AntinodesSolver;

import java.util.function.Function;

public class Main {
    private static final String inputFileName = "../../input/input.txt";

    public static void main(String[] args) {
        System.out.println("Result of day 7 part 1: " + result(AntinodesSolver::solve));
        System.out.println("Result of day 7 part 2: " + result(AntinodesResonantHarmonicsSolver::solve));
    }

    private static int result(Function<AntennaMap, Integer> solve) {
        AntennaMap map;
        try {
            map = AntennaMapParser.parse(inputFileName);
        } catch (Exception e) {
            e.printStackTrace();

            return 0;
        }

        return solve.apply(map);
    }
}
