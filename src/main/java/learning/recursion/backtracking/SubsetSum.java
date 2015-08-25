package learning.recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chethan on 8/24/15.
 */
public class SubsetSum {
    public List<Integer> findSubset(List<Integer> number,Integer sum){
        return findSubset(new ArrayList<>(),number,sum);
    }

    private List<Integer> findSubset(ArrayList<Integer> soFar, List<Integer> numbers, Integer sum) {
        if (numbers.isEmpty()) {
            return soFar.stream().mapToInt(value -> value).sum() == sum ? soFar : new ArrayList<>();
        }
        for (int i = 0; i < numbers.size(); i++) {
            ArrayList<Integer> newSoFar = new ArrayList<>(soFar);
                newSoFar.add(numbers.get(i));
            List<Integer> subset = findSubset(newSoFar, numbers.subList(i + 1, numbers.size()), sum);
            if (!subset.isEmpty()) return subset;
            subset=findSubset(new ArrayList<>(soFar), numbers.subList(i + 1, numbers.size()), sum);
            if (!subset.isEmpty()) return subset;
        }
        return new ArrayList<>();
    }
}
