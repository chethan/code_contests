package learning.dp;

import java.util.HashMap;

/**
 * Created by Chethan on 3/12/16.
 */
//F[n]=F[n-1]+F[n-1]
public class FibonacciSeries {
    HashMap<Integer, Integer> fibMap = new HashMap<>();

    //Top down (memoization)
    public int getFib(int n) {
        if (fibMap.containsKey(n)) return fibMap.get(n);
        System.out.println("Calling fib for " + n);
        if (n < 0) return -1;
        if (n == 0 || n == 1) return 1;
        int fibn = getFib(n - 1) + getFib(n - 2);
        fibMap.put(n, fibn);
        return fibn;
    }

    //Bottom up
    public int getFibDP(int n) {
        int[] fib = new int[n + 1];
        fib[0] = 1;
        fib[1] = 1;
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n];
    }
}
