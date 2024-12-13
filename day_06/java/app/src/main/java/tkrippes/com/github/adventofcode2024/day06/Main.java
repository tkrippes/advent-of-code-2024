package tkrippes.com.github.adventofcode2024.day06;

import tkrippes.com.github.adventofcode2024.day06.map.LabMap;
import tkrippes.com.github.adventofcode2024.day06.parser.LabMapParser;
import tkrippes.com.github.adventofcode2024.day06.solver.DistinctGuardPositionsCountSolver;
import tkrippes.com.github.adventofcode2024.day06.solver.LabMapSolver;

public class Main {
    private static final String inputFileName = "../../input/input.txt";

    public static void main(String[] args) {
        System.out.println("Result of day 6 part 1: " + result(new DistinctGuardPositionsCountSolver()));
    }

    public static int result(LabMapSolver solver) {
        LabMapParser parser = new LabMapParser();
        LabMap map;
        try {
            map = parser.parse(inputFileName);
        } catch (Exception e) {
            e.printStackTrace();

            return 0;
        }

        return solver.solve(map);
    }
}
