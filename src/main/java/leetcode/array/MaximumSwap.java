package leetcode.array;
//https://leetcode.com/problems/maximum-swap/

import java.util.ArrayList;
import java.util.List;

public class MaximumSwap {

    //Time: O(N) where n is the length of number
    //Space: O(N) to store the digits
    public int maximumSwap(int num) {
        if (num < 10) {
            return num;
        }
        int fromIndex = -1, toIndex = -1, maxIndex = 0;
        List<Integer> digits = new ArrayList<>();
        int loopNum = num;
        for (int i = 0; loopNum != 0; i++, loopNum /= 10) {
            int current = loopNum % 10;
            digits.add(current);
            if (current < digits.get(maxIndex)) {
                fromIndex = i;
                toIndex = maxIndex;
            }
            maxIndex = current > digits.get(maxIndex) ? i : maxIndex;
        }
        if (fromIndex != -1) {
            return swapNumber(digits, fromIndex, toIndex);
        }
        return num;
    }

    int swapNumber(List<Integer> digits, int from, int to) {
        int result = 0;
        int temp = digits.get(from);
        digits.set(from, digits.get(to));
        digits.set(to, temp);
        for (int i = digits.size() - 1; i >= 0; i--) {
            result = result * 10 + digits.get(i);
        }
        return result;
    }
}
