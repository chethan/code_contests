package leetcode;

import java.util.Arrays;

/**
 * Created by Chethan on 9/20/15.
 */
public class MissingNumber {
    //https://leetcode.com/problems/missing-number/
    public int missingNumber(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int expectedSum = (nums.length * (nums.length + 1)) / 2;
        return expectedSum - sum;
    }

    //https://leetcode.com/problems/first-missing-positive/
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1) {
                if (nums[i] <= 0 || nums[i] >= nums.length || nums[nums[i] - 1] == nums[i]) break;
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}
