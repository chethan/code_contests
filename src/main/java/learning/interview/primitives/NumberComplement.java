package learning.interview.primitives;

public class NumberComplement {
    //https://leetcode.com/problems/number-complement
    int findComplement(int num) {
        int bitMask = 0, pointer = 1;
        for (int i = num; i != 0; i >>>= 1, pointer <<= 1) {
            bitMask |= pointer;
        }
        return num ^ bitMask;
    }
}
