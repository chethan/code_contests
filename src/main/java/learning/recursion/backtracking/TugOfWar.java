package learning.recursion.backtracking;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Chethan on 9/19/15.
 */
public class TugOfWar {
    public Map.Entry<List<Integer>, List<Integer>> bestSplit(List<Integer> values) {
        return bestSplit(new ArrayList<>(), new ArrayList<>(values), new HashMap<>());
    }

    //Dumb brute force with memoization
    private Map.Entry<List<Integer>, List<Integer>> bestSplit(List<Integer> left, List<Integer> right, Map<String, Map.Entry<List<Integer>, List<Integer>>> mem) {
        if (mem.containsKey(getKey(left, right))) {
            return mem.get(getKey(left, right));

        }
        if (Math.abs(left.size() - right.size()) <= 1) {
            AbstractMap.SimpleEntry<List<Integer>, List<Integer>> entry = new AbstractMap.SimpleEntry<>(left, right);
            mem.put(getKey(left, right), entry);
            return entry;
        }
        int minDifference = Integer.MAX_VALUE;
        Map.Entry<List<Integer>, List<Integer>> minEntry = null;
        for (int i = 0; i < right.size(); i++) {
            ArrayList<Integer> newLeft = new ArrayList<>(left);
            newLeft.add(right.get(i));
            ArrayList<Integer> newRight = new ArrayList<>(right);
            newRight.remove(i);
            Map.Entry<List<Integer>, List<Integer>> entry = bestSplit(newLeft, newRight, mem);
            int difference = getDifference(entry);
            if (difference < minDifference) {
                minDifference = difference;
                minEntry = entry;
            }
        }
        return minEntry;
    }

    private String getKey(List<Integer> left, List<Integer> right) {
        return left.stream().sorted().collect(Collectors.toList()) + "_" + right.stream().sorted().collect(Collectors.toList());
    }

    private int getDifference(Map.Entry<List<Integer>, List<Integer>> entry) {
        Integer leftSum = entry.getKey().stream().collect(Collectors.summingInt(value -> value));
        Integer rightSum = entry.getValue().stream().collect(Collectors.summingInt(value -> value));
        return Math.abs(leftSum - rightSum);
    }


}
