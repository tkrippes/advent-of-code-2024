package tkrippes.com.github.adventofcode2024.day06.parser;

import tkrippes.com.github.adventofcode2024.day06.map.Guard;
import tkrippes.com.github.adventofcode2024.day06.map.LabMap;
import tkrippes.com.github.adventofcode2024.day06.map.Position;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LapMapParser {
    public LabMap parse(String inputFileName) throws IOException {
        File inputFile = new File(inputFileName);
        if (!inputFile.exists()) {
            throw new FileNotFoundException("Could not find input file: " + inputFileName);
        }

        LabMap map;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            String input = reader.lines().collect(Collectors.joining("\n"));
            map = new LabMap(parseObstacleMap(input), parseGuard(input));
            reader.close();
        } catch (IOException e) {
            throw new IOException("Error reading file: " + inputFile, e);
        }

        return map;
    }

    Map<Position, Boolean> parseObstacleMap(String input) {
        Map<Position, Boolean> map = new HashMap<>();

        List<String> inputLines = input.lines().toList();
        for (int row = 0; row < inputLines.size(); row++) {
            String inputLine = inputLines.get(row);
            for (int column = 0; column < inputLine.length(); column++) {
                map.put(new Position(row, column), isObstacle(inputLine.charAt(column)));
            }
        }

        return map;
    }

    Guard parseGuard(String input) {
        List<String> inputLines = input.lines().toList();
        for (int row = 0; row < inputLines.size(); row++) {
            String inputLine = inputLines.get(row);
            for (int column = 0; column < inputLine.length(); column++) {
                if (isGuard(inputLine.charAt(column))) {
                    return new Guard(new Position(row, column));
                }
            }
        }

        throw new IllegalArgumentException("No guard found in input");
    }

    private boolean isObstacle(char c) {
        return c == '#';
    }

    private boolean isGuard(char c) {
        return c == '^';
    }
}
