package leetcode.trie;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.testng.annotations.Test;

public class ReplaceWordsTest {

    @Test
    public void testReplaceWordsWithRoot() {
        ReplaceWords replaceWords = new ReplaceWords();
        assertThat(replaceWords.replaceWords(List.of("cat", "bat", "rat"),
            "the cattle was rattled by the battery")).isEqualTo("the cat was rat by the bat");
        assertThat(replaceWords.replaceWords(List.of("a", "aa", "aaa", "aaaa"),
            "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa"))
            .isEqualTo("a a a a a a a a bbb baba a");
    }
}