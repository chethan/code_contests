package leetcode.design;

import java.util.*;

public class RandomizedSet {

    private Map<Integer, Integer> indexMap;
    private List<Integer> data;

    public RandomizedSet() {
        indexMap = new HashMap<>();
        data = new ArrayList<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (indexMap.containsKey(val)) {
            return false;
        }
        data.add(val);
        indexMap.put(val, data.size() - 1);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!indexMap.containsKey(val)) {
            return false;
        }
        int currentIndex = indexMap.get(val);
        int lastIndex = data.size() - 1;
        if (currentIndex != lastIndex) {
            int lastValue = data.get(lastIndex);
            Collections.swap(data, currentIndex, lastIndex);
            indexMap.put(lastValue, currentIndex);
        }
        data.remove(data.size() - 1);
        indexMap.remove(val);

        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        Random random = new Random();
        int randomIndex = random.nextInt(data.size());
        return data.get(randomIndex);
    }
}
