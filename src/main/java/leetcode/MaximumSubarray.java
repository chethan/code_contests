package leetcode;

/**
 * Created by Chethan on 10/15/15.
 */
//M[i]=max{M[i-1]+a[i],a[i]}
//https://leetcode.com/problems/maximum-subarray/
public class MaximumSubarray {
    public int maxSum(int[] nums) {
        int[] dp = new int[nums.length + 1];
        int max = Integer.MIN_VALUE;
        dp[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i - 1], nums[i - 1]);
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int maxLocal, minlocal, globalMax;
        maxLocal = minlocal = globalMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = maxLocal;
            maxLocal = Math.max(Math.max(nums[i] * maxLocal, nums[i]), nums[i] * minlocal);
            minlocal = Math.min(Math.min(nums[i] * temp, nums[i]), nums[i] * minlocal);
            globalMax=Math.max(globalMax,maxLocal);
        }
        return globalMax;
    }


}
