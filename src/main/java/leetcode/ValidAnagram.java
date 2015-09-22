package leetcode;

/**
 * Created by Chethan on 9/21/15.
 */
//https://leetcode.com/problems/valid-anagram/
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false;
        int[] charCounts = new int[256];
        for (int i = 0; i < s.length(); i++) {
            charCounts[s.charAt(i)]++;
            charCounts[t.charAt(i)]--;
        }
        for (int charCount : charCounts) {
            if (charCount != 0) return false;
        }
        return true;
    }
}
