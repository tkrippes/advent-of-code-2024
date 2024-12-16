package tkrippes.com.github.adventofcode2024.day07.solver;

import tkrippes.com.github.adventofcode2024.day07.Equation;
import tkrippes.com.github.adventofcode2024.day07.Operation;

import java.util.List;

public class TotalCalibrationResultSolver {
    public long solve(List<Equation> equations) {
        return equations.stream()
                .filter(this::isEquationSolvable)
                .mapToLong(Equation::result)
                .sum();
    }

    boolean isEquationSolvable(Equation equation) {
        int numberOfOperations = equation.operands().size() - 1;

        return Operation.getAllPossiblePermutations(numberOfOperations).stream()
                .anyMatch(permutation -> {
                    long currentResult = equation.operands().getFirst();
                    for (int i = 0; i < numberOfOperations; i++) {
                        Operation operation = permutation.get(i);
                        currentResult = operation.apply(currentResult, equation.operands().get(i + 1));
                    }

                    return currentResult == equation.result();
                });
    }
}
