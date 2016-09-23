package leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 9/21/16.
 */
public class ThreeSumTest {

    @Test
    public void testThreeSum() throws Exception {
        ThreeSum threeSum = new ThreeSum();
        assertThat(threeSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4})).hasSize(2).contains(
                Arrays.asList(-1, 0, 1), Arrays.asList(-1, -1, 2));
        assertThat(threeSum.threeSum(new int[]{})).isEmpty();
        assertThat(threeSum.threeSum(new int[]{0,0,0})).hasSize(1);
    }

}
