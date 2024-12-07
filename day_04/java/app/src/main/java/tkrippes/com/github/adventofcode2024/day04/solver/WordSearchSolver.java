package tkrippes.com.github.adventofcode2024.day04.solver;

import tkrippes.com.github.adventofcode2024.day04.WordSearch;

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

    public int countWordsHorizontally(WordSearch wordSearch, String word) {
        int wordCount = 0;
        Pattern pattern = Pattern.compile(word);
        for (String row : wordSearch.getRows()) {
            Matcher matcher = pattern.matcher(row);
            while (matcher.find()) {
                wordCount++;
            }
        }

        return wordCount;
    }

    public int countWordsHorizontallyReversed(WordSearch wordSearch, String word) {
        int wordCount = 0;
        Pattern pattern = Pattern.compile(new StringBuilder(word).reverse().toString());
        for (String row : wordSearch.getRows()) {
            Matcher matcher = pattern.matcher(row);
            while (matcher.find()) {
                wordCount++;
            }
        }

        return wordCount;
    }

    public int countWordsVertically(WordSearch wordSearch, String word) {
        int wordCount = 0;
        Pattern pattern = Pattern.compile(word);
        for (String column : wordSearch.getColumns()) {
            Matcher matcher = pattern.matcher(column);
            while (matcher.find()) {
                wordCount++;
            }
        }

        return wordCount;
    }

    public int countWordsVerticallyReversed(WordSearch wordSearch, String word) {
        int wordCount = 0;
        Pattern pattern = Pattern.compile(new StringBuilder(word).reverse().toString());
        for (String column : wordSearch.getColumns()) {
            Matcher matcher = pattern.matcher(column);
            while (matcher.find()) {
                wordCount++;
            }
        }

        return wordCount;
    }
}
