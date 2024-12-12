package tkrippes.com.github.adventofcode2024.day06.parser;

import tkrippes.com.github.adventofcode2024.day06.Entity;
import tkrippes.com.github.adventofcode2024.day06.Position;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class MapParser {
    public Map<Position, Optional<Entity>> parse(String inputFileName) throws IOException {
        File inputFile = new File(inputFileName);
        if (!inputFile.exists()) {
            throw new FileNotFoundException("Could not find input file: " + inputFileName);
        }

        Map<Position, Optional<Entity>> map;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            map = parseMap(reader.lines().collect(Collectors.joining("\n")));
            reader.close();
        } catch (IOException e) {
            throw new IOException("Error reading file: " + inputFile, e);
        }

        return map;
    }

    Map<Position, Optional<Entity>> parseMap(String input) {
        // TODO
        return new HashMap<>();
    }
}
