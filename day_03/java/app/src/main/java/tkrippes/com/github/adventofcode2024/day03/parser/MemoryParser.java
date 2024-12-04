package tkrippes.com.github.adventofcode2024.day03.parser;

import tkrippes.com.github.adventofcode2024.day03.Memory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MemoryParser {
    public Memory parse(String inputFileName) throws IOException {
        File inputFile = new File(inputFileName);
        if (!inputFile.exists()) {
            throw new FileNotFoundException("Could not find input file: " + inputFileName);
        }

        List<Memory.Multiplication> multiplications = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));

            String line;
            while ((line = reader.readLine()) != null) {
                multiplications.addAll(parseMultiplications(line));
            }

            reader.close();
        } catch (IOException e) {
            throw new IOException("Error reading file: " + inputFile, e);
        }

        return new Memory(multiplications);
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
