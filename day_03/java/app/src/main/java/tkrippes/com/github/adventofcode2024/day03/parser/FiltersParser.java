package tkrippes.com.github.adventofcode2024.day03.parser;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class FiltersParser {
    public Map<Integer, Boolean> parse(String inputFileName) throws IOException {
        File inputFile = new File(inputFileName);
        if (!inputFile.exists()) {
            throw new FileNotFoundException("Could not find input file: " + inputFileName);
        }

        Map<Integer, Boolean> filters;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            filters = parseFilters(reader.lines().collect(Collectors.joining()));
            reader.close();
        } catch (IOException e) {
            throw new IOException("Error reading file: " + inputFile, e);
        }

        return filters;
    }

    protected Map<Integer, Boolean> parseFilters(String input) {
        // TreeMap needed to sort by position
        Map<Integer, Boolean> filtersMap = new TreeMap<>();

        String dosRegex = "do\\(\\)";
        Pattern dosPattern = Pattern.compile(dosRegex);
        Matcher dosMatcher = dosPattern.matcher(input);

        while (dosMatcher.find()) {
            filtersMap.put(dosMatcher.start(), false);
        }

        String dontsRegex = "don't\\(\\)";
        Pattern dontsPattern = Pattern.compile(dontsRegex);
        Matcher dontsMatcher = dontsPattern.matcher(input);

        while (dontsMatcher.find()) {
            filtersMap.put(dontsMatcher.start(), true);
        }

        return filtersMap;
    }
}
