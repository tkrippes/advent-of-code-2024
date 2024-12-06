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

        return countWordsLeftToRight(wordSearch, word) + countWordsRightToLeft(wordSearch, word);
    }

    public int countWordsLeftToRight(WordSearch wordSearch, String word) {
        int wordCount = 0;
        Pattern pattern = Pattern.compile(word);
        for (int i = 0; i < wordSearch.height(); i++) {
            Matcher matcher = pattern.matcher(wordSearch.getRow(i));
            while (matcher.find()) {
                wordCount++;
            }
        }

        return wordCount;
    }

    public int countWordsRightToLeft(WordSearch wordSearch, String word) {
        int wordCount = 0;
        Pattern pattern = Pattern.compile(new StringBuilder(word).reverse().toString());
        for (int i = 0; i < wordSearch.height(); i++) {
            Matcher matcher = pattern.matcher(wordSearch.getRow(i));
            while (matcher.find()) {
                wordCount++;
            }
        }

        return wordCount;
    }
}
