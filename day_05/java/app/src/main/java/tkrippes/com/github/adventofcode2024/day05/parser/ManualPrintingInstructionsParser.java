package tkrippes.com.github.adventofcode2024.day05.parser;

import tkrippes.com.github.adventofcode2024.day05.ManualPrintingInstructions;

import java.io.FileNotFoundException;
import java.util.stream.Stream;

public class ManualPrintingInstructionsParser {
    public ManualPrintingInstructions parse(String inputFileName) throws FileNotFoundException {
        throw new FileNotFoundException("Could not find input file: " + inputFileName);
    }

    ManualPrintingInstructions.PageOrderingRule parsePageOrderingRule(String input) {
        String[] pageNumbers = input.split("\\|");
        if (pageNumbers.length != 2) {
            throw new IllegalArgumentException("Invalid input: '" + input + "' (expected: X|Y");
        }

        return new ManualPrintingInstructions.PageOrderingRule(Integer.parseInt(pageNumbers[0]),
                Integer.parseInt(pageNumbers[1]));
    }

    ManualPrintingInstructions.PagesToProduce parsePagesToProduce(String input) {
        String[] pageNumbers = input.split(",");
        if (pageNumbers.length == 0) {
            throw new IllegalArgumentException("Invalid input: '" + input + "' (expected: X,Y,Z,...");
        }

        return new ManualPrintingInstructions.PagesToProduce(Stream.of(pageNumbers).map(Integer::parseInt).toList());
    }
}
