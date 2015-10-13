package learning.recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chethan on 8/24/15.
 * http://www.geeksforgeeks.org/backttracking-set-4-subset-sum/
 */
public class Subsets {

    //P(abcd) = P(bcd) + a.P(bcd)
    public List<List<Integer>> generateSubsets(List<Integer> rest) {
        List<List<Integer>> lists = new ArrayList<>();
        if (rest.isEmpty()) {
            lists.add(new ArrayList<>());
            return lists;
        }
        List<List<Integer>> subsets = generateSubsets(rest.subList(1, rest.size()));
        lists.addAll(subsets);
        for (List<Integer> subset : subsets) {
            ArrayList<Integer> e = new ArrayList<>();
            e.add(rest.get(0));
            e.addAll(subset);
            lists.add(e);
        }
        return lists;
    }


    public List<Integer> findSubsetMatchingSum(List<Integer> number, Integer sum) {
        return findSubsetMatchingSum(new ArrayList<>(), number, sum);
    }

    private List<Integer> findSubsetMatchingSum(ArrayList<Integer> soFar, List<Integer> numbers, Integer sum) {
        if (numbers.isEmpty()) {
            return soFar.stream().mapToInt(value -> value).sum() == sum ? soFar : new ArrayList<>();
        }
        for (int i = 0; i < numbers.size(); i++) {
            ArrayList<Integer> newSoFar = new ArrayList<>(soFar);
            newSoFar.add(numbers.get(i));
            List<Integer> subset = findSubsetMatchingSum(newSoFar, numbers.subList(i + 1, numbers.size()), sum);
            if (!subset.isEmpty()) return subset;
            subset = findSubsetMatchingSum(new ArrayList<>(soFar), numbers.subList(i + 1, numbers.size()), sum);
            if (!subset.isEmpty()) return subset;
        }
        return new ArrayList<>();
    }
}
