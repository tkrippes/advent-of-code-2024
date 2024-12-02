package tkrippes.com.github;

import tkrippes.com.github.parser.LocationIdListsParser;
import tkrippes.com.github.solver.ListDistanceSolver;
import tkrippes.com.github.solver.SimilarityScoreSolver;

import java.io.IOException;
import java.util.List;

public class Main {
    private static final String inputFileName = "../../input/input.txt";

    public static void main(String[] args) {
        System.out.println("Result of part 1: " + part1(inputFileName));
        System.out.println("Result of part 2: " + part2(inputFileName));
    }

    private static int part1(String inputFileName) {
        LocationIdListsParser parser = new LocationIdListsParser();

        List<List<Integer>> locationIdLists;
        try {
            locationIdLists = parser.parse(inputFileName);
        } catch (IOException e) {
            e.printStackTrace();

            return 0;
        }

        ListDistanceSolver solver = new ListDistanceSolver();
        int listDistance;
        try {
            listDistance = solver.solve(locationIdLists.get(0), locationIdLists.get(1));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();

            return 0;
        }

        return listDistance;
    }

    private static int part2(String inputFileName) {
        LocationIdListsParser parser = new LocationIdListsParser();

        List<List<Integer>> locationIdLists;
        try {
            locationIdLists = parser.parse(inputFileName);
        } catch (IOException e) {
            e.printStackTrace();

            return 0;
        }

        SimilarityScoreSolver solver = new SimilarityScoreSolver();
        int similarityScore;
        try {
            similarityScore = solver.solve(locationIdLists.get(0), locationIdLists.get(1));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();

            return 0;
        }

        return similarityScore;
    }
}
