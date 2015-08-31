package learning.recursion.backtracking;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 8/23/15.
 */
public class AnagramsTest {

    @Test
    public void testFirstAnagram() throws Exception {
        Anagrams anagrams = new Anagrams();
        assertThat(anagrams.firstAnagram("oabt")).isEqualTo("boat");
        assertThat(anagrams.firstAnagram("qryeu")).isEqualTo("query");
    }
}