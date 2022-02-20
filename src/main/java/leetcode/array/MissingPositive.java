package leetcode.array;

//https://leetcode.com/problems/first-missing-positive/
public class MissingPositive {

    int firstMissingPositive(int[] nums) {
        //Missing positive number can be at most of value (N+1), where n is the size of the array
        boolean containsOne = false;
        for (int num : nums) {
            if (num == 1) {
                containsOne = true;
                break;
            }
        }
        if (!containsOne) {
            return 1;
        }
        //Marking All negative numbers and numbers greater than n as 1(to ignore them)
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 || nums[i] > nums.length) {
                nums[i] = 1;
            }
        }
        //Using the index to mark which numbers are present by marking them as negative
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            if (num == nums.length) {
                nums[0] = -Math.abs(nums[0]);
            } else {
                nums[num] = -Math.abs(nums[num]);
            }
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i;
            }
        }
        return nums[0] > 0 ? nums.length : nums.length + 1;

    }
}
