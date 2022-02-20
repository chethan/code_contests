package leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencySort {

    //https://leetcode.com/problems/sort-characters-by-frequency/
    public String frequencySort(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        //bucket sort based on the frequency
        List<List<Character>> buckets = new ArrayList<>();
        for (int i = 0; i <= s.length(); i++) {
            buckets.add(null);
        }
        for (char c : frequencyMap.keySet()) {
            int count = frequencyMap.get(c);
            if (buckets.get(count) == null) {
                buckets.set(count, new ArrayList<>());
            }
            buckets.get(count).add(c);
        }
        StringBuilder result = new StringBuilder();
        for (int i = buckets.size() - 1; i >= 0; i--) {
            if (buckets.get(i) == null) {
                continue;
            }
            int finalI = i;
            buckets.get(i).stream()
                .map(c -> String.valueOf(c).repeat(finalI))
                .forEach(result::append);
        }
        return result.toString();
    }
}
