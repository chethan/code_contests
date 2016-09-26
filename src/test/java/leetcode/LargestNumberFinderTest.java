package leetcode;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 9/26/16.
 */
public class LargestNumberFinderTest {

    @Test
    public void testLargestNumber() throws Exception {
        LargestNumberFinder largestNumberFinder = new LargestNumberFinder();
        assertThat(largestNumberFinder.largestNumber(new int[]{3, 30, 34, 5, 9})).isEqualTo("9534330");
        assertThat(largestNumberFinder.largestNumber(new int[]{999999998,999999997,999999999})).isEqualTo("999999999999999998999999997");
        assertThat(largestNumberFinder.largestNumber(new int[]{0,0})).isEqualTo("0");

    }
}
