package learning.dp;

/**
 * Created by Chethan on 10/3/15.
 */
//http://www.spoj.com/problems/ACODE/
//M[i]={M[i-2]+M[i-1]}+2
public class Alphacode {

    public long totalDecodings(int[] code) {
        int[] dp = new int[code.length];
        dp[0] = 1;
        for (int i = 1; i < code.length; i++) {
            if (code[i] > 0) {
                dp[i] = dp[i - 1];
            }
            if (code[i-1]>0 && (code[i - 1] * 10 + code[i]) <= 26) {
                dp[i] += ((i > 1) ? dp[i - 2] : 1);
            }
        }
        return dp[code.length - 1];
    }

}
