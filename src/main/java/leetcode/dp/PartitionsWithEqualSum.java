package leetcode.dp;

import java.util.Arrays;

//https://leetcode.com/problems/partition-equal-subset-sum/
public class PartitionsWithEqualSum {

    public boolean canPartition(int[] nums) {
        int total = Arrays.stream(nums).sum();
        if (total % 2 == 1) {
            return false;
        }
        int subsetSum = total / 2;
        //dp[i][j] -> indicates sum of j is possible from the subset of nums from o to i
        boolean[][] dp = new boolean[nums.length + 1][subsetSum + 1];
        dp[0][0] = true;
        for (int i = 1; i <= nums.length; i++) {
            int curr = nums[i - 1];
            for (int j = 0; j <= subsetSum; j++) {
                if (j < curr) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - curr];
                }
            }
        }
        return dp[nums.length][subsetSum];
    }

    public boolean canPartitionWithMemoization(int[] nums) {
        int total = Arrays.stream(nums).sum();
        if (total % 2 == 1) {
            return false;
        }
        int subSetSum = total / 2;
        int n = nums.length;
        Boolean[][] memo = new Boolean[n + 1][subSetSum + 1];
        return dfs(nums, n - 1, subSetSum, memo);
    }

    public boolean dfs(int[] nums, int n, int subSetSum, Boolean[][] memo) {
        // Base Cases
        if (subSetSum == 0) {
            return true;
        }
        if (n == 0 || subSetSum < 0) {
            return false;
        }
        // check if subSetSum for given n is already computed and stored in memo
        if (memo[n][subSetSum] != null) {
            return memo[n][subSetSum];
        }
        //dfs with nth num included or dfs without including nth number
        boolean result = dfs(nums, n - 1, subSetSum - nums[n - 1], memo) ||
            dfs(nums, n - 1, subSetSum, memo);
        // store the result in memo
        memo[n][subSetSum] = result;
        return result;
    }
}
