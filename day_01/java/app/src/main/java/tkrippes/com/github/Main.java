package tkrippes.com.github;

import java.io.IOException;
import java.util.List;

public class Main {
    private static final String inputFileName = "../../input/input.txt";

    public static void main(String[] args) {
        LocationIdListsParser parser = new LocationIdListsParser();
        try {
            List<List<Integer>> locationIdLists = parser.parse(inputFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
