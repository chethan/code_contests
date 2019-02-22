package learning.interview.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Substrings {
    //https://leetcode.com/problems/longest-substring-without-repeating-characters
    int lengthOfLongestSubstring(String s) {
        int start = 0, end = 1, maxLength = 0;
        if (s == null || s.length() == 0) return 0;
        if (s.length() == 1) return 1;
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
        if (s == null || s.length() == 0) return 0;
        if (s.length() == 1) return 1;
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

    //https://leetcode.com/problems/repeated-substring-pattern
    boolean repeatedSubstringPattern(String s) {
        for (int end = 1; end <= s.length() / 2; end++) {
            String substring = s.substring(0, end);
            boolean matches = true;
            for (int i = end; i < s.length(); i += end) {
                if (!s.substring(i, i + end > s.length() ? s.length() : i + end).equals(substring)) {
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
    String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t.length() == 0) return "";
        int[] lookup = new int[128];
        return "";
    }
}
