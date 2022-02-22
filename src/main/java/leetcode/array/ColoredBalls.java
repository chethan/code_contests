package leetcode.array;

import java.util.Arrays;

public class ColoredBalls {

    public int maxProfit(int[] inventory, int orders) {
        final int mod = 1_00_00_00_00_7;
        Arrays.sort(inventory);
        long res = 0;
        for (int i = inventory.length - 1; i >= 0; i--) {
            int currentValue = inventory[i];
            int diff = currentValue - (i > 0 ? inventory[i - 1] : 0);
            long width = inventory.length - i;
            long currentOrders = Math.min(diff * width, orders);
            long a = inventory[i];
            long b = inventory[i] - (currentOrders / width);
            long totalValueBetweenAandB =
                (((a * (a + 1) / 2) - (b * (b + 1) / 2)) % mod * width) % mod;
            long valueOfRemainingOrders = ((currentOrders % width) * b) % mod;
            res = (res + totalValueBetweenAandB + valueOfRemainingOrders) % mod;
            orders -= currentOrders;
            if (orders == 0) {
                break;
            }


        }
        return (int) res;
    }

}
