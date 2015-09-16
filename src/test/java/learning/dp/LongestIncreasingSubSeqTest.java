package learning.dp;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.assertj.core.api.StrictAssertions.assertThat;

/**
 * Created by Chethan on 9/15/15.
 */
public class LongestIncreasingSubSeqTest {

    @Test
    public void testFindLongestIncreasing() throws Exception {
        LongestIncreasingSubSeq lis = new LongestIncreasingSubSeq();
        assertThat(lis.findLongestIncreasing(Arrays.asList
                (10, 22, 9, 33, 21, 50, 41, 60, 80))).isEqualTo(6);
        assertThat(lis.lisMemoization(Arrays.asList
                (10, 22, 9, 33, 21, 50, 41, 60, 80))).isEqualTo(6);
    }
}