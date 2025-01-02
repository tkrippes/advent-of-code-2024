package tkrippes.com.github.adventofcode2024.day13;

import tkrippes.com.github.adventofcode2024.day13.parser.MachineConfigurationsParser;
import tkrippes.com.github.adventofcode2024.day13.solver.TokenOptimizerSolverV1;
import tkrippes.com.github.adventofcode2024.day13.solver.TokenOptimizerSolverV2;

import java.util.List;
import java.util.function.Function;

public class Main {
    private static final String inputFileName = "../../input/input.txt";

    public static void main(String[] args) {
        System.out.println("Result of day 12 part 1: " + result(TokenOptimizerSolverV1::solve));
        System.out.println("Result of day 12 part 2: " + result(TokenOptimizerSolverV2::solve));
    }

    private static long result(Function<List<MachineConfiguration>, Long> solve) {
        List<MachineConfiguration> machineConfigurations;
        try {
            machineConfigurations = MachineConfigurationsParser.parse(inputFileName);
        } catch (Exception e) {
            e.printStackTrace();

            return 0;
        }

        return solve.apply(machineConfigurations);
    }
}
