package learning.interview.string;

import java.util.stream.IntStream;

class Palindromes {
    //https://leetcode.com/problems/shortest-palindrome
    String shortestPalindrome(String s) {
        if (isPalindrome(s)) return s;
        StringBuilder builder = new StringBuilder();
        for (int i = s.length() - 1; i > 0; i--) {
            builder.append(s.charAt(i));
            if (isPalindrome(builder.toString() + s)) {
                return builder.toString() + s;
            }
        }
        return "";
    }

    //https://leetcode.com/problems/shortest-palindrome
    String shortestPalindromeRabinKarp(String s) {
        int n = s.length(), pos = -1;
        long B = 256, MOD = 997, POW = 1, hash1 = 0, hash2 = 0;
        for (int i = 0; i < n; i++, POW = POW * B % MOD) {
            hash1 = (hash1 * B + s.charAt(i) + 1) % MOD;
            hash2 = (hash2 + (s.charAt(i) + 1) * POW) % MOD;
            if (hash1 == hash2) pos = i;
        }
        return new StringBuilder().append(s, pos + 1, n).reverse().append(s).toString();
    }

    //https://leetcode.com/problems/longest-palindromic-substring
    String longestPalindrome(String s) {
        if (s == null) return "";
        int n = s.length(), index = 0;
        String longestPalindrome = "";
        for (int j = 0; j < n; j++) {
            long B = 29, MOD = 1000000007, POW = 1, hash1 = 0, hash2 = 0;
            for (int i = j; i < n; i++, POW = POW * B % MOD) {
                hash1 = (hash1 * B + s.charAt(i) + 1) % MOD;
                hash2 = (hash2 + (s.charAt(i) + 1) * POW) % MOD;
                if (hash1 == hash2) {
                    index = i;
                }
            }
            if (index >= j) {
                String palindrome = s.substring(j, index + 1);
                longestPalindrome = palindrome.length() > longestPalindrome.length() ? palindrome : longestPalindrome;
            }
        }
        return longestPalindrome;
    }

    //https://leetcode.com/problems/palindromic-substrings
    int countSubstrings(String s) {
        if (s == null) return 0;
        int n = s.length(), count = 0;
        for (int j = 0; j < n; j++) {
            long B = 29, MOD = 1000000007, POW = 1, hash1 = 0, hash2 = 0;
            for (int i = j; i < n; i++, POW = POW * B % MOD) {
                hash1 = (hash1 * B + s.charAt(i) + 1) % MOD;
                hash2 = (hash2 + (s.charAt(i) + 1) * POW) % MOD;
                if (hash1 == hash2) {
                    count++;
                }
            }
        }
        return count;
    }

    //https://leetcode.com/problems/palindromic-substrings
    int countSubstringsExtend(String s) {
        if (s == null) return 0;
        return IntStream.range(0, s.length()).boxed().map(
                i -> extendPalindrome(s, i, i) + extendPalindrome(s, i, i + 1)
        ).mapToInt(i -> i).sum();
    }


    //https://leetcode.com/problems/longest-palindromic-substring
    String longestPalindromeDp(String s) {
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

    //https://leetcode.com/problems/valid-palindrome
    boolean isPalindromeOnlyAlphaNumeric(String s) {
        if (s == null || s.length() <= 1) return true;
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (!Character.isLetterOrDigit(s.charAt(i))) {
                j++;
            } else if (!Character.isLetterOrDigit(s.charAt(j))) {
                i--;
            } else if (Character.toUpperCase(s.charAt(i)) != Character.toUpperCase(s.charAt(j))) return false;
        }
        return true;
    }

    //https://leetcode.com/problems/valid-palindrome-ii/
    boolean isPalindromeAfterDeleting(String s) {
        if (s == null || s.length() <= 1) return true;
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return isPartPalindrome(s, i + 1, j) || isPartPalindrome(s, i, j - 1);
            }
        }
        return true;
    }

    private boolean isPartPalindrome(String s, int i, int j) {
        for (; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }


    private boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) return true;
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }

    private int extendPalindrome(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }

}
