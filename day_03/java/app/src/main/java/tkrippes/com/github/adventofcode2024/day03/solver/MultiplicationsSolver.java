package tkrippes.com.github.adventofcode2024.day03.solver;

import tkrippes.com.github.adventofcode2024.day03.Multiplication;

import java.util.List;

public class MultiplicationsSolver {
    public int solve(List<Multiplication> multiplications) {
        return multiplications.stream()
                .map(multiplication -> multiplication.firstMultiplicand() * multiplication.secondMultiplicand())
                .reduce(0, Integer::sum);
    }
}
