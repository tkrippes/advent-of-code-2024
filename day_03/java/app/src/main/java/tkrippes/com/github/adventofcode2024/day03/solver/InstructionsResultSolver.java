package tkrippes.com.github.adventofcode2024.day03.solver;

import tkrippes.com.github.adventofcode2024.day03.Memory;

public class InstructionsResultSolver {
    public int solve(Memory memory) {
        return memory.multiplications().stream()
                .map(multiplication -> multiplication.firstNumber() * multiplication.secondNumber())
                .reduce(0, Integer::sum);
    }
}
