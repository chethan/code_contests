package leetcode;

/**
 * Created by Chethan on 10/15/15.
 */
//M[i][j] = {M[i-1][j] if s1[i]==s3[i+j+1] or M[i][j-1] if s2[j]==s3[i+j+1]}
//https://leetcode.com/problems/interleaving-string/
public class InterleavingString {
    public boolean isInterleaveRecursive(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null) return true;
        if (s1.isEmpty() && s2.isEmpty() && s3.isEmpty()) return true;
        if (s1.length() + s2.length() != s3.length()) return false;
        return (!s1.isEmpty() && s1.charAt(0) == s3.charAt(0) &&
                isInterleaveRecursive(s1.substring(1), s2, s3.substring(1))) || (
                !s2.isEmpty() && s2.charAt(0) == s3.charAt(0) &&
                        isInterleaveRecursive(s1, s2.substring(1), s3.substring(1)));
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null) return true;
        if (s1.isEmpty() && s2.isEmpty() && s3.isEmpty()) return true;
        if (s1.length() + s2.length() != s3.length()) return false;
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;

        for (int i = 1; i <= s1.length(); i++) {
            dp[i][0] = s3.charAt(i - 1) == s1.charAt(i - 1) && dp[i - 1][0];
        }

        for (int i = 1; i <= s2.length(); i++) {
            dp[0][i] = s3.charAt(i - 1) == s2.charAt(i - 1) && dp[0][i - 1];
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) ||
                        (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
