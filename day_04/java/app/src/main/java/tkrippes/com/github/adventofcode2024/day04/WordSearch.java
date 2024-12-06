package tkrippes.com.github.adventofcode2024.day04;

import java.util.ArrayList;
import java.util.List;

public class WordSearch {
    List<List<Character>> wordSearch;

    public WordSearch() {
        wordSearch = new ArrayList<>();
    }

    public List<List<Character>> get() {
        return wordSearch;
    }

    public char getCharacter(int column, int row) {
        return wordSearch.get(row).get(column);
    }

    public void add(List<Character> characters) {
        if (width() != 0 && characters.size() != width()) {
            throw new IllegalArgumentException("All input lines need to have the same width");
        }

        wordSearch.add(characters);
    }

    public int width() {
        if (wordSearch.isEmpty()) {
            return 0;
        }

        return wordSearch.getFirst().size();
    }

    public int height() {
        return wordSearch.size();
    }
}
