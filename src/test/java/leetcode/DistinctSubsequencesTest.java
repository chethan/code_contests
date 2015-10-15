package leetcode;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 10/14/15.
 */
public class DistinctSubsequencesTest {

    @Test
    public void testGenerateSubsets() throws Exception {
        DistinctSubsequences distinctSubsequences = new DistinctSubsequences();
        assertThat(distinctSubsequences.numDistinct("rabbbit", "rabbit")).isEqualTo(3);
    }
}
