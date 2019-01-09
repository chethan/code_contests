package learning.interview.string;

class StringSearch {

    private static final int MOD = 997;
    private static final int RADIX = 256;

    //brute force
    //https://leetcode.com/problems/implement-strstr/
    int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0 || haystack == null) return 0;

        for (int i = 0; i <= (haystack.length() - needle.length()); i++) {
            int matchingIndex = i;

            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    matchingIndex = -1;
                    break;
                }
            }

            if (matchingIndex >= 0) {
                return matchingIndex;
            }
        }

        return -1;
    }


    //Using Robin Karp
    //https://leetcode.com/problems/implement-strstr/
    int strStrRobinKarp(String haystack, String needle) {
        if (needle == null || needle.length() == 0 || haystack == null) return 0;
        if (needle.length() > haystack.length()) return -1;

        int rm = 1;
        for (int i = 0; i < needle.length() - 1; ++i) {
            rm = rm * RADIX % MOD;
        }

        long needleHash = getHash(needle);
        long haystackHash = getHash(haystack.substring(0, needle.length()));
        for (int i = 0; i <= (haystack.length() - needle.length()); i++) {
            if (haystackHash == needleHash && checkEquality(haystack, needle, i)) {
                return i;
            }
            if (i + needle.length() < haystack.length()) {
                haystackHash = deriveHash(haystackHash,
                        haystack.charAt(i),
                        haystack.charAt(i + needle.length()), rm);
            }
        }
        return -1;

    }

    private long getHash(String str) {
        long hash = 0;
        for (int i = 0; i < str.length(); i++) {
            hash = (((hash * RADIX) + (str.charAt(i))) % MOD);
        }
        return hash;
    }

    private long deriveHash(long currentHash, char oldChar, char newChar, int rm) {
        long intermediate = (currentHash + (oldChar * (MOD - rm))) * RADIX;
        return (intermediate + (newChar)) % MOD;
    }

    private boolean checkEquality(String haystack, String needle, int startIndex) {
        for (int i = 0; i < needle.length(); i++) {
            if (haystack.charAt(i + startIndex) != needle.charAt(i)) return false;
        }
        return true;
    }


}
