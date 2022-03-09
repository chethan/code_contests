package leetcode.array;

public class MissingElement {

    //https://leetcode.com/problems/missing-element-in-sorted-array/
    //Time: O(LogN)
    //Space: O(1)
    public int missingElement(int[] nums, int k) {
        int lo = 0, hi = nums.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (missing(mid, nums) >= k) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return nums[lo - 1] + (k - missing(lo - 1, nums));
    }

    int missing(int index, int[] nums) {
        return nums[index] - (nums[0] + index);
    }
}
