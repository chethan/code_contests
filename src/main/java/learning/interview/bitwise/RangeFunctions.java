package learning.interview.bitwise;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class RangeFunctions {
    //comapre msbs till they are same
    //https://leetcode.com/problems/bitwise-and-of-numbers-range/
    int rangeBitwiseAnd(int m, int n) {
        int mSetBit = 0;
        for (int tempn = n, count = 0; tempn != 0; tempn >>>= 1, count++) {
            if ((tempn & 1) != 0) {
                mSetBit = count;
            }
        }
        int finalResult = 0;
        int bitMask = 1 << mSetBit;
        while (bitMask != 0 && (m & bitMask) == (n & bitMask)) {
            finalResult |= (m & bitMask);
            bitMask >>>= 1;
        }
        return finalResult;
    }

    //https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/
    int countPrimeSetBits(int L, int R) {
        SetBitsCounter setBitsCounter = new SetBitsCounter();
        int count = 0;
        for (int i = L; i <= R; i++) {
            if (isPrime(setBitsCounter.countBetter(i))) {
                count++;
            }
        }
        return count;
    }

    private boolean isPrime(int n) {
        Set<Integer> primes = new HashSet<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31));
        return primes.contains(n);
    }


}