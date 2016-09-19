package leetcode;

/**
 * Created by Chethan on 9/16/16.
 */
//https://discuss.leetcode.com/topic/45980/very-detailed-step-by-step-explanation-java-solution/2
// Division is actually backward multiplication by approximating quotient
// num=a_0*2^0+a_1*2^1+a_2*2^2+...+a_n*2^n

public class IntegerDivision {

    public int divide(int dividend, int divisor) {
        if (divisor == 0) return Integer.MAX_VALUE;
        if (divisor == -1 && dividend == Integer.MIN_VALUE)
            return Integer.MAX_VALUE;

        long positiveDividend = Math.abs((long) dividend);
        long positiveDivisor = Math.abs((long) divisor);
        int absoluteQuotient = 0;

        while (positiveDividend >= positiveDivisor) {
            long temp = positiveDivisor, counter = 1;
            while (positiveDividend >= temp) {
                temp = temp << 1;
                counter = counter << 1;
            }
            absoluteQuotient += (counter >> 1);
            positiveDividend -= (temp >> 1);
        }

        if (dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0) {
            return absoluteQuotient;
        }
        return -absoluteQuotient;
    }
}
