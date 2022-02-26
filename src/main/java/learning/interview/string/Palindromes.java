package learning.interview.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

class Palindromes {

    //https://leetcode.com/problems/longest-palindromic-substring/
    public String longestPalindromeWithOofNMemory(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        StringMeta result = null;
        for (int i = 0; i < s.length(); i++) {
            StringMeta len1 = expandAroundCenter(s, i, i);
            StringMeta len2 = expandAroundCenter(s, i, i + 1);
            StringMeta max = len1.length > len2.length ? len1 : len2;
            if (result == null || result.length < max.length) {
                result = max;
            }
        }
        return result != null ? s.substring(result.from, result.to) : "";
    }

    private static class StringMeta {

        int length;
        int from;
        int to;

        StringMeta(int length, int from, int to) {
            this.length = length;
            this.from = from;
            this.to = to;
        }

        public String toString() {
            return length + " " + from + " " + to;
        }
    }

    //https://leetcode.com/problems/shortest-palindrome
    //Complexity: o(n*n)
    String shortestPalindrome(String s) {
        if (isPalindrome(s)) {
            return s;
        }
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
    //Complexity: o(n)
    //Find the largest palindrome substring starting with index 0 , and prepend the remaining chars in reverse order
    String shortestPalindromeRabinKarp(String s) {
        int n = s.length(), pos = -1;
        long B = 256, MOD = 997, POW = 1, hash1 = 0, hash2 = 0;
        for (int i = 0; i < n; i++, POW = POW * B % MOD) {
            hash1 = (hash1 * B + s.charAt(i) + 1) % MOD;
            hash2 = (hash2 + (s.charAt(i) + 1) * POW) % MOD;
            if (hash1 == hash2) {
                pos = i;
            }
        }
        return new StringBuilder().append(s, pos + 1, n).reverse().append(s).toString();
    }

    //https://leetcode.com/problems/longest-palindromic-substring
    //Complexity: o(n*n)
    String longestPalindrome(String s) {
        if (s == null) {
            return "";
        }
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
                longestPalindrome = palindrome.length() > longestPalindrome.length() ? palindrome
                    : longestPalindrome;
            }
        }
        return longestPalindrome;
    }

    //https://leetcode.com/problems/palindromic-substrings
    //Complexity: o(n*n)
    int countSubstrings(String s) {
        if (s == null) {
            return 0;
        }
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
        if (s == null) {
            return 0;
        }
        return IntStream.range(0, s.length()).boxed().map(
            i -> extendPalindrome(s, i, i) + extendPalindrome(s, i, i + 1)
        ).mapToInt(i -> i).sum();
    }

    //https://leetcode.com/problems/longest-palindromic-substring
    String longestPalindromeDp(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
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
        if (s == null || s.length() <= 1) {
            return true;
        }
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (!Character.isLetterOrDigit(s.charAt(i))) {
                j++;
            } else if (!Character.isLetterOrDigit(s.charAt(j))) {
                i--;
            } else if (Character.toUpperCase(s.charAt(i)) != Character.toUpperCase(s.charAt(j))) {
                return false;
            }
        }
        return true;
    }

    //https://leetcode.com/problems/valid-palindrome-ii/
    boolean isPalindromeAfterDeleting(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return isPartPalindrome(s, i + 1, j) || isPartPalindrome(s, i, j - 1);
            }
        }
        return true;
    }

    //https://leetcode.com/problems/palindrome-pairs/
    //https://leetcode.com/problems/palindrome-pairs/discuss/79210/The-Easy-to-unserstand-JAVA-Solution
    List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> pairs = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        if (words == null || words.length == 0) {
            return pairs;
        }
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        if (map.containsKey("")) {
            int blankIdx = map.get("");
            for (int i = 0; i < words.length; i++) {
                if (i != blankIdx && isPalindrome(words[i])) {
                    pairs.add(Arrays.asList(blankIdx, i));
                    pairs.add(Arrays.asList(i, blankIdx));
                }
            }
        }
        for (int i = 0; i < words.length; i++) {
            String reverse = new StringBuilder(words[i]).reverse().toString();
            if (map.containsKey(reverse) && map.get(reverse) != i) {
                pairs.add(Arrays.asList(i, map.get(reverse)));
            }
        }
        for (int i = 0; i < words.length; i++) {
            String cur = words[i];
            for (int cut = 1; cut < cur.length(); cut++) {
                String part1 = cur.substring(0, cut);
                String part2 = cur.substring(cut);
                String part2Reverse = new StringBuilder(part2).reverse().toString();
                String part1Reverse = new StringBuilder(part1).reverse().toString();
                if (map.containsKey(part2Reverse) && isPalindrome(part1)) {
                    pairs.add(Arrays.asList(map.get(part2Reverse), i));
                }
                if (map.containsKey(part1Reverse) && isPalindrome(part2)) {
                    pairs.add(Arrays.asList(i, map.get(part1Reverse)));
                }

            }
        }
        return pairs;


    }

    private StringMeta expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            left--;
            right++;
        }
        return new StringMeta(right - left - 1, left + 1, right);
    }

    private boolean isPartPalindrome(String s, int i, int j) {
        for (; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }


    private boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
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
