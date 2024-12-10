package tkrippes.com.github.adventofcode2024.day05.parser;

import tkrippes.com.github.adventofcode2024.day05.ManualPrintingInstructions;

import java.io.FileNotFoundException;

public class ManualPrintingInstructionsParser {
    public ManualPrintingInstructions parse(String inputFileName) throws FileNotFoundException {
        throw new FileNotFoundException("Could not find input file: " + inputFileName);
    }

    ManualPrintingInstructions.PageOrderingRule parsePageOrderingRule(String input) {
        throw new IllegalArgumentException("Invalid input: '" + input + "' (expected: X|Y");
    }

    ManualPrintingInstructions.PagesToProduce parsePagesToProduce(String input) {
        throw new IllegalArgumentException("Invalid input: '" + input + "' (expected: X,Y,Z,...");
    }
}
