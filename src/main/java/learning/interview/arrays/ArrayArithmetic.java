package learning.interview.arrays;

class ArrayArithmetic {
    //https://leetcode.com/problems/plus-one
    int[] plusOne(int[] digits) {
        if (digits.length == 0) {
            return digits;
        }
        int n = digits.length - 1;
        digits[n] = digits[n] + 1;
        for (int i = n; i >= 0 && digits[i] == 10; i--) {
            digits[i] = 0;
            if (i > 0) {
                digits[i - 1] = digits[i - 1] + 1;
            } else {
                int[] newDigits = new int[digits.length + 1];
                newDigits[0] = 1;
                System.arraycopy(digits, 0, newDigits, 1, digits.length);
                return newDigits;
            }
        }
        return digits;
    }

    //https://leetcode.com/problems/add-binary/
    String addBinary(String a, String b) {
        char[] input1 = a.toCharArray();
        char[] input2 = b.toCharArray();
        char[] result = new char[Math.max(input2.length, input1.length)];
        int ai = input1.length - 1, bi = input2.length - 1;

        int carry = 0;
        for (int i = result.length - 1; i >= 0; i--, ai--, bi--) {
            int temp = getValue(input1, ai) + getValue(input2, bi) + carry;
            carry = (temp >= 2) ? 1 : 0;
            result[i] = ((temp & 1) == 1) ? '1' : '0';
        }

        return (carry == 1) ? ('1' + new String(result)) : new String(result);
    }


    private int getValue(char[] a, int index) {
        return (index < 0 || index >= a.length) ? 0 : a[index] - '0';

    }
}
