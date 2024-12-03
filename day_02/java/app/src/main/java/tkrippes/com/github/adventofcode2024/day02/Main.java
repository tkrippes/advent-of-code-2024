package tkrippes.com.github.adventofcode2024.day02;

import tkrippes.com.github.adventofcode2024.day02.parser.ReportListParser;
import tkrippes.com.github.adventofcode2024.day02.solver.ReportSafetyCountSolver;

import java.io.IOException;
import java.util.List;

public class Main {
    private static final String inputFileName = "../../input/input.txt";

    public static void main(String[] args) {
        System.out.println("Result of part 1: " + part1(inputFileName));
        System.out.println("Result of part 2: " + part2(inputFileName));
    }

    private static int part1(String inputFileName) {
        return commonPart(inputFileName, 0);
    }

    private static int part2(String inputFileName) {
        return commonPart(inputFileName, 1);
    }

    private static int commonPart(String inputFileName, int tolerance) {
        ReportListParser parser = new ReportListParser();

        List<List<Integer>> reportList;
        try {
            reportList = parser.parse(inputFileName);
        } catch (IOException e) {
            e.printStackTrace();

            return 0;
        }

        ReportSafetyCountSolver solver = new ReportSafetyCountSolver();
        int numberOfSafeReports;
        try {
            numberOfSafeReports = solver.solve(reportList, tolerance);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();

            return 0;
        }

        return numberOfSafeReports;
    }
}
