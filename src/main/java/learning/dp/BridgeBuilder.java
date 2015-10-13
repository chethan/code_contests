package learning.dp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

/**
 * Created by Chethan on 10/7/15.
 */
//http://www.geeksforgeeks.org/dynamic-programming-set-14-variations-of-lis/
//http://people.cs.clemson.edu/~bcdean/dp_practice/dp_6.swf
public class BridgeBuilder {
    public int findMaxBridges(Tuple<Integer>[] tuples) {
        Arrays.sort(tuples, (o1, o2) -> o1.left - o2.left);
        int n = tuples.length;
        int[] indexes = new int[n];
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            indexes[i] = findBasedOnRightValue(tuples, tuples[i].left);
        }
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (indexes[i] > indexes[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        Integer integer = IntStream.range(0, dp.length)
                .boxed().max(Comparator.comparing(i -> dp[i])).get();

        return dp[integer];
    }

    private int findBasedOnRightValue(Tuple<Integer>[] tuples, int value) {
        for (int i = 0; i < tuples.length; i++) {
            Tuple<Integer> tuple = tuples[i];
            if (tuple.right == value) return i;
        }
        return -1;
    }
}
