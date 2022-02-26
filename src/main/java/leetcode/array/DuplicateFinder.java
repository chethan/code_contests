package leetcode.array;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by Chethan on 9/19/16.
 */
public class DuplicateFinder {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        return Arrays.stream(nums).mapToObj(set::add).anyMatch(n -> !n);
    }
}
