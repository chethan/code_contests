package leetcode;

/**
 * Created by Chethan on 10/16/15.
 */
public class BuySellStocks {
    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
    public int maxProfit(int[] prices) {
        int minElement = Integer.MAX_VALUE, profit = 0;
        for (int price : prices) {
            profit = Math.max(profit, price - minElement);
            minElement = Math.min(price, minElement);
        }
        return profit;
    }

    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
    public int maxProfit1(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int difference = prices[i] - prices[i - 1];
            if (difference > 0) profit += difference;
        }
        return profit;
    }

    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int[] left = new int[prices.length], right = new int[prices.length];
        left[0] = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            left[i] = Math.max(left[i - 1], prices[i] - min);
            min = Math.min(min, prices[i]);
        }

        right[prices.length - 1] = 0;
        int max = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], max - prices[i]);
            max = Math.max(max, prices[i]);
        }
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            profit = Math.max(right[i] + left[i], profit);
        }
        return profit;
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


}
