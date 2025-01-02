package tkrippes.com.github.adventofcode2024.day13;

import tkrippes.com.github.adventofcode2024.day13.parser.MachineConfigurationsParser;
import tkrippes.com.github.adventofcode2024.day13.solver.TokenOptimizerSolver;

import java.util.List;

public class Main {
    private static final String inputFileName = "../../input/input.txt";

    public static void main(String[] args) {
        System.out.println("Result of day 12 part 1: " + resultPart1());
    }

    private static int resultPart1() {
        List<MachineConfiguration> machineConfigurations;
        try {
            machineConfigurations = MachineConfigurationsParser.parse(inputFileName);
        } catch (Exception e) {
            e.printStackTrace();

            return 0;
        }

        return TokenOptimizerSolver.solve(machineConfigurations);
    }
}
