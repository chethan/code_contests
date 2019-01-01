package learning.interview.numbers;


class Reverser {
    //https://leetcode.com/problems/reverse-integer/
    int reverse(int x) {
        int reversedNumber = 0;
        boolean isNegative = false;

        if (x == Integer.MIN_VALUE) {
            return 0;
        }
        if (x < 0) {
            x = -x;
            isNegative = true;
        }

        while (x != 0) {
            if (reversedNumber > ((Integer.MAX_VALUE - (x % 10)) / 10)) {
                return 0;
            }

            reversedNumber = (reversedNumber * 10) + (x % 10);
            x = x / 10;
        }
        return isNegative ? -reversedNumber : reversedNumber;
    }

    //https://leetcode.com/problems/palindrome-number
    boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int numDigits = (int) (Math.floor(Math.log10(x))) + 1;
        int msDigitMask = (int) (Math.pow(10, numDigits - 1));

        for (int i = 0; i < (numDigits / 2); i++) {
            if (x / msDigitMask != x % 10) {
                return false;
            }
            x = (x % msDigitMask) / 10;
            msDigitMask /= 100;
        }

        return true;
    }
}
