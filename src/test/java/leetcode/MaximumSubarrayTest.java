package leetcode;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 10/15/15.
 */
public class MaximumSubarrayTest {

    @Test
    public void testMaxSum() throws Exception {
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        assertThat(maximumSubarray.maxSum(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4})).isEqualTo(6);

    }


    @Test
    public void testMaxProduct() throws Exception {
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        assertThat(maximumSubarray.maxProduct(new int[]{2, -5, -2, -4, 3})).isEqualTo(24);

    }
}
