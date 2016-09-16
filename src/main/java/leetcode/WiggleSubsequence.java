package leetcode;

import java.util.stream.IntStream;

import static java.lang.Math.max;

/**
 * Created by Chethan on 9/16/16.
 */
//P[i] = Max{N[j]}+1 j < i
//N[i] = Max{P[j]}+1 j > i
public class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        int posEnding[] = new int[nums.length];
        int negEnding[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            posEnding[i] = negEnding[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && posEnding[i] < negEnding[j] + 1) {
                    posEnding[i] = negEnding[j] + 1;
                }
                if (nums[i] < nums[j] && negEnding[i] < posEnding[j] + 1) {
                    negEnding[i] = posEnding[j] + 1;
                }
            }
        }
        return IntStream.range(0, nums.length)
                .map(i->max(posEnding[i], negEnding[i])).max().orElse(0);
    }
}
