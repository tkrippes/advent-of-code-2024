package tkrippes.com.github.adventofcode2024.day04;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class WordSearch {
    List<String> wordSearch;

    public WordSearch() {
        wordSearch = new ArrayList<>();
    }

    public List<String> getRows() {
        List<String> rows = new ArrayList<>();
        for (int i = 0; i < rowCount(); i++) {
            rows.add(wordSearch.get(i));
        }

        return rows;
    }

    public List<String> getColumns() {
        List<String> columns = new ArrayList<>();
        for (int i = 0; i < columnCount(); i++) {
            int finalI = i;
            columns.add(wordSearch.stream().reduce("", (column, row) -> column + row.charAt(finalI)));
        }

        return columns;
    }

    // TODO get diagonal (two ways) (up until width + height - 1, twice)

    public char getCharacter(int column, int row) {
        return wordSearch.get(row).charAt(column);
    }

    public void add(String characters) {
        if (columnCount() != 0 && characters.length() != columnCount()) {
            throw new IllegalArgumentException("All input lines need to have the same width");
        }

        wordSearch.add(characters);
    }

    public boolean isEmpty() {
        return wordSearch.isEmpty();
    }

    public int columnCount() {
        if (wordSearch.isEmpty()) {
            return 0;
        }

        return wordSearch.getFirst().length();
    }

    public int rowCount() {
        return wordSearch.size();
    }

    public int diagonalCount() {
        if (isEmpty()) {
            return 0;
        }

        return columnCount() + rowCount() - 1;
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
