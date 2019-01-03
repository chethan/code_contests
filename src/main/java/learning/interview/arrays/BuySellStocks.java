package learning.interview.arrays;

/**
 * Created by Chethan on 10/16/15.
 */
public class BuySellStocks {
    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
    public int maxProfit(int[] prices) {
        int maxProfit = 0, minPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }

    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
    int maxProfit1(int[] prices) {
        int maxProfit = 0;
        if (prices.length == 1) {
            return prices[0];
        }
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            maxProfit += (diff > 0) ? diff : 0;
        }
        return maxProfit;
    }

    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
    public int maxProfit2(int[] prices) {
        int[] firstSellProfits = new int[prices.length];
        int minPrice = Integer.MAX_VALUE , maxProfit =0;
        
        for(int i=0;i<prices.length;i++){
            int price=prices[i];
            maxProfit=Math.max(maxProfit,price - minPrice);
            minPrice = Math.min(minPrice,price);
            firstSellProfits[i]=maxProfit;
        }

        int maxSellPrice = 0, maxProfitSoFar = 0;

        for(int i=prices.length-1;i>0;i--){
            maxSellPrice = Math.max(maxSellPrice,prices[i]);    
            maxProfitSoFar = Math.max(maxProfitSoFar,maxSellPrice - prices[i] + firstSellProfits[i-1]); 
        }
        return maxProfitSoFar;

    }

    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
    public int maxProfit2Faster(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int profit1 = 0, profit2 = 0;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MIN_VALUE;
        for (int price : prices) {

            profit1 = Math.max(profit1, price - min1);
            min1 = Math.min(min1, price);

            profit2 = Math.max(profit2, price + min2);
            min2 = Math.max(min2, profit1 - price);
        }

        return profit2;
    }


    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
    //TODO: need to understand it better
    public int maxProfit3(int k, int[] prices) {
        int len = prices.length;
        if (len < 2 || k <= 0)
            return 0;
        int[][] local = new int[len][k + 1];
        int[][] global = new int[len][k + 1];

        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            for (int j = 1; j <= k; j++) {
                local[i][j] = Math.max(global[i - 1][j - 1] + Math.max(diff, 0), local[i - 1][j] + diff);
                global[i][j] = Math.max(local[i][j], global[i - 1][j]);
            }
        }
        return global[prices.length - 1][k];

    }


}
