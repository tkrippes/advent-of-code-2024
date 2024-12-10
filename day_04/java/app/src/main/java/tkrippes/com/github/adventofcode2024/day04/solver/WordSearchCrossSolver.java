package tkrippes.com.github.adventofcode2024.day04.solver;

import tkrippes.com.github.adventofcode2024.day04.WordSearch;

public class WordSearchCrossSolver {
    public int solve(WordSearch wordSearch, String word) {
        if (word.isEmpty()) {
            throw new IllegalArgumentException("Cannot search for empty word");
        }

        int wordCount = 0;
        for (WordSearch wordSearchWindow : wordSearch.getWordSearchWindows(word.length(), word.length())) {
            if (containsCrossedWord(wordSearchWindow, word)) {
                wordCount++;
            }
        }

        return wordCount;
    }

    private boolean containsCrossedWord(WordSearch wordSearch, String word) {
        String primaryDiagonal = wordSearch.getPrimaryDiagonal();
        String secondaryDiagonal = wordSearch.getSecondaryDiagonal();

        return matchesWordOrReverseWord(primaryDiagonal, word) && matchesWordOrReverseWord(secondaryDiagonal, word);
    }

    private boolean matchesWordOrReverseWord(String actualWord, String expectedWord) {
        return actualWord.equals(expectedWord) || actualWord.contentEquals(new StringBuilder(expectedWord).reverse());
    }
}
