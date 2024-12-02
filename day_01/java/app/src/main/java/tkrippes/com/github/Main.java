package tkrippes.com.github;

import tkrippes.com.github.parser.LocationIdListsParser;
import tkrippes.com.github.solver.ListDistanceSolver;

import java.io.IOException;
import java.util.List;

public class Main {
    private static final String inputFileName = "../../input/input.txt";

    public static void main(String[] args) {
        System.out.println("Result of part 1: " + part1(inputFileName));
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
        int solution;
        try {
            solution = solver.solve(locationIdLists.get(0), locationIdLists.get(1));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();

            return 0;
        }

        return solution;
    }
}
