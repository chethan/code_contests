package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Chethan on 9/19/16.
 */
//https://leetcode.com/problems/subsets/
public class SubsetGenerator {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0) {
            return Arrays.asList(new ArrayList<>());
        }

        int subArray[] = new int[nums.length - 1];
        System.arraycopy(nums, 1, subArray, 0, subArray.length);
        List<List<Integer>> finalSubSets = new ArrayList<>();
        List<List<Integer>> subsets = subsets(subArray);
        finalSubSets.addAll(subsets);
        for (List<Integer> subset : subsets) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(nums[0]);
            list.addAll(subset);
            finalSubSets.add(list);
        }

        return finalSubSets.stream().sorted((o1, o2) -> o1.size() - o2.size()).collect(Collectors.toList());
    }
}
