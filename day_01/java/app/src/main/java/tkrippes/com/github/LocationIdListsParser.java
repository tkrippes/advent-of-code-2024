package tkrippes.com.github;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LocationIdListsParser {
    // TODO split function (private)
    public List<List<Integer>> parse(String inputFileName) throws IOException {
        File inputFile = new File(inputFileName);
        if (!inputFile.exists()) {
            throw new FileNotFoundException("Could not find input file: " + inputFileName);
        }

        List<List<Integer>> locationIdLists = new ArrayList<>(Arrays.asList(new ArrayList<>(), new ArrayList<>()));

        try {
            FileReader fileReader = new FileReader(inputFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] tokens = line.split("\\s+");
                if (tokens.length != 2) {
                    System.err.printf("Ignoring line, got %d instead of 2 tokens%n", tokens.length);

                    continue;
                }

                locationIdLists.get(0).add(Integer.parseInt(tokens[0]));
                locationIdLists.get(1).add(Integer.parseInt(tokens[1]));
            }
        } catch (IOException e) {
            throw new IOException("Error reading file: " + inputFileName, e);
        }

        return locationIdLists;
    }
}
