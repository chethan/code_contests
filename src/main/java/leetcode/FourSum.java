package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Chethan on 9/19/15.
 */
//https://leetcode.com/problems/4sum/
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return anySum(Arrays.stream(nums).boxed().collect(Collectors.toList()), 4, target, new HashMap<>());
    }

    private List<List<Integer>> anySum(List<Integer> nums, int length, int target, HashMap<String, List<List<Integer>>> mem) {
        if (length == 0 || nums.size() < length) return new ArrayList<>();
        if (mem.containsKey(getKey(nums, length, target))) return mem.get(getKey(nums, length, target));
        List<List<Integer>> solution = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            Integer num = nums.get(i);
            if (length == 1) {
                ArrayList<Integer> integers = new ArrayList<>();
                if (num == target) {
                    solution.add(integers);
                    integers.add(num);
                }
            } else {
                List<List<Integer>> lists = anySum(nums.subList(i + 1, nums.size()), length - 1, target - num, mem);
                for (List<Integer> integers : lists) {
                    integers.add(0, num);
                    solution.add(integers);
                }
            }
        }
        mem.put(getKey(nums, length, target), solution);
        return solution;
    }

    private String getKey(List<Integer> nums, int length, int target) {
        return nums.toString() + "_" + length + "_" + target;
    }


}
