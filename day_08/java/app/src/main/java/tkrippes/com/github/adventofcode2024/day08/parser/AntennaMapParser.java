package tkrippes.com.github.adventofcode2024.day08.parser;

import tkrippes.com.github.adventofcode2024.day08.AntennaMap;
import tkrippes.com.github.adventofcode2024.day08.Position;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AntennaMapParser {
    public AntennaMap parse(String inputFileName) throws IOException {
        File inputFile = new File(inputFileName);
        if (!inputFile.exists()) {
            throw new FileNotFoundException("Could not find input file: " + inputFileName);
        }

        AntennaMap map;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            map = parseAntennaMap(reader.lines().toList());
            reader.close();
        } catch (IOException e) {
            throw new IOException("Error reading file: " + inputFile, e);
        }

        return map;
    }

    private AntennaMap parseAntennaMap(List<String> inputLines) {
        int mapWidth = inputLines.getFirst().length();
        int mapHeight = inputLines.size();

        Map<Position, Character> frequencyMap = new HashMap<>();
        for (int row = 0; row < inputLines.size(); row++) {
            String inputLine = inputLines.get(row);
            for (int column = 0; column < inputLine.length(); column++) {
                if (inputLine.charAt(column) != '.') {
                    frequencyMap.put(new Position(row, column), inputLine.charAt(column));
                }
            }
        }

        return new AntennaMap(frequencyMap, mapWidth, mapHeight);
    }
}
