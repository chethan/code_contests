package learning.dp;

/**
 * Created by Chethan on 9/16/15.
 */
// M[i,j] = Min{M[i,k]+M[k,j]}+(j-i) for all k cuts within i and j
//https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=944
public class CuttingSticks {

    public int minimumCost(int length, int[] cuts) {
        int[] tempCuts = new int[cuts.length + 2];
        int[][] costs = new int[tempCuts.length][tempCuts.length];
        tempCuts[0] = 0;
        System.arraycopy(cuts, 0, tempCuts, 1, cuts.length);
        tempCuts[tempCuts.length - 1] = length;
        return minimumCost(tempCuts, costs, 0, tempCuts.length - 1);
    }

    //Memoization
    private int minimumCost(int[] cuts, int[][] costs, int start, int end) {
        if (end - start == 1) return 0;
        if (costs[start][end] != 0) return costs[start][end];
        int minimumCost = Integer.MAX_VALUE;
        for (int k = start + 1; k < end; k++) {
            int first = minimumCost(cuts, costs, start, k);
            int second = minimumCost(cuts, costs, k, end);
            minimumCost = Math.min(first + second, minimumCost);
        }
        minimumCost = cuts[end] - cuts[start] + minimumCost;
        costs[start][end] = minimumCost;
        return minimumCost;
    }

}
