package tkrippes.com.github.adventofcode2024.day11.parser;

import tkrippes.com.github.adventofcode2024.day11.PlutonianPebble;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PlutonianPebblesParser {
    public static List<PlutonianPebble> parse(String inputFileName) throws IOException {
        File inputFile = new File(inputFileName);
        if (!inputFile.exists()) {
            throw new FileNotFoundException("Could not find input file: " + inputFileName);
        }

        List<PlutonianPebble> stones;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            stones = parsePlutonianPebbles(reader.lines().collect(Collectors.joining(" ")));
            reader.close();
        } catch (IOException e) {
            throw new IOException("Error reading file: " + inputFile, e);
        }

        return stones;
    }

    private static List<PlutonianPebble> parsePlutonianPebbles(String input) {
        List<PlutonianPebble> stones = new ArrayList<>();
        for (String pebbleInput : input.split(" ")) {
            stones.add(new PlutonianPebble(Long.parseLong(pebbleInput)));
        }

        return stones;
    }
}
