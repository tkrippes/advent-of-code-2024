package tkrippes.com.github.adventofcode2024.day13.solver;

import tkrippes.com.github.adventofcode2024.day13.MachineConfiguration;
import tkrippes.com.github.adventofcode2024.day13.Position;

import java.util.List;

public class TokenOptimizerSolverV2 extends TokenOptimizerSolver {
    private static final long correctionFactor = 10000000000000L;

    public static long solve(List<MachineConfiguration> machineConfigurations) {
        return machineConfigurations.stream().map(TokenOptimizerSolverV2::calculateTokenCosts).filter(cost -> cost != -1).reduce(0L, Long::sum);
    }

    private static long calculateTokenCosts(MachineConfiguration machineConfiguration) {
        machineConfiguration = correctMachineConfiguration(machineConfiguration);

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

    private static MachineConfiguration correctMachineConfiguration(MachineConfiguration machineConfiguration) {
        return new MachineConfiguration(
                machineConfiguration.buttonA(),
                machineConfiguration.buttonB(),
                new Position(machineConfiguration.prizeLocation().x() + correctionFactor,
                        machineConfiguration.prizeLocation().y() + correctionFactor)
        );
    }

    private static boolean isInvalidPresses(double buttonPresses) {
        return isNotInteger(buttonPresses);
    }
}
