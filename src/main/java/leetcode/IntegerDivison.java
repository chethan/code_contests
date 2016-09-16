package leetcode;

/**
 * Created by Chethan on 9/16/16.
 */
public class IntegerDivison {
    public int divide(int dividend, int divisor) {
        int absoluteQuotient = divideRecur(-Math.abs(dividend), -Math.abs(divisor));
        if (dividend >= 0 && divisor >= 0 || dividend < 0 && divisor < 0) {
            if (absoluteQuotient < 0) return Integer.MAX_VALUE;
            return absoluteQuotient;
        }
        return -absoluteQuotient;
    }

    private int divideRecur(int dividend, int divisor) {
        if (divisor == -1) return Math.abs(dividend);
        if (divisor == 0) return Integer.MAX_VALUE;
        if (dividend > divisor) return 0;
        int quotient = 0, i = dividend;
        while (i <= divisor) {
            i = i - divisor;
            quotient++;
        }
        return quotient;
    }

}
