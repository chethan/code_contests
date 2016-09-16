package leetcode;

import org.testng.annotations.Test;

import static org.assertj.core.api.StrictAssertions.assertThat;

/**
 * Created by Chethan on 9/16/16.
 */
public class WiggleSubsequenceTest {

    @Test
    public void testWiggleMaxLength() throws Exception {
        WiggleSubsequence wiggleSubsequence = new WiggleSubsequence();
        assertThat(wiggleSubsequence.
                wiggleMaxLength(new int[]{})).isEqualTo(0);
        assertThat(wiggleSubsequence.
                wiggleMaxLength(new int[]{1, 7, 5, 10, 13, 12})).isEqualTo(5);
        assertThat(wiggleSubsequence.
                wiggleMaxLength(new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8})).isEqualTo(7);
        assertThat(wiggleSubsequence.
                wiggleMaxLength(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9})).isEqualTo(2);
    }
}
