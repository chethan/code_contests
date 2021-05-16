package leetcode.dp;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

public class LongestIncreasingSubsequenceTest {

    @Test
    public void testLongestIncreasingSubsequence() {
        LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();
        assertThat(longestIncreasingSubsequence.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18})).isEqualTo(4);
    }
}