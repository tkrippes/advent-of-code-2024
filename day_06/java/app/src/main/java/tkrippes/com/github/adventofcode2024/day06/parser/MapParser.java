package tkrippes.com.github.adventofcode2024.day06.parser;

import java.io.*;
import java.util.stream.Collectors;

public class MapParser {
    // TODO adapt to return type
    public int parse(String inputFileName) throws IOException {
        File inputFile = new File(inputFileName);
        if (!inputFile.exists()) {
            throw new FileNotFoundException("Could not find input file: " + inputFileName);
        }

        int map;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            map = parseMap(reader.lines().collect(Collectors.joining("\n")));
            reader.close();
        } catch (IOException e) {
            throw new IOException("Error reading file: " + inputFile, e);
        }

        return map;
    }

    // TODO adapt to return type
    int parseMap(String input) {
        return 0;
    }
}
