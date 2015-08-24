package learning.recursion.backtracking;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 8/23/15.
 */
public class SubsetTest {

    @Test
    public void testGenerateSubsets() throws Exception {
        assertThat(new Subset().generateSubsets("abc")).containsExactly("", "ab", "a", "bc", "ac", "b", "abc", "c");
        assertThat(new Subset().generateSubsets("a")).containsExactly("","a");
    }
}