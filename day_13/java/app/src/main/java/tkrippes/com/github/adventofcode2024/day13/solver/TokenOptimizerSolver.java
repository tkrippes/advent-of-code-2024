package tkrippes.com.github.adventofcode2024.day13.solver;

import tkrippes.com.github.adventofcode2024.day13.Direction;
import tkrippes.com.github.adventofcode2024.day13.MachineConfiguration;
import tkrippes.com.github.adventofcode2024.day13.Position;

import java.util.Map;

public class TokenOptimizerSolver {
    protected static final Map<Character, Integer> buttonTokenCostMap = Map.of('A', 3, 'B', 1);

    protected static double calculateButtonAPresses(MachineConfiguration machineConfiguration) {
        // solves equation system for button A
        Direction buttonA = machineConfiguration.buttonA();
        Direction buttonB = machineConfiguration.buttonB();
        Position prizeLocation = machineConfiguration.prizeLocation();

        return (double) (buttonB.x() * prizeLocation.y() - buttonB.y() * prizeLocation.x()) /
                (double) (buttonA.y() * buttonB.x() - buttonA.x() * buttonB.y());
    }

    protected static double calculateButtonBPresses(MachineConfiguration machineConfiguration) {
        // solves equation system for button B
        Direction buttonA = machineConfiguration.buttonA();
        Direction buttonB = machineConfiguration.buttonB();
        Position prizeLocation = machineConfiguration.prizeLocation();

        return (double) (buttonA.x() * prizeLocation.y() - buttonA.y() * prizeLocation.x()) /
                (double) (buttonA.x() * buttonB.y() - buttonA.y() * buttonB.x());
    }

    protected static boolean isNotInteger(double number) {
        return number != (long) number;
    }
}
