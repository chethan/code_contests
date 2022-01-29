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
        int length = Math.max(a.length(), b.length());
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int aChar = charAt(a, a.length() - i - 1);
            int bChar = charAt(b, b.length() - i - 1);
            sb.insert(0, aChar ^ bChar ^ carry);
            carry = (aChar & bChar) | (bChar & carry) | (aChar & carry);
        }
        if (carry == 1) {
            sb.insert(0, carry);
        }
        return sb.toString();
    }


    private int charAt(String s, int index) {
        if (index < s.length() && index >= 0) {
            return s.charAt(index) == '1' ? 1 : 0;
        }
        return 0;
    }
}
