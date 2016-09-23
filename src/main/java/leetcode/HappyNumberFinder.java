package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Chethan on 9/23/16.
 */
public class HappyNumberFinder {
    public boolean isHappy(int n) {
        long intialNumber = n, squareSum = 0;
        if (n == 1) return true;
        Set<Long> sequence = new HashSet<>();
        while (squareSum != 1) {
            squareSum = 0;
            while (intialNumber != 0) {
                squareSum += (intialNumber % 10) * (intialNumber % 10);
                intialNumber = intialNumber / 10;
            }
            if (sequence.contains(squareSum)) return false;
            sequence.add(squareSum);
            intialNumber = squareSum;
        }
        return true;
    }
}
