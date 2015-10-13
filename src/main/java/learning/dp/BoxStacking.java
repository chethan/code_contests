package learning.dp;

import java.util.Arrays;

/**
 * Created by Chethan on 10/13/15.
 */
public class BoxStacking {

    public static final int WIDTH_INDEX = 0;
    public static final int LENGTH_INDEX = 1;
    public static final int HEIGHT_INDEX = 2;

    public int maxHeight(int[][] boxes) {
        int length = boxes.length;
        int[][] rearrangedBoxes = rearrange(boxes, length);
        Arrays.sort(rearrangedBoxes, (o1, o2) -> isBigger(o1, o2) ?  -1:1);
        int[] dp = new int[length * 3];
        dp[0] = rearrangedBoxes[0][HEIGHT_INDEX];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                if (isBigger(rearrangedBoxes[j], rearrangedBoxes[i])) {
                    dp[i] = Math.max(dp[i], rearrangedBoxes[i][HEIGHT_INDEX] + dp[j]);
                }
            }
        }
        return dp[dp.length - 1];
    }

    private boolean isBigger(int[] arr1, int[] arr2) {
        return arr1[WIDTH_INDEX] > arr2[WIDTH_INDEX] && arr1[LENGTH_INDEX] > arr2[LENGTH_INDEX];
    }

    private int[][] rearrange(int[][] boxes, int length) {
        int[][] reArrangedBoxes = new int[length * 3][3];
        for (int i = 0, j = 0; i < length; i++) {
            for (int k = 0; k < 3; k++, j++) {
                reArrangedBoxes[j][0] = boxes[i][k];
                reArrangedBoxes[j][1] = boxes[i][(k + 1) % 3];
                reArrangedBoxes[j][2] = boxes[i][(k + 2) % 3];
            }
        }
        return reArrangedBoxes;
    }
}
