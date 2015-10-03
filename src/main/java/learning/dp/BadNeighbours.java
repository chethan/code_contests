package learning.dp;

import java.util.Arrays;

/**
 * Created by Chethan on 9/15/15.
 */
//D[i]=max{D[i-2]+a[i],D[i-3]+a[i-1]}
//http://community.topcoder.com/stat?c=problem_statement&pm=2402&rd=5009
//http://www.spoj.com/problems/FARIDA/
public class BadNeighbours {

    public int maxDonationCircular(int[] donations) {
        return Math.max(maxDonations(Arrays.copyOfRange(donations, 0, donations.length - 1)),
                maxDonations(Arrays.copyOfRange(donations, 1, donations.length)));
    }

    public int maxDonations(int[] donations) {
        int[] maxDonations = new int[donations.length];
        int[] dp = new int[donations.length];
        for (int i = 0; i < donations.length; i++) {
            int current = safeGet(donations, i) + safeGet(maxDonations, i - 2);
            int previous = safeGet(donations, i - 1) + safeGet(maxDonations, i - 3);
            if (current > previous) {
                maxDonations[i] = current;
                dp[i] = i - 2;
            } else {
                maxDonations[i] = previous;
                dp[i] = i - 1;
            }
        }
        printUsingDpTable(dp, donations.length - 1, donations);
        return maxDonations[donations.length - 1];
    }

    private void printUsingDpTable(int[] dp, int value, int[] donations) {
        if (value < 0) {
            System.out.println();
            return;
        }
        printUsingDpTable(dp, dp[value], donations);
        if (value - dp[value] != 1) {
            System.out.print(donations[value] + " ");
        }
    }


    private int safeGet(int[] array, int index) {
        return index >= 0 && index < array.length ? array[index] : 0;
    }
}
