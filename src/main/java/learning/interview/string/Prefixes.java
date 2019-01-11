package learning.interview.string;

import java.util.Arrays;

class Prefixes {
    //https://leetcode.com/problems/longest-common-prefix
    String longestCommonPrefix(String[] strs) {
        if (strs == null) return null;
        if (strs.length == 0) return "";

        //Instead of sorting we can use a single loop to find the first and last element
        Arrays.sort(strs);
        String last = strs[strs.length - 1];
        String first = strs[0];
        int i = 0, len = Math.min(first.length(), last.length());
        while (i < len && first.charAt(i) == last.charAt(i)) i++;
        return first.substring(0, i);
    }
}
