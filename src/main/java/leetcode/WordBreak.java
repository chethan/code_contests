package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Chethan on 10/14/15.
 */
public class WordBreak {
    //https://leetcode.com/problems/word-break/
    public boolean wordBreakOne(String s, Set<String> wordDict) {
        int length = s.length();
        boolean[] dp = new boolean[length + 1];
        dp[0] = true;
        for (int i = 0; i < length; i++) {
            if (dp[i]) {
                for (String word : wordDict) {
                    int end = i + word.length();
                    if (end > length || dp[end]) continue;
                    dp[end] = s.substring(i, end).equals(word);
                }
            }
        }
        return dp[length];
    }

    //https://leetcode.com/problems/word-break-ii/
    public List<String> wordBreakTwo(String s, Set<String> wordDict) {
        int length = s.length();
        List<String>[] dp = new ArrayList[length + 1];
        dp[0] = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (dp[i] != null) {
                for (String word : wordDict) {
                    int end = i + word.length();
                    if (end > length) continue;
                    if (s.substring(i, end).equals(word)) {
                        if (dp[end] == null) dp[end] = new ArrayList<>();
                        dp[end].add(word);
                    }
                }
            }
        }
        if (dp[dp.length - 1] == null) return new ArrayList<>();
        return generateFromDpTable(dp, dp.length - 1);
    }

    private List<String> generateFromDpTable(List<String>[] dp, int index) {
        List<String> sentances = new ArrayList<>();
        if (index <= 0 || dp[index] == null) return sentances;
        for (String s : dp[index]) {
            if (index - s.length() == 0) {
                sentances.add(s);
            } else {
                List<String> strings = generateFromDpTable(dp, index - s.length());
                for (String string : strings) {
                    sentances.add(string+" "+s);
                }
            }
        }
        return sentances;
    }

}
