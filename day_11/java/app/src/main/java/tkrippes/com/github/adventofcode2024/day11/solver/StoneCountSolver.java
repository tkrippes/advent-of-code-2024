package tkrippes.com.github.adventofcode2024.day11.solver;

import tkrippes.com.github.adventofcode2024.day11.PlutonianPebble;

import java.util.ArrayList;
import java.util.List;

public class StoneCountSolver {
    public static long solve(List<PlutonianPebble> stones, int numberOfBlinks) {
        List<PlutonianPebble> result = new ArrayList<>(stones);
        for (int i = 0; i < numberOfBlinks; i++) {
            result = blink(result);
        }

        return result.size();
    }

    static List<PlutonianPebble> blink(List<PlutonianPebble> stones) {
        return stones.stream()
                .flatMap(stone -> stone.blink().stream())
                .toList();
    }
}
