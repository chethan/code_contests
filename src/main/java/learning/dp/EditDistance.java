package learning.dp;

/**
 * Created by Chethan on 9/21/15.
 */
//https://leetcode.com/problems/edit-distance/
//http://www.spoj.pl/problems/EDIST/
//D[m,n]=min{D(i-1,j)+1,D(i,j-1)+1,D(i-1,j-1)+1} for all i 1..m, j i..n
public class EditDistance {

    public int minDistance(String word1, String word2) {
        int[][] minDistance = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            minDistance[i][0] = i;
        }
        for (int j = 0; j <= word2.length(); j++) {
            minDistance[0][j] = j;
        }
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                int add = minDistance[i - 1][j] + 1;
                int delete = minDistance[i][j - 1] + 1;
                int replace =
                    minDistance[i - 1][j - 1] + (word1.charAt(i - 1) == word2.charAt(j - 1) ? 0
                        : 1);
                minDistance[i][j] = Math.min(Math.min(add, delete), replace);
            }
        }
        return minDistance[word1.length()][word2.length()];
    }

    //https://leetcode.com/problems/one-edit-distance/
    public boolean isOneEditDistance(String s, String t) {
        int diff = s.length() - t.length();
        if (Math.abs(diff) > 1) {
            return false;
        }
        boolean editDone = false;
        for (int i = 0, j = 0; i < s.length() || j < t.length(); ) {
            char sChar = i < s.length() ? s.charAt(i) : ' ';
            char tChar = j < t.length() ? t.charAt(j) : ' ';
            if (sChar != tChar) {
                if (editDone) {
                    return false;
                }
                editDone = true;
                if (diff >= 0) {
                    i++;
                }
                if (diff <= 0) {
                    j++;
                }

            } else {
                i++;
                j++;
            }
        }
        return editDone;
    }
}
