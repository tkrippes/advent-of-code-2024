package tkrippes.com.github.adventofcode2024.day04.solver;

import tkrippes.com.github.adventofcode2024.day04.WordSearch;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordSearchSolver {
    public int solve(WordSearch wordSearch, String word) {
        if (word.isEmpty()) {
            throw new IllegalArgumentException("Cannot search for empty word");
        }

        if (wordSearch.isEmpty()) {
            return 0;
        }

        return countWordsHorizontally(wordSearch, word) + countWordsHorizontallyReversed(wordSearch, word) +
                countWordsVertically(wordSearch, word) + countWordsVerticallyReversed(wordSearch, word);
    }

    private int countWordsHorizontally(WordSearch wordSearch, String word) {
        return countWords(wordSearch.getRows(), word, false);
    }

    private int countWordsHorizontallyReversed(WordSearch wordSearch, String word) {
        return countWords(wordSearch.getRows(), word, true);
    }

    private int countWordsVertically(WordSearch wordSearch, String word) {
        return countWords(wordSearch.getColumns(), word, false);
    }

    private int countWordsVerticallyReversed(WordSearch wordSearch, String word) {
        return countWords(wordSearch.getColumns(), word, true);
    }

    private int countWords(List<String> lines, String word, boolean reversed) {
        int wordCount = 0;
        Pattern pattern = reversed ? Pattern.compile(new StringBuilder(word).reverse().toString()) :
                Pattern.compile(word);

        for (String line : lines) {
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                wordCount++;
            }
        }
        return wordCount;
    }
}
