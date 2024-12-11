package tkrippes.com.github.adventofcode2024.day05;

import tkrippes.com.github.adventofcode2024.day05.parser.ManualPrintingInstructionsParser;
import tkrippes.com.github.adventofcode2024.day05.solver.CorrectlyOrderedUpdatesSolver;
import tkrippes.com.github.adventofcode2024.day05.solver.IncorrectlyOrderedUpdatesSolver;
import tkrippes.com.github.adventofcode2024.day05.solver.ManualPrintingInstructionsSolver;

public class Main {
    private static final String inputFileName = "../../input/input.txt";

    public static void main(String[] args) {
        System.out.println("Result of part 1: " + commonPart(new CorrectlyOrderedUpdatesSolver()));
        System.out.println("Result of part 2: " + commonPart(new IncorrectlyOrderedUpdatesSolver()));
    }

    private static int commonPart(ManualPrintingInstructionsSolver solver) {
        ManualPrintingInstructionsParser parser = new ManualPrintingInstructionsParser();
        ManualPrintingInstructions instructions;
        try {
            instructions = parser.parse(inputFileName);
        } catch (Exception e) {
            e.printStackTrace();

            return 0;
        }

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
