package leetcode;

/**
 * Created by Chethan on 9/22/16.
 */
public class DuplicateRemover {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int duplicateCount = 0;
        for (int i = 0, j = 1; j < nums.length; j++) {
            if (nums[j] == nums[i]) {
                duplicateCount++;
            } else {
                if (i + 1 < j) {
                    int temp = nums[i + 1];
                    nums[i + 1] = nums[j];
                    nums[j] = temp;
                }
                i++;
            }
        }
        return nums.length - duplicateCount;
    }
}
