package leetcode.dp;

import java.util.Arrays;

public class RussianDoll {

    //https://leetcode.com/problems/russian-doll-envelopes/
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (arr1, arr2) -> {
            if (arr1[0] == arr2[0]) {
                return Integer.compare(arr2[1], arr1[1]);
            }
            return Integer.compare(arr1[0], arr2[0]);
        });
        return lengthOfLIS(envelopes);
    }

    private int lengthOfLIS(int[][] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int[] num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num[1]);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num[1];
            if (i == len) {
                len++;
            }
        }
        return len;
    }
}
