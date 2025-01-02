package tkrippes.com.github.adventofcode2024.day13.solver;

import tkrippes.com.github.adventofcode2024.day13.Direction;
import tkrippes.com.github.adventofcode2024.day13.MachineConfiguration;
import tkrippes.com.github.adventofcode2024.day13.Position;

import java.util.List;
import java.util.Map;

public class TokenOptimizerSolver {
    private static final Map<Character, Integer> buttonTokenCostMap = Map.of('A', 3, 'B', 1);
    private static final int maxNumberOfPresses = 100;

    public static long solve(List<MachineConfiguration> machineConfigurations) {
        return machineConfigurations.stream().map(TokenOptimizerSolver::calculateTokenCosts).filter(cost -> cost != -1).reduce(0L, Long::sum);
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

    private static double calculateButtonAPresses(MachineConfiguration machineConfiguration) {
        // solves equation system for button A
        Direction buttonA = machineConfiguration.buttonA();
        Direction buttonB = machineConfiguration.buttonB();
        Position prizeLocation = machineConfiguration.prizeLocation();

        return (double) (buttonB.x() * prizeLocation.y() - buttonB.y() * prizeLocation.x()) /
                (double) (buttonA.y() * buttonB.x() - buttonA.x() * buttonB.y());
    }

    private static double calculateButtonBPresses(MachineConfiguration machineConfiguration) {
        // solves equation system for button B
        Direction buttonA = machineConfiguration.buttonA();
        Direction buttonB = machineConfiguration.buttonB();
        Position prizeLocation = machineConfiguration.prizeLocation();

        return (double) (buttonA.x() * prizeLocation.y() - buttonA.y() * prizeLocation.x()) /
                (double) (buttonA.x() * buttonB.y() - buttonA.y() * buttonB.x());
    }

    private static boolean isInvalidPresses(double buttonPresses) {
        return (isNotInteger(buttonPresses) || buttonPresses > maxNumberOfPresses);
    }

    private static boolean isNotInteger(double number) {
        return number != (long) number;
    }
}
