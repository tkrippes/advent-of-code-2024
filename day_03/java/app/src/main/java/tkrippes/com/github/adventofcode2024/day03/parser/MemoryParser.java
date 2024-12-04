package tkrippes.com.github.adventofcode2024.day03.parser;

import tkrippes.com.github.adventofcode2024.day03.Memory;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MemoryParser {
    public Memory parse(String inputFileName) throws IOException {
        File inputFile = new File(inputFileName);
        if (!inputFile.exists()) {
            throw new FileNotFoundException("Could not find input file: " + inputFileName);
        }

        Map<Integer, Memory.Multiplication> multiplications;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            multiplications = parseMultiplications(reader.lines().collect(Collectors.joining()));
            reader.close();
        } catch (IOException e) {
            throw new IOException("Error reading file: " + inputFile, e);
        }

        return new Memory(multiplications.values().stream().toList());
    }

    protected Map<Integer, Memory.Multiplication> parseMultiplications(String input) {
        // LinkedHashMap needed to preserve insertion order
        Map<Integer, Memory.Multiplication> multiplications = new LinkedHashMap<>();

        String regex = "mul\\((\\d{1,3}),(\\d{1,3})\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            multiplications.put(matcher.start(), new Memory.Multiplication(Integer.parseInt(matcher.group(1)),
                    Integer.parseInt(matcher.group(2))));
        }

        return multiplications;
    }
}
