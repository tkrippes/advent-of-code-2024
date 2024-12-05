package tkrippes.com.github.adventofcode2024.day03;

import tkrippes.com.github.adventofcode2024.day03.parser.MultiplicationsParser;
import tkrippes.com.github.adventofcode2024.day03.solver.MultiplicationsSolver;

import java.io.IOException;
import java.util.List;

public class Main {
    private static final String inputFileName = "../../input/input.txt";

    public static void main(String[] args) {
        System.out.println("Result of part 1: " + part1());
        System.out.println("Result of part 2: " + part2(inputFileName));
    }

    private static int part1() {
        MultiplicationsParser parser = new MultiplicationsParser();

        List<Multiplication> multiplications;
        try {
            multiplications = parser.parse(Main.inputFileName);
        } catch (IOException e) {
            e.printStackTrace();

            return 0;
        }

        MultiplicationsSolver solver = new MultiplicationsSolver();

        return solver.solve(multiplications);
    }

    private static int part2(String inputFileName) {
        // TODO
        return 0;
    }
}
