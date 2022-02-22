package leetcode.array;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LabelPartitions {

    //https://leetcode.com/problems/partition-labels/
    public List<Integer> partitionLabels(String s) {
        Map<Character, int[]> intervals = createIntervals(s);
        List<Integer> result = new ArrayList<>();
        int[] prev = new int[]{0, 0};
        for (char c : intervals.keySet()) {
            int[] current = intervals.get(c);
            if (prev[1] >= current[0]) {
                prev[1] = Math.max(prev[1], current[1]);
            } else {
                result.add(prev[1] - prev[0] + 1);
                prev = current;
            }
        }
        result.add(prev[1] - prev[0] + 1);
        return result;
    }

    public List<Integer> partitionLabelsOptimized(String s) {
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        List<Integer> result = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if (end == i) {
                result.add(end - start + 1);
                start = i + 1;
            }
        }
        return result;
    }

    private Map<Character, int[]> createIntervals(String s) {
        Map<Character, int[]> intervals = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!intervals.containsKey(c)) {
                intervals.put(c, new int[]{i, i});
            } else {
                intervals.get(c)[1] = i;
            }
        }
        return intervals;
    }
}
