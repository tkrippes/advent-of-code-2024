package tkrippes.com.github.adventofcode2024.day11.solver;

import tkrippes.com.github.adventofcode2024.day11.PlutonianPebble;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StoneCountSolver {
    private record CacheKey(PlutonianPebble stone, int numberOfBlinks) {
    }

    private static final Map<CacheKey, Long> cache = new HashMap<>();

    public static long solve(List<PlutonianPebble> stones, int numberOfBlinks) {
        return stones.stream()
                .mapToLong(stone -> getStoneCount(stone, numberOfBlinks))
                .sum();
    }

    private static long getStoneCount(PlutonianPebble stone, int numberOfBlinks) {
        CacheKey key = new CacheKey(stone, numberOfBlinks);

        return cache.containsKey(key) ? cache.get(key) : calculateStoneCount(stone, numberOfBlinks);
    }

    private static long calculateStoneCount(PlutonianPebble stone, int numberOfBlinks) {
        long stoneCount = numberOfBlinks == 0 ? 1 :
                stone.blink().stream().mapToLong(newStone -> getStoneCount(newStone, numberOfBlinks - 1)).sum();
        cache.put(new CacheKey(stone, numberOfBlinks), stoneCount);

        return stoneCount;
    }
}
