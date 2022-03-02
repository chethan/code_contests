package leetcode.array;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/palindrome-permutation/
public class PalindromePermutation {

    public boolean canPermutePalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            boolean isUnique = set.add(s.charAt(i));
            if (!isUnique) {
                set.remove(s.charAt(i));
            }
        }
        return set.size() <= 1;
    }

    public boolean canPermutePalindromeUsingMap(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        int[] frequency = new int[26];
        for (int i = 0; i < s.length(); i++) {
            frequency[s.charAt(i) - 'a']++;
        }
        int oddCharCount = 0;
        int expectedCount = s.length() % 2 == 0 ? 0 : 1;
        for (int i = 0; i < 26; i++) {
            int count = frequency[i];
            if (count % 2 == 1) {
                oddCharCount++;
            }
            if (oddCharCount > expectedCount) {
                return false;
            }
        }
        return true;
    }
}
