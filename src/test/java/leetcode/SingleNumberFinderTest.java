package leetcode;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 9/27/16.
 */
public class SingleNumberFinderTest {

    @Test
    public void testSingleNumber() throws Exception {
        SingleNumberFinder singleNumberFinder = new SingleNumberFinder();
        assertThat(singleNumberFinder.singleNumber(new int[]{1, 2, 2, 1, 3})).isEqualTo(3);
        assertThat(singleNumberFinder.singleNumber(new int[]{1})).isEqualTo(1);
        assertThat(singleNumberFinder.singleNumber(new int[]{})).isEqualTo(0);
    }
}
