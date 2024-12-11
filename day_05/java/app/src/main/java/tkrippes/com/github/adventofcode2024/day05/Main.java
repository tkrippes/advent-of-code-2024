package tkrippes.com.github.adventofcode2024.day05;

import tkrippes.com.github.adventofcode2024.day05.parser.ManualPrintingInstructionsParser;
import tkrippes.com.github.adventofcode2024.day05.solver.ManualPrintingInstructionsSolver;

public class Main {
    private static final String inputFileName = "../../input/input.txt";

    public static void main(String[] args) {
        System.out.println("Result of part 1: " + part1());
    }

    private static int part1() {
        ManualPrintingInstructionsParser parser = new ManualPrintingInstructionsParser();
        ManualPrintingInstructions instructions;
        try {
            instructions = parser.parse(inputFileName);
        } catch (Exception e) {
            e.printStackTrace();

            return 0;
        }

        ManualPrintingInstructionsSolver solver = new ManualPrintingInstructionsSolver();
        int sumOfMiddlePageNumberOfCorrectlyOrderedUpdates;
        try {
            sumOfMiddlePageNumberOfCorrectlyOrderedUpdates = solver.solve(instructions);
        } catch (Exception e) {
            e.printStackTrace();

            return 0;
        }

        return sumOfMiddlePageNumberOfCorrectlyOrderedUpdates;
    }
}
