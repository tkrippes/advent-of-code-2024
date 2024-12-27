package tkrippes.com.github.adventofcode2024.day11.solver;

import tkrippes.com.github.adventofcode2024.day11.PlutonianPebble;

import java.util.List;

public class StoneCountSolver {
    static List<PlutonianPebble> blink(List<PlutonianPebble> stones) {
        return stones.stream()
                .flatMap(stone -> stone.blink().stream())
                .toList();
    }
}
