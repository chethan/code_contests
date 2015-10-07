package learning.dp;

/**
 * Created by Chethan on 10/6/15.
 */
//http://www.spoj.com/problems/SAMER08D/
public class DNASequences {
    public int findLCS(String first, String second, int segmentLength) {
        char[] fchars = first.toCharArray();
        char[] schars = second.toCharArray();
        int firstLength = first.length();
        int secondLength = second.length();

        int dp[][] = new int[firstLength][secondLength];
        dp[0][0] = fchars[0] == schars[0] ? 1 : 0;
        for (int i = 0; i < firstLength; i++) {
            for (int j = 0; j < secondLength; j++) {
                int fsPrevious = (i > 0 && j > 0) ? dp[i - 1][j - 1] : 0;
                int fPrevious = (i > 0) ? dp[i - 1][j] : 0;
                int sPrevious = (j > 0) ? dp[i][j - 1] : 0;
                if (fchars[i] == schars[j]) {
                    int counter = 0, segmentCount = 0;
                    for (int x = 1 - segmentLength; x <= segmentLength - 1; x++) {
                        if (i + x < 0 || j + x < 0 || i + x >= firstLength || j + x >= secondLength) continue;
                        if (fchars[i + x] == schars[j + x]) {
                            counter = counter + 1;
                        } else {
                            counter = 0;
                        }
                        segmentCount = Math.max(segmentCount, counter);

                    }
                    if (segmentCount >= segmentLength) {
                        dp[i][j] = 1 + fsPrevious;
                        continue;
                    }
                }

                dp[i][j] = Math.max(fPrevious, sPrevious);
            }
        }
        return dp[firstLength - 1][secondLength - 1];
    }
}
