package leetcode.array;

//https://leetcode.com/problems/monotonic-array/
public class MonotonicArray {

    public boolean isMonotonic(int[] nums) {
        if (nums == null || nums.length < 2) {
            return true;
        }
        int state = 0;
        for (int i = 1; i < nums.length; i++) {
            int current = Integer.compare(nums[i], nums[i - 1]);
            if (current == 0) {
                continue;
            }
            if (state != 0 && state != current) {
                return false;
            }
            state = current;
        }
        return true;
    }

    public boolean isMonotonicSimple(int[] A) {
        boolean increasing = true;
        boolean decreasing = true;
        for (int i = 0; i < A.length - 1; ++i) {
            if (A[i] > A[i + 1]) {
                increasing = false;
            }
            if (A[i] < A[i + 1]) {
                decreasing = false;
            }
        }
        return increasing || decreasing;
    }
}
