package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Chethan on 9/19/16.
 */
//https://leetcode.com/problems/permutations/
public class PermutationGenerator {
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        if (nums.length == 1) {
            return Arrays.asList(Arrays.asList(nums[0]));
        }
        List<List<Integer>> finalPermutations = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int[] newList = new int[nums.length - 1];
            System.arraycopy(nums, 0, newList, 0, i);
            System.arraycopy(nums, i + 1, newList, i, nums.length - (i + 1));
            List<List<Integer>> permutations = permute(newList);
            for (List<Integer> permutation : permutations) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                list.addAll(permutation);
                finalPermutations.add(list);
            }

        }
        return finalPermutations;
    }

}
