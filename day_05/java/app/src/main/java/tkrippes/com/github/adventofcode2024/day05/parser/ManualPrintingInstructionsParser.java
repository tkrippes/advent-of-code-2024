package tkrippes.com.github.adventofcode2024.day05.parser;

import tkrippes.com.github.adventofcode2024.day05.ManualPrintingInstructions;

import java.io.*;
import java.util.List;
import java.util.stream.Stream;

public class ManualPrintingInstructionsParser {
    public ManualPrintingInstructions parse(String inputFileName) throws IOException {
        File inputFile = new File(inputFileName);
        if (!inputFile.exists()) {
            throw new FileNotFoundException("Could not find input file: " + inputFileName);
        }

        ManualPrintingInstructions instructions;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));

            instructions = parseInstructions(reader.lines().toList());

            reader.close();
        } catch (IOException e) {
            throw new IOException("Error reading file: " + inputFile, e);
        }

        return instructions;
    }

    ManualPrintingInstructions parseInstructions(List<String> inputs) {
        if (!inputs.contains("")) {
            throw new IllegalArgumentException("Inputs do not contain an empty line to separate rules and pages input");
        }

        List<String> rulesInput = inputs.subList(0, inputs.indexOf(""));
        if (rulesInput.isEmpty()) {
            throw new IllegalArgumentException("Inputs do not contain any rules");
        }

        List<ManualPrintingInstructions.PageOrderingRule> rules = rulesInput
                .stream()
                .map(this::parseRule)
                .toList();

        List<String> updatesInput = inputs.subList(inputs.indexOf("") + 1, inputs.size());
        if (updatesInput.isEmpty()) {
            throw new IllegalArgumentException("Inputs do not contain any pages");
        }

        List<ManualPrintingInstructions.PageUpdate> updates = updatesInput
                .stream()
                .map(this::parseUpdate)
                .toList();

        return new ManualPrintingInstructions(rules, updates);
    }

    ManualPrintingInstructions.PageOrderingRule parseRule(String input) {
        String[] pageNumbers = input.split("\\|");
        if (pageNumbers.length != 2) {
            throw new IllegalArgumentException("Invalid input: '" + input + "' (expected: X|Y");
        }

        return new ManualPrintingInstructions.PageOrderingRule(Integer.parseInt(pageNumbers[0]),
                Integer.parseInt(pageNumbers[1]));
    }

    ManualPrintingInstructions.PageUpdate parseUpdate(String input) {
        String[] pageNumbers = input.split(",");
        if (pageNumbers.length == 0) {
            throw new IllegalArgumentException("Invalid input: '" + input + "' (expected: X,Y,Z,...");
        }

        return new ManualPrintingInstructions.PageUpdate(Stream.of(pageNumbers).map(Integer::parseInt).toList());
    }
}
