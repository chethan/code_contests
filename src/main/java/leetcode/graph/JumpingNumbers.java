package leetcode.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JumpingNumbers {

    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> result = new ArrayList<>();
        if (n == 1) {
            result.add(0);
        }
        for (int i = 1; i < 10; i++) {
            dfs(i, 1, n, k, result);
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    void dfs(int current, int digits, int n, int k, List<Integer> result) {

        if (digits == n) {
            result.add(current);
            return;
        }
        int lastDigit = current % 10;
        Set<Integer> nextDigits = new HashSet<>();
        nextDigits.add(lastDigit + k);
        nextDigits.add(lastDigit - k);
        for (int nextDigit : nextDigits) {
            if (nextDigit >= 0 && nextDigit < 10) {
                dfs(current * 10 + nextDigit, digits + 1, n, k, result);
            }
        }
    }
}
