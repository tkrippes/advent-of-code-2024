package tkrippes.com.github.adventofcode2024.day01.solver;

import java.util.List;

public class ListDistanceSolver {
    public int solve(List<Integer> firstList, List<Integer> secondList) {
        if (firstList.size() != secondList.size()) {
            throw new IllegalArgumentException("firstList and secondList must have the same size");
        }

        List<Integer> sortedFirstList = firstList.stream().sorted().toList();
        List<Integer> sortedSecondList = secondList.stream().sorted().toList();

        int totalDistance = 0;
        for (int i = 0; i < sortedFirstList.size(); i++) {
            totalDistance += Math.abs(sortedFirstList.get(i) - (int) sortedSecondList.get(i));
        }

        return totalDistance;
    }
}
