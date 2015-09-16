package learning.dp;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Chethan on 9/15/15.
 */
//M[i]=min{M[i-j]}+1 for all denominations j
public class CoinChange {

    //Tabular
    public int minCoins(List<Integer> denominations, int value) {
        int[] minCoins = new int[value + 1];
        int[] dp = new int[value + 1];
        for (int i = 0; i <= value; i++) {
            minCoins[i] = 0;
            for (Integer denomination : denominations) {
                if (i >= denomination) {
                    int i1 = minCoins[i - denomination] + 1;
                    if (minCoins[i] == 0 || i1 < minCoins[i]) {
                        minCoins[i] = i1;
                        dp[i] = i - denomination;
                    }
                }
            }
        }
        printUsingDpTable(dp, value);
        return minCoins[value];
    }

    public int minCoinsMemoization(List<Integer> denominations, int value){
        return minCoinsMemoization(denominations,value,new HashMap<>());
    }


    private int minCoinsMemoization(List<Integer> denominations, int value, HashMap<Integer, Integer> memTable) {
        if (memTable.containsKey(value)) return memTable.get(value);
        int minValue=0;
        for (Integer denomination : denominations) {
            if(value>=denomination){
                int i = minCoinsMemoization(denominations, value - denomination, memTable)+1;
                if(minValue==0 || i<minValue) minValue = i;
            }
        }
        memTable.put(value,minValue);
        return minValue;

    }

    private void printUsingDpTable(int[] dp, int value) {
        if (value <= 0) return;
        System.out.print(value - dp[value] + " ");
        printUsingDpTable(dp, dp[value]);
    }

}
