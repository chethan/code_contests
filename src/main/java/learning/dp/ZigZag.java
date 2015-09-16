package learning.dp;

import static java.lang.Math.max;
import static java.util.Arrays.stream;

/**
 * Created by Chethan on 9/16/15.
 */
// M[i,positive] = Max{M[j,negative]} for all i<j and a[i]>a[j]
// M[i,negative] = Max{M[j,positive]} for all i<j and a[i]<a[j]
//http://community.topcoder.com/stat?c=problem_statement&pm=1259&rd=4493
public class ZigZag {
    public int longestZigZag(int[] numbers) {
        int[] positive = new int[numbers.length];
        int[] negative = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            positive[i] = negative[i] = 1;
            for (int j = 0; j < i; j++) {
                if (numbers[i] > numbers[j]) {
                    positive[i] = max(negative[j] + 1, positive[i]);
                }
                if (numbers[i] < numbers[j]) {
                    negative[i] = max(positive[j] + 1, negative[i]);
                }
            }

        }
        return max(stream(positive).max().getAsInt(), stream(negative).max().getAsInt());
    }

}
