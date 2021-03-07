package leetcode.array;

/**
 * Created by Chethan on 9/20/16.
 */
//https://leetcode.com/problems/rotate-array/
//https://leetcode.com/articles/rotate-array/
public class ArrayRotator {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0 || k % nums.length == 0) return;
        k = k % nums.length;
        int startPointer = nums.length - k;
        int[] tempNum = new int[nums.length];
        System.arraycopy(nums, 0, tempNum, 0, nums.length);
        for (int i = 0; i < nums.length ; i++) {
            if (startPointer == nums.length) {
                startPointer = 0;
            }
            nums[i] = tempNum[startPointer++];
        }
    }
}
