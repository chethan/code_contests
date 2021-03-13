package leetcode.array;

import ds.Tuple;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MergeSort {

    //https://leetcode.com/problems/count-of-smaller-numbers-after-self/
    public List<Integer> countSmaller(int[] nums) {
        if (nums.length == 0) {
            return List.of();
        }
        int[] smaller = new int[nums.length];
        Tuple<Integer>[] tuples = new Tuple[nums.length];

        for (int i = 0; i < nums.length; i++) {
            tuples[i] = new Tuple<>(i, nums[i]);
        }
        countSmallerUsingMergeSort(tuples, smaller);
        return Arrays.stream(smaller).boxed().collect(Collectors.toList());
    }

    private Tuple<Integer>[] countSmallerUsingMergeSort(Tuple<Integer>[] tuples, int[] smaller) {
        if (tuples.length <= 1) {
            return tuples;
        }
        int mid = tuples.length / 2;
        Tuple<Integer>[] left = countSmallerUsingMergeSort(Arrays.copyOfRange(tuples, 0, mid),
            smaller);
        Tuple<Integer>[] right = countSmallerUsingMergeSort(
            Arrays.copyOfRange(tuples, mid, tuples.length), smaller);

        for (int i = 0, j = 0; i < left.length || j < right.length; ) {
            if (j == right.length || (i < left.length && left[i].right <= right[j].right)) {
                tuples[i + j] = left[i];
                smaller[left[i].left] += j;
                i++;
            } else {
                tuples[i + j] = right[j];
                j++;
            }
        }
        return tuples;
    }


}
