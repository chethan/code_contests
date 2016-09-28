package leetcode;

import java.util.Arrays;

/**
 * Created by Chethan on 9/27/16.
 */
public class SingleNumberFinder {
    public int singleNumber(int[] nums) {
        return Arrays.stream(nums).reduce(0,(left, right) -> left^right);
    }

}
