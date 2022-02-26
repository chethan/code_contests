package leetcode.array;

public class MinimumFlips {

    //https://leetcode.com/problems/flip-string-to-monotone-increasing/
    public int minFlipsMonoIncr(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        //prefix[i]->number of flips to make all the values to zero for string[0..i]
        int[] prefix = new int[s.length() + 1];
        //suffix[i]->number of flips to make all the values to one for string[i..n]
        int[] suffix = new int[s.length() + 1];
        int n = s.length();
        for (int i = 0, j = n - 1; i < n; i++, j--) {
            prefix[i + 1] = prefix[i] + (s.charAt(i) == '1' ? 1 : 0);
            suffix[j] = suffix[j + 1] + (s.charAt(j) == '0' ? 1 : 0);
        }
        int minFlips = n;
        //dividing the string to two partitions
        // 0-k -> zeros , k+1-n -> ones
        for (int k = 0; k < n; k++) {
            int left = prefix[k];
            int right = suffix[k + 1];
            minFlips = Math.min(left + right, minFlips);
        }
        return minFlips;
    }
}
