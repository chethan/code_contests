package leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CombinationSum {

    //https://leetcode.com/problems/combination-sum/
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> combination = new LinkedList<>();
        backtrack(target, candidates, 0, result, combination);
        return result;
    }

    private void backtrack(int target, int[] candidates, int start, List<List<Integer>> result,
        LinkedList<Integer> combination) {
        if (target == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            combination.add(candidates[i]);
            backtrack(target - candidates[i], candidates, i, result, combination);
            combination.removeLast();
        }

    }

    //https://leetcode.com/problems/combination-sum-ii/
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> combination = new LinkedList<>();
        Map<Integer, Integer> counter = new HashMap<>();
        for (int candidate : candidates) {
            if (counter.containsKey(candidate)) {
                counter.put(candidate, counter.get(candidate) + 1);
            } else {
                counter.put(candidate, 1);
            }
        }
        // convert the counter table to a list of (num, count) tuples
        List<int[]> counterList = new ArrayList<>();
        counter.forEach((key, value) -> {
            counterList.add(new int[]{key, value});
        });
        backtrack2(target, 0, result, combination, counterList);
        return result;
    }

    private void backtrack2(int target, int start, List<List<Integer>> result,
        LinkedList<Integer> combination, List<int[]> counterList) {
        if (target == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = start; i < counterList.size(); i++) {
            int[] entry = counterList.get(i);
            int candidate = entry[0], freq = entry[1];
            if (freq <= 0) {
                continue;
            }
            combination.add(candidate);
            counterList.set(i, new int[]{candidate, freq - 1});
            backtrack2(target - candidate, i, result, combination, counterList);
            counterList.set(i, new int[]{candidate, freq});
            combination.removeLast();
        }
    }

    //https://leetcode.com/problems/combination-sum-iii/
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> combination = new LinkedList<>();
        backtrack3(n, k, 1, result, combination);
        return result;
    }

    private void backtrack3(int target, int k, int start, List<List<Integer>>
        result, LinkedList<Integer> combination) {
        if (target == 0 && k == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }
        if (target < 0 || k < 0) {
            return;
        }
        for (int i = start; i < 10; i++) {
            combination.add(i);
            backtrack3(target - i, k - 1, i + 1, result, combination);
            combination.removeLast();
        }

    }
}



