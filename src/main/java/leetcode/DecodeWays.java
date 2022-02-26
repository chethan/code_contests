package leetcode;

/**
 * Created by Chethan on 10/15/15.
 */
//https://leetcode.com/problems/decode-ways/
public class DecodeWays {
    public int numDecodings(String s) {
        //dp[i] indicates number of ways you can decode string of length 0 to i-1
        if (s.length() == 0) return 0;
        int[] dp = new int[s.length() + 1];
        dp[0] = dp[1] = Character.getNumericValue(s.charAt(0)) > 0 ? 1 : 0;
        for (int i = 2; i <= s.length(); i++) {
            int n1 = Character.getNumericValue(s.charAt(i - 1));
            if (n1 > 0) {
                dp[i] = dp[i - 1];
            }
            int n2 = Character.getNumericValue(s.charAt(i - 2));
            if (n2 > 0 && (n2 * 10 + n1) < 27) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }
}
