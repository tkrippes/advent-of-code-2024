package tkrippes.com.github.adventofcode2024.day07.parser;

import tkrippes.com.github.adventofcode2024.day07.Equation;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class EquationsParser {
    public List<Equation> parse(String inputFileName) throws IOException {
        File inputFile = new File(inputFileName);
        if (!inputFile.exists()) {
            throw new FileNotFoundException("Could not find input file: " + inputFileName);
        }

        List<Equation> equations = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            for (String input : reader.lines().toList()) {
                equations.add(parseEquation(input));
            }

            reader.close();
        } catch (IOException e) {
            throw new IOException("Error reading file: " + inputFile, e);
        }

        return equations;
    }

    private Equation parseEquation(String input) {
        String[] equationParts = input.split(":");
        int result = Integer.parseInt(equationParts[0]);
        List<Integer> operands = Stream.of(equationParts[1].trim().split(" "))
                .map(Integer::parseInt)
                .toList();

        return new Equation(result, operands);
    }
}
