package tkrippes.com.github.adventofcode2024.day01.solver;

import java.util.List;

public class SimilarityScoreSolver {
    public int solve(List<Integer> firstList, List<Integer> secondList) {
        if (firstList.size() != secondList.size()) {
            throw new IllegalArgumentException("firstList and secondList must have the same size");
        }

        int similarityScore = 0;
        for (int number : firstList) {
            int secondListOccurrences = (int) secondList.stream().filter(n -> n == number).count();
            similarityScore += number * secondListOccurrences;
        }

        return similarityScore;
    }
}
