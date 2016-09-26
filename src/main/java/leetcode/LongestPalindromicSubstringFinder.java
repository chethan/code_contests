package leetcode;

/**
 * Created by Chethan on 9/25/16.
 */
public class LongestPalindromicSubstringFinder {

    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) return s;
        boolean[][] palindromeCache = new boolean[s.length()][s.length()];
        int longestPalindromeLength = 1;
        String longestPalindrome = null;

        for (int len = 0; len < s.length(); len++) {
            for (int i = 0; i < s.length() - len; i++) {
                int j = i + len;
                if (s.charAt(i) == s.charAt(j)
                        && (j - i <= 2 || palindromeCache[i + 1][j - 1])) {
                    palindromeCache[i][j] = true;
                    if (longestPalindromeLength < j - i + 1) {
                        longestPalindromeLength = j - i + 1;
                        longestPalindrome = s.substring(i, j + 1);
                    }

                }

            }
        }
        return longestPalindrome;
    }
}
