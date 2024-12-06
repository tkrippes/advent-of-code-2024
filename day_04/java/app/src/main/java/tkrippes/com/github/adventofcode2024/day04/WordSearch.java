package tkrippes.com.github.adventofcode2024.day04;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class WordSearch {
    List<String> wordSearch;

    public WordSearch() {
        wordSearch = new ArrayList<>();
    }

    public char getCharacter(int column, int row) {
        return wordSearch.get(row).charAt(column);
    }

    public void add(String characters) {
        if (width() != 0 && characters.length() != width()) {
            throw new IllegalArgumentException("All input lines need to have the same width");
        }

        wordSearch.add(characters);
    }

    public boolean isEmpty() {
        return wordSearch.isEmpty();
    }

    public int width() {
        if (wordSearch.isEmpty()) {
            return 0;
        }

        return wordSearch.getFirst().length();
    }

    public int height() {
        return wordSearch.size();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        WordSearch other = (WordSearch) obj;
        return Objects.equals(wordSearch, other.wordSearch);
    }
}
