package leetcode;

/**
 * Created by Chethan on 10/14/15.
 */
//M[i][j]={M[i-1][j-1]+ M[i-1][j] if S[i]==T[J]  or M[i-1][j]}
//https://leetcode.com/problems/distinct-subsequences/
public class DistinctSubsequences {

    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                dp[i][j] = dp[i - 1][j];
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}


//abcd","dcba","lls","s","sssll"