package tkrippes.com.github.adventofcode2024.day06.parser;

import tkrippes.com.github.adventofcode2024.day06.map.Position;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LapMapParser {
    public Map<Position, Boolean> parse(String inputFileName) throws IOException {
        File inputFile = new File(inputFileName);
        if (!inputFile.exists()) {
            throw new FileNotFoundException("Could not find input file: " + inputFileName);
        }

        Map<Position, Boolean> map;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            map = parseObstacleMap(reader.lines().collect(Collectors.joining("\n")));
            reader.close();
        } catch (IOException e) {
            throw new IOException("Error reading file: " + inputFile, e);
        }

        return map;
    }

    Map<Position, Boolean> parseObstacleMap(String input) {
        Map<Position, Boolean> map = new HashMap<>();

        List<String> inputLines = input.lines().toList();
        for (int x = 0; x < inputLines.size(); x++) {
            String inputLine = inputLines.get(x);
            for (int y = 0; y < inputLine.length(); y++) {
                map.put(new Position(x, y), isObstacle(inputLine.charAt(y)));
            }
        }

        return map;
    }

    private boolean isObstacle(char c) {
        return c == '#';
    }
}
