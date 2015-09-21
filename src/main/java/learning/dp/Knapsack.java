package learning.dp;

/**
 * Created by Chethan on 9/20/15.
 */
//M[i]=max{M[i-1],max{M[i-Wj]+Vj} for all i <j}
public class Knapsack {
    //Duplicate items permitted
    public int maxInKnapsack(int capacity, int[] weight, int[] value) {
        int[] maxInKnapsack = new int[capacity + 1];
        if (capacity == 0 || weight.length == 0 || value.length == 0) return 0;
        maxInKnapsack[0] = 0;
        for (int i = 1; i <= capacity; i++) {
            int maxValue = 0;
            for (int j = 0; j < weight.length; j++) {
                if (i - weight[j] < 0) continue;
                if (maxValue < maxInKnapsack[i - weight[j]] + value[j]) {
                    maxValue = maxInKnapsack[i - weight[j]] + value[j];
                }
            }
            maxInKnapsack[i] = Math.max(maxInKnapsack[i - 1], maxValue);
        }
        return maxInKnapsack[capacity];
    }
}
