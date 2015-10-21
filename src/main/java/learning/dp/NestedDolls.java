package learning.dp;

import ds.Tuple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Chethan on 10/4/15.
 */
//http://www.spoj.com/problems/MDOLLS/en/
//http://www.spoj.com/problems/MSTICK/en/
public class NestedDolls {
    public int minimumDolls(Tuple<Integer>[] dimensions) {
        int minimumDolls = dimensions.length;
        boolean hasChanged = true;

        //Repeatedly call LIS
        while (hasChanged && dimensions.length>0) {
            int n = dimensions.length;
            hasChanged = false;
            int[] dp = new int[n];
            int[] table = new int[n];
            Arrays.sort(dimensions, this::compareTuple);
            dp[0] = 1;
            for (int i = 1; i < dp.length; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (dimensions[i].left>dimensions[j].left &&
                            dimensions[i].right>dimensions[j].right) {
                        int value = dp[j] + 1;
                        if (value > dp[i]) {
                            dp[i] = value;
                            table[i] = j;
                            hasChanged = true;
                        }
                    }
                }
            }
            minimumDolls = minimumDolls - (dp[n - 1] - 1);
            dimensions = updateDimensions(dimensions, hasChanged, n, table);
        }
        return minimumDolls;
    }

    private Tuple<Integer>[] updateDimensions(Tuple<Integer>[] dimensions, boolean hasChanged, int n, int[] table) {
        List<Tuple<Integer>> tuples = new ArrayList<>();
        if (hasChanged) {
            tuples.addAll(Arrays.asList(dimensions).subList(0, n));
            tuples.remove(dimensions[n - 1]);
            for (int aTable : table) {
                tuples.remove(dimensions[aTable]);
            }
            dimensions = tuples.toArray(new Tuple[tuples.size()]);
        }
        return dimensions;
    }

    private int compareTuple(Tuple<Integer> o1, Tuple<Integer> o2) {
        return (o1.left > o2.left) || (o1.right > o2.right) ? 1 : -1;
    }

}
