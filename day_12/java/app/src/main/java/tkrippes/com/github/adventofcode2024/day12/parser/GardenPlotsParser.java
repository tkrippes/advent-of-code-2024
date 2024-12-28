package tkrippes.com.github.adventofcode2024.day12.parser;

import tkrippes.com.github.adventofcode2024.day12.GardenPlots;
import tkrippes.com.github.adventofcode2024.day12.Position;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GardenPlotsParser {
    public static GardenPlots parse(String inputFileName) throws IOException {
        File inputFile = new File(inputFileName);
        if (!inputFile.exists()) {
            throw new FileNotFoundException("Could not find input file: " + inputFileName);
        }

        GardenPlots plots;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            plots = parseGardenPlots(reader.lines().toList());
            reader.close();
        } catch (IOException e) {
            throw new IOException("Error reading file: " + inputFile, e);
        }

        return plots;
    }

    private static GardenPlots parseGardenPlots(List<String> inputLines) {
        Map<Position, Character> gardenPlot = new HashMap<>();
        for (int row = 0; row < inputLines.size(); row++) {
            String inputLine = inputLines.get(row);
            for (int column = 0; column < inputLine.length(); column++) {
                gardenPlot.put(new Position(row, column), inputLine.charAt(column));
            }
        }

        return new GardenPlots(gardenPlot);
    }
}
