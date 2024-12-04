package tkrippes.com.github.adventofcode2024.day03;

import tkrippes.com.github.adventofcode2024.day03.parser.MemoryParser;
import tkrippes.com.github.adventofcode2024.day03.solver.InstructionsResultSolver;

import java.io.IOException;

public class Main {
    private static final String inputFileName = "../../input/input.txt";

    public static void main(String[] args) {
        System.out.println("Result of part 1: " + part1());
        System.out.println("Result of part 2: " + part2(inputFileName));
    }

    private static int part1() {
        MemoryParser parser = new MemoryParser();

        Memory memory;
        try {
            memory = parser.parse(Main.inputFileName);
        } catch (IOException e) {
            e.printStackTrace();

            return 0;
        }

        InstructionsResultSolver solver = new InstructionsResultSolver();

        return solver.solve(memory);
    }

    private static int part2(String inputFileName) {
        // TODO
        return 0;
    }
}
