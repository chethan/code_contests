package leetcode.array;

import java.util.Arrays;

public class CuttingRibbons {

    //Time: O(MlogN) -> M is the length of ribbons ,N is the max element in ribbon
    //Space: O(1)
    public int maxLength(int[] ribbons, int k) {
        //maximum length that we can create from this is
        // max length of the ribbon in the list
        // answer will be anywhere from 0 -> max
        int hi = Arrays.stream(ribbons).max().orElse(0);
        int lo = 1, result = 0;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int num = maxPossibleNumbersWithLength(ribbons, mid);
            if (num < k) {
                hi = mid - 1;
            } else {
                result = mid;
                lo = mid + 1;
            }
        }
        return result;

    }

    int maxPossibleNumbersWithLength(int[] ribbons, int length) {
        return Arrays.stream(ribbons)
            .map(ribbon -> ribbon / length).sum();
    }
}
