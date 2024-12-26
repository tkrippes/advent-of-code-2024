package tkrippes.com.github.adventofcode2024.day10.parser;

import tkrippes.com.github.adventofcode2024.day10.Position;
import tkrippes.com.github.adventofcode2024.day10.TopographicMap;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopographicMapParser {
    public static TopographicMap parse(String inputFileName) throws IOException {
        File inputFile = new File(inputFileName);
        if (!inputFile.exists()) {
            throw new FileNotFoundException("Could not find input file: " + inputFileName);
        }

        TopographicMap map;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            map = parseTopographicMap(reader.lines().toList());
            reader.close();
        } catch (IOException e) {
            throw new IOException("Error reading file: " + inputFile, e);
        }

        return map;
    }

    private static TopographicMap parseTopographicMap(List<String> inputLines) {
        int mapWidth = inputLines.getFirst().length();
        int mapHeight = inputLines.size();

        Map<Position, Integer> heightMap = new HashMap<>();
        for (int row = 0; row < inputLines.size(); row++) {
            String inputLine = inputLines.get(row);
            for (int column = 0; column < inputLine.length(); column++) {
                if (Character.isDigit(inputLine.charAt(column))) {
                    heightMap.put(new Position(row, column), Character.getNumericValue(inputLine.charAt(column)));
                }
            }
        }

        return new TopographicMap(heightMap, mapWidth, mapHeight);
    }
}
