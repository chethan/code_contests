package learning.interview.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Substrings {

    //https://leetcode.com/problems/longest-substring-without-repeating-characters
    int lengthOfLongestSubstring(String s) {
        int start = 0, end = 1, maxLength = 0;
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(start));
        while (end < s.length()) {
            if (!set.contains(s.charAt(end))) {
                set.add(s.charAt(end));
                end++;
            } else {
                maxLength = Math.max(maxLength, end - start);
                set = new HashSet<>();
                start++;
                end = start + 1;
                set.add(s.charAt(start));
            }
        }
        maxLength = Math.max(maxLength, end - start);
        return maxLength;
    }

    //https://leetcode.com/problems/longest-substring-without-repeating-characters/discuss/1729/11-line-simple-Java-solution-O(n)-with-explanation
    int lengthOfLongestSubstringBetter(String s) {
        int maxLength = 0;
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int start = 0, end = 0; end < s.length(); end++) {
            if (map.containsKey(s.charAt(end))) {
                start = Math.max(start, map.get(s.charAt(end)) + 1);
            }
            map.put(s.charAt(end), end);
            maxLength = Math.max(maxLength, end - start + 1);

        }
        return maxLength;
    }

    //https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int left = 0, right = 0, maxLength = 0;
        Map<Character, Integer> reverseIndex = new HashMap<>();
        while (right < s.length()) {
            reverseIndex.put(s.charAt(right), right);
            if (reverseIndex.size() == 3) {
                Integer leftIndex = Collections.min(reverseIndex.values());
                reverseIndex.remove(s.charAt(leftIndex));
                left = leftIndex + 1;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }

    //https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null) {
            return 0;
        }
        int left = 0, right = 0, maxLength = 0;
        Map<Character, Integer> reverseIndex = new LinkedHashMap<>(100, 0.5f, true);
        while (right < s.length()) {
            reverseIndex.put(s.charAt(right), right);
            if (reverseIndex.size() > k) {
                int lastIndex = Collections.min(reverseIndex.values());
                reverseIndex.remove(s.charAt(lastIndex));
                left = lastIndex + 1;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }

    //https://leetcode.com/problems/maximum-erasure-value/
    public int maximumUniqueSubarray(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int left = 0, right = 0, maxScore = 0;
        Map<Integer, Integer> reverseIndex = new HashMap<>();
        List<Integer> prefixSum = new ArrayList<>();
        prefixSum.add(0);
        while (right < nums.length) {
            prefixSum.add(prefixSum.get(right) + nums[right]);
            if (reverseIndex.containsKey(nums[right])) {
                left = Math.max(reverseIndex.get(nums[right]) + 1, left);
            }
            reverseIndex.put(nums[right], right);
            maxScore = Math.max(maxScore, prefixSum.get(right + 1) - prefixSum.get(left));
            right++;

        }
        return maxScore;
    }


    //https://leetcode.com/problems/repeated-substring-pattern
    boolean repeatedSubstringPattern(String s) {
        for (int end = 1; end <= s.length() / 2; end++) {
            String substring = s.substring(0, end);
            boolean matches = true;
            for (int i = end; i < s.length(); i += end) {
                if (!s.substring(i, i + end > s.length() ? s.length() : i + end)
                    .equals(substring)) {
                    matches = false;
                    break;
                }
            }
            if (matches) {
                return true;
            }
        }
        return false;
    }

    //https://leetcode.com/problems/minimum-window-substring/
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> tFrequency = new HashMap<>();
        Map<Character, Integer> windowFrequency = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            tFrequency.put(t.charAt(i), tFrequency.getOrDefault(t.charAt(i), 0) + 1);
        }
        int left = 0, right = 0, uniqueCharsInT = tFrequency.size(), windowSize = 0;
        int[] result = {-1, 0, 0};
        while (right < s.length()) {
            char current = s.charAt(right);
            windowFrequency.put(current, windowFrequency.getOrDefault(current, 0) + 1);

            if (tFrequency.containsKey(current) &&
                tFrequency.get(current).intValue() == windowFrequency.get(current).intValue()) {
                windowSize++;
            }
            while (left <= right && windowSize == uniqueCharsInT) {
                current = s.charAt(left);
                if (result[0] == -1 || (right - left + 1) < result[0]) {
                    result[0] = right - left + 1;
                    result[1] = left;
                    result[2] = right;
                }
                windowFrequency.put(current, windowFrequency.get(current) - 1);
                if (tFrequency.containsKey(current) &&
                    tFrequency.get(current) > windowFrequency.get(current)) {
                    windowSize--;
                }
                left++;
            }
            right++;
        }
        //abcddcdba
        return result[0] == -1 ? "" : s.substring(result[1], result[2] + 1);
    }

    //https://leetcode.com/problems/repeated-substring-pattern
    //ABABA
    //0,0,1,2,3
    boolean repeatedSubstringPatternKMP(String s) {
        int[] failureTable = computeFailureTable(s);
        int failureLength = failureTable[failureTable.length - 1];
        return (failureLength >= (failureTable.length / 2.0))
            && failureTable.length % (failureTable.length - failureLength) == 0;
    }

    private int[] computeFailureTable(String s) {
        int[] failureTable = new int[s.length()];
        failureTable[0] = 0;
        int left = 0, right = 1;
        while (right < failureTable.length) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                failureTable[right] = left;
                right++;
            } else if (left > 0) {
                left = failureTable[left - 1];
            } else {
                failureTable[right] = 0;
                right++;
            }
        }
        return failureTable;
    }


}
