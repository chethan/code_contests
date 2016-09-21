package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

/**
 * Created by Chethan on 9/20/16.
 */
//https://leetcode.com/problems/subsets-ii/
public class SubsetGenerator2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums.length == 0) {
            return Arrays.asList(new ArrayList<>());
        }
        Arrays.sort(nums);
        int subArray[] = new int[nums.length - 1];
        System.arraycopy(nums, 1, subArray, 0, subArray.length);
        List<List<Integer>> finalSubSets = new ArrayList<>();
        List<List<Integer>> subsets = subsetsWithDup(subArray);
        finalSubSets.addAll(subsets);
        for (List<Integer> subset : subsets) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(nums[0]);
            list.addAll(subset);
            finalSubSets.add(list);
        }

        return finalSubSets.stream().collect(toMap(integers -> Arrays.toString(integers.toArray()),
                Function.<List<Integer>>identity(), (t1, t2) -> t2)).values().stream().collect(Collectors.toList());
    }
}
