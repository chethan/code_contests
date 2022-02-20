package learning.interview.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Chethan on 9/19/16.
 */
public class Permutations {

    //https://leetcode.com/problems/permutations/
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

    //https://leetcode.com/problems/next-permutation
    int[] nextPermutation(int[] nums) {
        if (nums.length <= 2) {
            return nums;
        }
        int index = nums.length - 2;
        while (index >= 0 && nums[index] >= nums[index + 1]) {
            index--;
        }
        if (index != -1) {
            int swapIndex = nums.length - 1;
            for (int i = index; i < nums.length - 1; i++) {
                if (nums[index] >= nums[i + 1]) {
                    swapIndex = i;
                    break;
                }
            }
            swap(nums, index, swapIndex);
        }
        for (int i = index + 1, j = nums.length - 1; i < j; i++, j--) {
            swap(nums, i, j);
        }
        return nums;
    }

    int[] previousPermutation(int[] nums) {
        if (nums.length <= 2) {
            return nums;
        }
        int index = nums.length - 2;
        while (index >= 0 && nums[index] <= nums[index + 1]) {
            index--;
        }
        if (index != -1) {
            int swapIndex = nums.length - 1;
            for (int i = index; i < nums.length - 1; i++) {
                if (nums[index] <= nums[i + 1]) {
                    swapIndex = i;
                    break;
                }
            }
            swap(nums, index, swapIndex);
        }
        for (int i = index + 1, j = nums.length - 1; i < j; i++, j--) {
            swap(nums, i, j);
        }
        return nums;
    }


    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
