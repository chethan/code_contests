package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Chethan on 9/19/16.
 */
//https://leetcode.com/problems/majority-element/
//http://www.cs.utexas.edu/~moore/best-ideas/mjrty/index.html
public class MajorityElementFinder {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> countMap = Arrays.stream(nums).mapToObj(i -> i).
                collect(Collectors.groupingBy(i -> i, Collectors.summingInt(e -> 1)));
        return countMap.keySet().stream().sorted(Comparator.comparingInt(countMap::get).reversed()).findFirst().get();
    }
}
