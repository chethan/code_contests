package learning.interview.numbers;

class DigitFinder {
    //https://leetcode.com/problems/nth-digit
    int findNthDigit(int n) {
        int digitSize = 1;
        //to avoid overflows
        long counter = 9;
        while (n > (counter * digitSize)) {
            n = (int) (n - (counter * digitSize));
            counter = counter * 10;
            digitSize += 1;
        }
        int startingNumber = (int) (Math.pow(10, digitSize - 1));
        return digit(startingNumber + (n - 1) / digitSize, digitSize - ((n - 1) % digitSize));
    }


    //https://leetcode.com/problems/number-of-digit-one/
    int countDigitOne(int n) {
        int result = 0;
        if(n<=0) return 0;
        for (long k = 1; (n / k) != 0; k *= 10) {
            int numberOfTens = (int) (n / k);
            int digit = (int) (n % k);
            result += (numberOfTens / 10) * k;
            if (numberOfTens % 10 != 0) {
                result += (numberOfTens % 10 == 1) ? digit + 1 : k;
            }
        }
        return result;
    }

    private int digit(int number, int pos) {
        if (number < 10) return number;
        while (pos > 1) {
            number = number / 10;
            pos--;
        }
        return number % 10;
    }
}
