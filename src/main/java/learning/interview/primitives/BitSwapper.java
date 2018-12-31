package learning.interview.primitives;

class BitSwapper {
    int swapBits(int num, int i, int j) {
        //check boundary conditions
        if (((num >> i) & 1) != ((num >> j) & 1)) {
            return num ^ (1 << i | 1 << j);
        }
        return num;
    }

    //https://leetcode.com/problems/reverse-bits/
    int reverseBits(int n) {
        int leftBit = 1;
        int rightBit = Integer.MIN_VALUE;
        int bitMask = 0;
        do {
            if ((n & leftBit) != 0 ^ (n & rightBit) != 0) {
                bitMask |= (leftBit | rightBit);
            }
            leftBit <<= 1;
            rightBit >>>= 1;
        } while (leftBit <= rightBit);
        return n ^ bitMask;
    }
}

