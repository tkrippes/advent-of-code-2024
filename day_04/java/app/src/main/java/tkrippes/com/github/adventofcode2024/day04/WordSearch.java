package tkrippes.com.github.adventofcode2024.day04;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class WordSearch {
    List<String> wordSearch;

    public WordSearch() {
        wordSearch = new ArrayList<>();
    }

    public void add(String characters) {
        if (columnCount() != 0 && characters.length() != columnCount()) {
            throw new IllegalArgumentException("All input lines need to have the same width");
        }

        wordSearch.add(characters);
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

    /*
     * Primary diagonals are those that run from the top left to the bottom righ
     *
     * Example:
     * A B C D
     * E F G H
     * I J K L
     *
     * --> primary diagonals: D, CH, BGL, AFK, EJ, I
     */
    public List<String> getPrimaryDiagonals() {
        List<String> primaryDiagonals = new ArrayList<>();

        for (int i = columnCount() - 1; i >= 0; i--) {
            primaryDiagonals.add(getPrimaryDiagonal(i, 0));
        }

        for (int j = 1; j < rowCount(); j++) {
            primaryDiagonals.add(getPrimaryDiagonal(0, j));
        }

        return primaryDiagonals;
    }

    private String getPrimaryDiagonal(int startColumn, int startRow) {
        StringBuilder primaryDiagonal = new StringBuilder();
        while (startColumn < columnCount() && startRow < rowCount()) {
            primaryDiagonal.append(wordSearch.get(startRow).charAt(startColumn));
            startColumn++;
            startRow++;
        }

        return primaryDiagonal.toString();
    }

    // TODO get diagonal (two ways) (up until width + height - 1, twice)

    public boolean isEmpty() {
        return wordSearch.isEmpty();
    }

    public int rowCount() {
        return wordSearch.size();
    }

    public int columnCount() {
        if (wordSearch.isEmpty()) {
            return 0;
        }

        return wordSearch.getFirst().length();
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
