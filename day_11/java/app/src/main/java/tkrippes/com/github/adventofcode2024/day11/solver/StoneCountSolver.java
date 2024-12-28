package tkrippes.com.github.adventofcode2024.day11.solver;

import tkrippes.com.github.adventofcode2024.day11.PlutonianPebble;

import java.util.List;

public class StoneCountSolver {
    public static long solve(List<PlutonianPebble> stones, int numberOfBlinks) {
        return stones.stream()
                .mapToLong(stone -> calculateStoneCount(stone, numberOfBlinks))
                .sum();
    }

    private static long calculateStoneCount(PlutonianPebble stone, int numberOfBlinks) {
        return numberOfBlinks == 0 ? 1 :
                stone.blink().stream().mapToLong(newStone -> calculateStoneCount(newStone, numberOfBlinks - 1)).sum();
    }
}
