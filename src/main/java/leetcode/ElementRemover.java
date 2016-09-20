package leetcode;

/**
 * Created by Chethan on 9/19/16.
 */
//https://leetcode.com/problems/remove-element/
public class ElementRemover {
    public int removeElement(int[] nums, int val) {
        int lastIndex = nums.length;
        if (lastIndex <= 0) return 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                do {
                    if (lastIndex <= i) return lastIndex;
                    lastIndex--;
                } while (nums[lastIndex] == val);
                nums[i] = nums[lastIndex];
                nums[lastIndex] = val;
            }
        }
        return lastIndex;
    }
}
