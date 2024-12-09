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
     * Primary diagonals are those that run from the top left to the bottom right
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

    /*
     * Secondary diagonals are those that run from the top right to the bottom left
     *
     * Example:
     * A B C D
     * E F G H
     * I J K L
     *
     * --> primary diagonals: A, BE, CFI, DGJ, HK, L
     */
    public List<String> getSecondaryDiagonals() {
        List<String> secondaryDiagonals = new ArrayList<>();

        for (int i = 0; i < columnCount(); i++) {
            secondaryDiagonals.add(getSecondaryDiagonal(i, 0));
        }

        for (int j = 1; j < rowCount(); j++) {
            secondaryDiagonals.add(getSecondaryDiagonal(columnCount() - 1, j));
        }

        return secondaryDiagonals;
    }

    private String getSecondaryDiagonal(int startColumn, int startRow) {
        StringBuilder primaryDiagonal = new StringBuilder();
        while (startColumn >= 0 && startRow < rowCount()) {
            primaryDiagonal.append(wordSearch.get(startRow).charAt(startColumn));
            startColumn--;
            startRow++;
        }

        return primaryDiagonal.toString();
    }

    public List<WordSearch> getWordSearchWindows(int windowRowCount, int windowColumnCount) {
        if (windowRowCount == 0 || windowColumnCount == 0) {
            throw new IllegalArgumentException("Window row and column counts must be greater than 0");
        }

        if (isEmpty() || isOutOfBounds(windowRowCount, windowColumnCount)) {
            return new ArrayList<>();
        }

        List<WordSearch> wordSearchWindows = new ArrayList<>();
        for (int currentRow = 0; currentRow < rowCount() - windowRowCount + 1; currentRow++) {
            for (int currentColumn = 0; currentColumn < columnCount() - windowColumnCount + 1; currentColumn++) {
                WordSearch wordSearchWindow = new WordSearch();
                for (int currentRowOffset = 0; currentRowOffset < windowRowCount; currentRowOffset++) {
                    wordSearchWindow.add(wordSearch.get(currentRow + currentRowOffset).substring(currentColumn,
                            currentColumn + windowColumnCount));
                }

                wordSearchWindows.add(wordSearchWindow);
            }
        }

        return wordSearchWindows;
    }

    private boolean isOutOfBounds(int rowIndex, int columnIndex) {
        return rowIndex > rowCount() || columnIndex > columnCount();
    }

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
