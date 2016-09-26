package leetcode;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by Chethan on 9/26/16.
 */
public class LargestNumberFinder {
    public String largestNumber(int[] nums) {
        long count = Arrays.stream(nums).filter(value -> value != 0).count();
        if (count == 0) return "0";
        return Arrays.stream(nums).mapToObj(Integer::toString).
                sorted((o1, o2) -> new BigInteger(o2 + o1).subtract(new BigInteger(o1 + o2)).intValue())
                .collect(Collectors.joining());
    }
}
