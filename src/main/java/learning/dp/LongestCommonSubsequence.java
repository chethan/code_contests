package learning.dp;

/**
 * Created by Chethan on 10/6/15.
 */
//http://www.geeksforgeeks.org/dynamic-programming-set-4-longest-common-subsequence/
//L{F[0..m-1],S[0..n-1]}={1+L{F[0..m-2],S[0..n-2] F[m-1]==S[n-1] | Max{L{F[0..m-2],S[0..n-1]},L{F[0..m-1],S[0..n-2]}}}
public class LongestCommonSubsequence {
    public int findLCS(String first, String second) {
        char[] fchars = first.toCharArray();
        char[] schars = second.toCharArray();
        int firstLength = first.length();
        int secondLength = second.length();

        int dp[][] = new int[firstLength][secondLength];
        dp[0][0] = fchars[0] == schars[0] ? 1 : 0;
        for (int i = 0; i < firstLength; i++) {
            for (int j = 0; j < secondLength; j++) {
                int fsPrevious = (i > 0 && j > 0) ? dp[i - 1][j - 1] : 0;
                int fPrevious = (i > 0) ? dp[i - 1][j] : 0;
                int sPrevious = (j > 0) ? dp[i][j - 1] : 0;
                if (fchars[i] == schars[j]) {
                    dp[i][j] = 1 + fsPrevious;
                } else {
                    dp[i][j] = Math.max(fPrevious, sPrevious);
                }
            }
        }
        return dp[firstLength - 1][secondLength - 1];
    }
}
