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

    public long solve(List<Equation> equations, boolean includeConcatenation) {
        return equations.stream()
                .filter(equation -> isEquationSolvable(equation, includeConcatenation))
                .mapToLong(Equation::result)
                .sum();
    }

    boolean isEquationSolvable(Equation equation) {
        return isEquationSolvable(equation, false);
    }

    boolean isEquationSolvable(Equation equation, boolean includeConcatenation) {
        int numberOfOperations = equation.operands().size() - 1;

        return Operation.getAllPossiblePermutations(numberOfOperations, includeConcatenation).stream()
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
