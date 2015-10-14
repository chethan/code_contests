package leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 10/14/15.
 */
public class WordBreakTest {

    @Test
    public void testWordBreakOne() throws Exception {
        WordBreak wordBreak = new WordBreak();
        assertThat(wordBreak.wordBreakOne("leetcode",
                new HashSet<>(Arrays.asList("leetcod", "leet", "code")))).isTrue();
    }

    @Test
    public void testWordBreakTwo() throws Exception {
        WordBreak wordBreak = new WordBreak();
        assertThat(wordBreak.wordBreakTwo("catsanddog",
                new HashSet<>(Arrays.asList("cat", "cats", "and", "sand", "dog")))).
                containsExactly("cat sand dog", "cats and dog");

    }
}
