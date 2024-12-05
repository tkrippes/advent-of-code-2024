package tkrippes.com.github.adventofcode2024.day03.parser;

import tkrippes.com.github.adventofcode2024.day03.Multiplication;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MultiplicationsParser {
    private final MultiplicationFilter filter = new MultiplicationFilter();

    public List<Multiplication> parse(String inputFileName) throws IOException {
        return parse(inputFileName, false);
    }

    public List<Multiplication> parse(String inputFileName, boolean useFilter) throws IOException {
        File inputFile = new File(inputFileName);
        if (!inputFile.exists()) {
            throw new FileNotFoundException("Could not find input file: " + inputFileName);
        }

        Map<Integer, Multiplication> multiplicationsMap;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            multiplicationsMap = parseMultiplications(reader.lines().collect(Collectors.joining()));
            reader.close();
        } catch (IOException e) {
            throw new IOException("Error reading file: " + inputFile, e);
        }

        if (!useFilter) {
            return multiplicationsMap.values().stream().toList();
        }

        Map<Integer, Boolean> shouldParseMap;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            shouldParseMap = parseDosAndDonts(reader.lines().collect(Collectors.joining()));
            reader.close();
        } catch (IOException e) {
            throw new IOException("Error reading file: " + inputFile, e);
        }

        return filter.filter(multiplicationsMap, shouldParseMap);
    }

    protected Map<Integer, Multiplication> parseMultiplications(String input) {
        // TreeMap needed to sort by position
        Map<Integer, Multiplication> multiplications = new TreeMap<>();

        String regex = "mul\\((\\d{1,3}),(\\d{1,3})\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            multiplications.put(matcher.start(), new Multiplication(Integer.parseInt(matcher.group(1)),
                    Integer.parseInt(matcher.group(2))));
        }

        return multiplications;
    }

    protected Map<Integer, Boolean> parseDosAndDonts(String input) {
        // TreeMap needed to sort by position
        Map<Integer, Boolean> dosAndDonts = new TreeMap<>();

        String dosRegex = "do\\(\\)";
        Pattern dosPattern = Pattern.compile(dosRegex);
        Matcher dosMatcher = dosPattern.matcher(input);

        while (dosMatcher.find()) {
            dosAndDonts.put(dosMatcher.start(), true);
        }

        String dontsRegex = "don't\\(\\)";
        Pattern dontsPattern = Pattern.compile(dontsRegex);
        Matcher dontsMatcher = dontsPattern.matcher(input);

        while (dontsMatcher.find()) {
            dosAndDonts.put(dontsMatcher.start(), false);
        }

        return dosAndDonts;
    }
}
