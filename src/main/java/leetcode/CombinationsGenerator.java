package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chethan on 9/18/16.
 */
//https://leetcode.com/problems/combinations/
public class CombinationsGenerator {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (n <= 0 || n < k) return result;
        return combineRecur(n, k, 1);
    }

    private List<List<Integer>> combineRecur(int n, int k, int start) {
        if (k == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> finalCombinations = new ArrayList<>();
        for (int i = start; i <= n; i++) {
            if (k > 1) {
                List<List<Integer>> combinations = combineRecur(n, k - 1, i + 1);
                for (List<Integer> combination : combinations) {
                    ArrayList<Integer> list = new ArrayList<>();
                    finalCombinations.add(list);
                    list.add(i);
                    list.addAll(combination);
                }
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                finalCombinations.add(list);
                list.add(i);
            }
        }
        return finalCombinations;
    }


}
