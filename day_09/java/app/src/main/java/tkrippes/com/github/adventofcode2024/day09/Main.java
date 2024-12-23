package tkrippes.com.github.adventofcode2024.day09;

import tkrippes.com.github.adventofcode2024.day09.parser.DiskMapParser;
import tkrippes.com.github.adventofcode2024.day09.solver.FilesystemChecksumSolverV1;
import tkrippes.com.github.adventofcode2024.day09.solver.FilesystemChecksumSolverV2;

import java.util.function.Function;

public class Main {
    private static final String inputFileName = "../../input/input.txt";

    public static void main(String[] args) {
        System.out.println("Result of day 9 part 1: " + result(FilesystemChecksumSolverV1::solve));
        System.out.println("Result of day 9 part 2: " + result(FilesystemChecksumSolverV2::solve));
    }

    private static long result(Function<DiskMap, Long> solve) {
        DiskMap map;
        try {
            map = DiskMapParser.parse(inputFileName);
        } catch (Exception e) {
            e.printStackTrace();

            return 0;
        }

        return solve.apply(map);
    }
}
