package leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Subsequence {

    //Time: O(T) where t is the length of the bigger string
    //Space: O(1)
    public boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0) {
            return true;
        }
        for (int i = 0, j = 0; i < t.length(); i++) {
            if (t.charAt(i) == s.charAt(j)) {
                j++;
            }
            if (j == s.length()) {
                return true;
            }
        }
        return false;
    }

    //Suppose there are lots of incoming s, say s1, s2, ..., sk
    // where k >= 109, and you want to check one by one to see if t has its subsequence.
    // In this scenario, how would you change your code?
    public boolean isSubsequenceFollowUp(String s, String t) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Map<Character, List<Integer>> reverseMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            reverseMap.putIfAbsent(t.charAt(i), new ArrayList<>());
            reverseMap.get(t.charAt(i)).add(i);
        }
        int prevMatchIndex = -1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!reverseMap.containsKey(ch)) {
                return false;
            }
            List<Integer> indices = reverseMap.get(ch);
            boolean matchFound = false;
            for (int index : indices) {
                if (prevMatchIndex < index) {
                    matchFound = true;
                    prevMatchIndex = index;
                    break;
                }
            }
            if (!matchFound) {
                return false;
            }
        }
        return true;
    }
}
