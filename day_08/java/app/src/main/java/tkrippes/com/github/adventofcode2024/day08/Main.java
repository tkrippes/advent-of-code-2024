package tkrippes.com.github.adventofcode2024.day08;

import tkrippes.com.github.adventofcode2024.day08.parser.AntennaMapParser;
import tkrippes.com.github.adventofcode2024.day08.solver.AntinodesSolver;

public class Main {
    private static final String inputFileName = "../../input/input.txt";

    public static void main(String[] args) {
        System.out.println("Result of day 7 part 1: " + resultPart1());
    }

    private static int resultPart1() {
        AntennaMap map;
        try {
            map = AntennaMapParser.parse(inputFileName);
        } catch (Exception e) {
            e.printStackTrace();

            return 0;
        }

        return AntinodesSolver.solve(map);
    }
}
