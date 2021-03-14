package leetcode.backtracking;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

public class WordSearchTest {

    @Test
    public void testWordSearchInGrid() {
        WordSearch wordSearch = new WordSearch();
        assertThat(wordSearch
            .exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}},
                "ABCCED")).isTrue();
        assertThat(wordSearch
            .exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}},
                "SEE")).isTrue();
        assertThat(wordSearch.exist(new char[][]{}, "SEE")).isFalse();
    }

    @Test
    public void testDictionaryWordSearchInGrid() {
        WordSearch wordSearch = new WordSearch();
        assertThat(wordSearch.findWords(
            new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}},
            new String[]{"ABCCED", "SEE","ZOO"})).containsExactly("ABCCED", "SEE");
    }

}