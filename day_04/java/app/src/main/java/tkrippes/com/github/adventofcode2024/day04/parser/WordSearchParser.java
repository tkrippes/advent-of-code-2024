package tkrippes.com.github.adventofcode2024.day04.parser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WordSearchParser {
    public List<List<Character>> parse(String inputFileName) throws IOException {
        File inputFile = new File(inputFileName);
        if (!inputFile.exists()) {
            throw new FileNotFoundException("Could not find input file: " + inputFileName);
        }

        List<List<Character>> wordSearch;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            wordSearch = parseWordSearch(reader.lines().collect(Collectors.joining("\n")));
            reader.close();
        } catch (IOException e) {
            throw new IOException("Error reading file: " + inputFile, e);
        }

        return wordSearch;
    }

    protected List<List<Character>> parseWordSearch(String input) {
        if (input.isEmpty()) {
            return new ArrayList<>();
        }

        List<List<Character>> wordSearch = new ArrayList<>();
        for (String inputLine : input.lines().toList()) {
            if (doLineLengthDiffer(inputLine, wordSearch)) {
                throw new IllegalArgumentException("All input lines need to have the same length");
            }

            wordSearch.add(inputLine.chars().mapToObj(c -> (char) c).toList());
        }

        return wordSearch;
    }

    private boolean doLineLengthDiffer(String inputLine, List<List<Character>> wordSearch) {
        return !wordSearch.isEmpty() && inputLine.length() != wordSearch.getLast().size();
    }
}
