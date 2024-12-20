package tkrippes.com.github.adventofcode2024.day09;

import tkrippes.com.github.adventofcode2024.day09.parser.DiskMapParser;
import tkrippes.com.github.adventofcode2024.day09.solver.FilesystemChecksumSolver;

public class Main {
    private static final String inputFileName = "../../input/input.txt";

    // TODO try to use long everywhere
    public static void main(String[] args) {
        System.out.println("Result of day 9 part 1: " + resultPart1());
    }

    private static long resultPart1() {
        DiskMap map;
        try {
            map = DiskMapParser.parse(inputFileName);
        } catch (Exception e) {
            e.printStackTrace();

            return 0;
        }

        return FilesystemChecksumSolver.solve(map);
    }
}
