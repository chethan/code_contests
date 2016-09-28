package leetcode;

import java.util.Arrays;

/**
 * Created by Chethan on 9/27/16.
 */
public class MissingNumberFinder {

    public int missingNumber(int[] nums) {
        long sum = Arrays.stream(nums).mapToLong(i -> i).sum();
        return (int) ((nums.length * (nums.length + 1)) / 2 - sum);
    }
}
