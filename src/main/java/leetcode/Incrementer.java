package leetcode;

/**
 * Created by Chethan on 9/18/16.
 */
//https://leetcode.com/problems/plus-one/
public class Incrementer {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) return new int[]{1};
        int carry = 1;
        int tempResults[] = new int[digits.length];
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] + carry == 10) {
                tempResults[i] = 0;
                carry = 1;
            } else {
                tempResults[i] = digits[i] + carry;
                carry = 0;
            }
        }
        int finalResults[] = new int[carry == 1 ? digits.length + 1 : digits.length];
        finalResults[0] = 1;
        System.arraycopy(tempResults, 0, finalResults, carry, tempResults.length);
        return finalResults;
    }
}
