package learning.dp;

/**
 * Created by Chethan on 10/12/15.
 */
//M[i][j]= M[i][j-1] || M[i-V[j]][j-1]
public class SubsetSum {
    public boolean isPresent(int[] values,int sum){
        int length = values.length;
        boolean[][] dp = new boolean[sum+1][length +1];
        for(int i=0;i< length;i++){
            dp[0][i]=true;
        }

        for(int i=1;i<=sum;i++){
            for(int j=1;j<=length;j++){
                dp[i][j]=dp[i][j-1];
                if(i>=values[j-1]){
                    dp[i][j] = dp[i][j] || dp[i-values[j-1]][j-1];
                }
            }
        }

        return dp[sum][length];

    }
}
