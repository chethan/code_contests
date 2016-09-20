package leetcode;

/**
 * Created by Chethan on 9/19/16.
 */
//https://leetcode.com/problems/move-zeroes/
public class ZeroMover {
    public void moveZeroes(int[] nums) {
        int firstZeroPointer = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 && firstZeroPointer == -1) {
                firstZeroPointer = i;
            }

            if (nums[i] != 0 && firstZeroPointer != -1) {
                nums[firstZeroPointer] = nums[i];
                nums[i] = 0;
                firstZeroPointer++;
            }
        }
    }
}
