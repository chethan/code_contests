package learning.tech.interview.meetup;

import java.util.Arrays;

/**
 * Created by Chethan on 3/19/16.
 */
public class MaximumSumPathInPyramid {
    public int findMaximumSum(int[][] pyramid) {
        int heightOfPyramid = pyramid.length;
        if (heightOfPyramid == 0) return 0;
        int[][] dp = new int[heightOfPyramid][heightOfPyramid];
        dp[0][0] = pyramid[0][0];

        for (int i = 1; i < heightOfPyramid; i++) {
            for (int j = 0; j < pyramid[i].length; j++) {
                int s1 = 0, s2 = 0;
                if (j - 1 >= 0) s1 = dp[i - 1][j - 1];
                if (j < heightOfPyramid) s2 = dp[i - 1][j];
                dp[i][j] = Math.max(s1 + pyramid[i][j], s2 + pyramid[i][j]);
            }
        }
        return Arrays.stream(dp[heightOfPyramid - 1]).max().getAsInt();
    }

}
