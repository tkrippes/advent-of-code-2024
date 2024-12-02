package tkrippes.com.github.parser;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LocationIdListsParser {
    public List<List<Integer>> parse(String inputFileName) throws IOException {
        File inputFile = new File(inputFileName);
        if (!inputFile.exists()) {
            throw new FileNotFoundException("Could not find input file: " + inputFileName);
        }

        List<List<Integer>> locationIdLists = new ArrayList<>(Arrays.asList(new ArrayList<>(), new ArrayList<>()));

        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split("\\s+");
                if (tokens.length != 2) {
                    System.err.printf("Ignoring line, got %d instead of 2 tokens%n", tokens.length);

                    continue;
                }

                locationIdLists.get(0).add(Integer.parseInt(tokens[0]));
                locationIdLists.get(1).add(Integer.parseInt(tokens[1]));
            }

            reader.close();
        } catch (IOException e) {
            throw new IOException("Error reading file: " + inputFileName, e);
        }

        return locationIdLists;
    }
}
