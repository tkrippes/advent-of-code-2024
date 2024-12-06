package tkrippes.com.github.adventofcode2024.day04.parser;

import tkrippes.com.github.adventofcode2024.day04.WordSearch;

import java.io.*;
import java.util.stream.Collectors;

public class WordSearchParser {
    public WordSearch parse(String inputFileName) throws IOException {
        File inputFile = new File(inputFileName);
        if (!inputFile.exists()) {
            throw new FileNotFoundException("Could not find input file: " + inputFileName);
        }

        WordSearch wordSearch;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            wordSearch = parseWordSearch(reader.lines().collect(Collectors.joining("\n")));
            reader.close();
        } catch (IOException e) {
            throw new IOException("Error reading file: " + inputFile, e);
        }

        return wordSearch;
    }

    WordSearch parseWordSearch(String input) {
        if (input.isEmpty()) {
            return new WordSearch();
        }

        WordSearch wordSearch = new WordSearch();
        for (String inputLine : input.lines().toList()) {
            if (doLineLengthDiffer(inputLine, wordSearch)) {
                throw new IllegalArgumentException("All input lines need to have the same length");
            }

            wordSearch.add(inputLine.chars().mapToObj(c -> (char) c).toList());
        }

        return wordSearch;
    }

    private boolean doLineLengthDiffer(String inputLine, WordSearch wordSearch) {
        return !wordSearch.isEmpty() && inputLine.length() != wordSearch.width();
    }
}
