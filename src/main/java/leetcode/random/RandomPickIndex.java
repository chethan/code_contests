package leetcode.random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

//https://leetcode.com/problems/random-pick-index/
public class RandomPickIndex {

    private final int[] nums;
    private HashMap<Integer, List<Integer>> indices;
    private final Random rand;

    public RandomPickIndex(int[] nums) {
        this.nums = nums;
        indices = new HashMap<>();
        rand = new Random();
        for (int i = 0; i < nums.length; i++) {
            indices.putIfAbsent(nums[i], new ArrayList<>());
            indices.get(nums[i]).add(i);
        }
    }

    public int pick(int target) {
        if (indices.containsKey(target)) {
            List<Integer> i = indices.get(target);
            return i.get(rand.nextInt(i.size()));
        }
        return -1;
    }

    public int pickUsingReservoirSampling(int target) {
        int count = 0, selectedIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (target == num) {
                count++;
                if (rand.nextInt(count) == 0) {
                    selectedIndex = i;
                }
            }
        }
        return selectedIndex;
    }
}
