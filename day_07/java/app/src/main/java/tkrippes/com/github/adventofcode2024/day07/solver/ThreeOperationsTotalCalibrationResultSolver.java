package tkrippes.com.github.adventofcode2024.day07.solver;

import tkrippes.com.github.adventofcode2024.day07.Equation;

public class ThreeOperationsTotalCalibrationResultSolver extends TotalCalibrationResultSolver {
    protected boolean isEquationSolvable(Equation equation) {
        return isEquationSolvable(equation, true);
    }
}
