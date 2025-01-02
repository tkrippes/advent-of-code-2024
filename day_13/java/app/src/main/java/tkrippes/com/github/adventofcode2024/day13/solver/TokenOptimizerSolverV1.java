package tkrippes.com.github.adventofcode2024.day13.solver;

import tkrippes.com.github.adventofcode2024.day13.MachineConfiguration;

import java.util.List;

public class TokenOptimizerSolverV1 extends TokenOptimizerSolver {
    private static final int maxNumberOfPresses = 100;

    public static long solve(List<MachineConfiguration> machineConfigurations) {
        return machineConfigurations.stream().map(TokenOptimizerSolverV1::calculateTokenCosts).filter(cost -> cost != -1).reduce(0L, Long::sum);
    }

    private static long calculateTokenCosts(MachineConfiguration machineConfiguration) {
        double buttonAPresses = calculateButtonAPresses(machineConfiguration);
        if (isInvalidPresses(buttonAPresses)) {
            return -1;
        }

        double buttonBPresses = calculateButtonBPresses(machineConfiguration);
        if (isInvalidPresses(buttonBPresses)) {
            return -1;
        }

        return ((long) buttonAPresses * buttonTokenCostMap.get('A') + (long) buttonBPresses * buttonTokenCostMap.get('B'));
    }

    private static boolean isInvalidPresses(double buttonPresses) {
        return (isNotInteger(buttonPresses) || buttonPresses > maxNumberOfPresses);
    }
}
