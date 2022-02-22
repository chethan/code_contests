package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/problems/first-unique-number/
public class FirstUnique {

    private Set<Integer> queue = new LinkedHashSet<>();
    private Map<Integer, Boolean> frequencyMap = new HashMap<>();

    public FirstUnique(int[] nums) {
        Arrays.stream(nums).forEach(this::add);
    }

    public int showFirstUnique() {
        if (!queue.isEmpty()) {
            return queue.iterator().next();
        }
        return -1;
    }

    public void add(int value) {
        if (!frequencyMap.containsKey(value)) {
            frequencyMap.put(value, true);
            queue.add(value);
        } else {
            frequencyMap.put(value, false);
            queue.remove(value);
        }
    }
/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */
}
