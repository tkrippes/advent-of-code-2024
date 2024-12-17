package tkrippes.com.github.adventofcode2024.day07;

import tkrippes.com.github.adventofcode2024.day07.parser.EquationsParser;
import tkrippes.com.github.adventofcode2024.day07.solver.TotalCalibrationResultSolver;

import java.util.List;

public class Main {
    private static final String inputFileName = "../../input/input.txt";

    public static void main(String[] args) {
        System.out.println("Result of day 7 part 1: " + result(false));
        System.out.println("Result of day 7 part 2: " + result(true));
    }

    private static long result(boolean includeConcatenation) {
        EquationsParser parser = new EquationsParser();
        List<Equation> equations;
        try {
            equations = parser.parse(inputFileName);
        } catch (Exception e) {
            e.printStackTrace();

            return 0;
        }

        return new TotalCalibrationResultSolver().solve(equations, includeConcatenation);
    }
}
