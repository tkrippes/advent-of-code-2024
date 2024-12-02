package tkrippes.com.github;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LocationIdListsParser {
    // TODO split function (private)
    public List<List<Integer>> parse(String inputFileName) throws IOException {
        File inputFile = new File(inputFileName);
        if (!inputFile.exists()) {
            throw new FileNotFoundException("Could not find input file: " + inputFileName);
        }

        List<List<Integer>> locationIdLists = new ArrayList<>();
        List<Integer> firstLocationIdList = new ArrayList<>();
        List<Integer> secondLocationIdList = new ArrayList<>();

        // TODO fix logic
        try {
            FileReader fileReader = new FileReader(inputFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] tokens = line.split(" ");
                if (tokens.length != 2) {
                    continue;
                }

                firstLocationIdList.add(Integer.parseInt(tokens[0]));
                secondLocationIdList.add(Integer.parseInt(tokens[1]));
            }
        } catch (IOException e) {
            throw new IOException("Error reading file: " + inputFileName, e);
        }

        locationIdLists.add(firstLocationIdList);
        locationIdLists.add(secondLocationIdList);

        return locationIdLists;
    }
}
