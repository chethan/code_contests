package leetcode.dp;

//https://leetcode.com/problems/longest-increasing-subsequence/
public class LongestIncreasingSubsequence {

    //Let dp[i] be the longest path ending at ith element
    // dp[i] = Max(dp[j]) +1 for all j < i and nums[i] > nums[j]
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int maxLength = 0;
        for (int num : nums) {
            int index = binarySearch(dp, maxLength, num);
            if (index < 0) {
                index = -(index + 1);
            }
            dp[index] = num;
            if (index == maxLength) {
                maxLength++;
            }
        }
        return maxLength;

    }

    private int binarySearch(int[] a, int toIndex, int key) {
        int low = 0;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = a[mid];

            if (midVal < key) {
                low = mid + 1;
            } else if (midVal > key) {
                high = mid - 1;
            } else {
                return mid; // key found
            }
        }
        return -(low + 1);  // key not found.
    }
}
