package learning.dp;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by Chethan on 9/15/15.
 */
//L[i]=max(L[j]+1) for all j<=i and a[i] > a[j]
public class LongestIncreasingSubSeq {

    public int findLongestIncreasing(List<Integer> numbers) {
        int[] lis = new int[numbers.size()];
        int[] dp = new int[numbers.size()];
        for (int i = 0; i < numbers.size(); i++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                if (numbers.get(j) < numbers.get(i) && lis[j] + 1 > lis[i]) {
                    lis[i] = lis[j] + 1;
                    dp[i] = j;
                }
            }
        }
        Integer integer = IntStream.range(0, lis.length)
                .boxed().max(Comparator.comparing(i -> lis[i])).get();
        printUsingDpTable(dp, integer, numbers);
        return lis[numbers.size()-1];
    }

    public int lisMemoization(List<Integer> numbers) {
        HashMap<Integer, Integer> memTable = new HashMap<>();
        lisMemoization(numbers, numbers.size(), memTable);
        return memTable.values().stream().max((o1, o2) -> o1 - o2).get();
    }

    // With memoization
    private int lisMemoization(List<Integer> numbers, int endingAt, HashMap<Integer, Integer> memTable) {
        if (memTable.containsKey(endingAt)) return memTable.get(endingAt);
        if (endingAt <= 1) {
            memTable.put(endingAt, 1);
            return 1;
        }
        int temp, maxEndingHere = 1;
        for (int i = 1; i < endingAt; i++) {
            temp = lisMemoization(numbers, i, memTable);
            if (numbers.get(i - 1) < numbers.get(endingAt - 1) && maxEndingHere < temp + 1) {
                maxEndingHere = temp + 1;
            }
        }
        memTable.put(endingAt, maxEndingHere);
        return maxEndingHere;
    }


    private void printUsingDpTable(int[] dp, int value, List<Integer> numbers) {
        if (value <= 0) return;
        printUsingDpTable(dp, dp[value], numbers);
        System.out.print(numbers.get(value) + " ");
    }
}
