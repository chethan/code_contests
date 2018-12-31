package learning.interview.bitwise;

class SetBitsCounter {
    int countIterative(int number) {
        int count = 0;
        while (number != 0) {
            count += number & 1;
            number >>>= 1;
        }
        return count;
    }

    int countRecur(int number) {
        return count(number, 0);
    }

    //https://leetcode.com/problems/number-of-1-bits/
    int countBetter(int number) {
        int count = 0;
        while (number != 0) {
            number &= (number - 1);
            count++;
        }
        return count;
    }

    //https://leetcode.com/problems/counting-bits
    int[] countTill(int number) {
        int[] counts = new int[number + 1];
        while (number >= 0) {
            counts[number] = countBetter(number);
            number--;
        }
        return counts;
    }

    //https://leetcode.com/problems/power-of-two/
    boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    //https://leetcode.com/problems/power-of-four/
    boolean isPowerOfFour(int n) {
        boolean isPowerOfTwo = n > 0 && (n & (n - 1)) == 0;
        //Instead of this loop use 0x55555555 to find the ones in odd position
        int zeroCounter = 0;
        for (int mask = 1; isPowerOfTwo && (n & mask) == 0; mask <<= 1) {
            zeroCounter++;
        }
        return isPowerOfTwo && (zeroCounter & 1) == 0;

    }

    //https://leetcode.com/problems/binary-number-with-alternating-bits
    boolean hasAlternatingBits(int n) {
        for (int i=n; i != 0; i >>>= 1) {
            if ((i & 1) == 0 ^ (i & 2) != 0) {
                return false;
            }
        }
        return n != 0;
    }

    private int count(int number, int count) {
        if (number == 0) {
            return count;
        }
        return count(number >>> 1, count + (number & 1));
    }


}