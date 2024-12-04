package tkrippes.com.github.adventofcode2024.day03.parser;

import tkrippes.com.github.adventofcode2024.day03.Memory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MemoryParser {
    public void parse(String inputFileName) throws FileNotFoundException {
        File inputFile = new File(inputFileName);
        if (!inputFile.exists()) {
            throw new FileNotFoundException("Could not find input file: " + inputFileName);
        }
    }

    protected List<Memory.Multiplication> parseMultiplications(String input) {
        List<Memory.Multiplication> multiplications = new ArrayList<>();

        String regex = "mul\\((\\d{1,3}),(\\d{1,3})\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            multiplications.add(new Memory.Multiplication(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2))));
        }

        return multiplications;
    }
}
