package learning.interview.bitwise;

class BitwiseArithmetic {

    //https://leetcode.com/problems/powx-n/
    double pow(double x, int y) {
        double result = 1;
        if (x == 1) {
            return result;
        }
        if (y < 0) {
            x = (1 / x);
            if (y == Integer.MIN_VALUE) {
                result *= x;
                y = Integer.MAX_VALUE;
            } else {
                y = -y;
            }
        }
        for (; y != 0; y >>= 1) {
            if ((y & 1) == 1) {
                result *= x;
            }
            x *= x;
        }
        return result;
    }

    int divide(int a, int b) {
        if (b == 0) {
            return 0;
        }
        int power = 32, quotient = 0;
        int bpow = b << power;
        while (a >= b) {
            while (bpow > a) {
                bpow >>>= 1;
                power--;
            }
            quotient = smartAdd(quotient, 1 << power);
            a = a - bpow;
        }
        return quotient;
    }

    int multiply(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        int shiftingMarker = 0, product = 0;
        for (; b != 0; shiftingMarker++, b >>>= 1) {
            if ((b & 1) != 0) {
                product = smartAdd(product, a << shiftingMarker);
            }
        }
        return product;
    }

    //https://leetcode.com/problems/sum-of-two-integers
    int add(int a, int b) {
        int abit, bbit, carryBit = 0, sum = 0;
        for (int count = 0; a != 0 || b != 0 || carryBit != 0; a >>>= 1, b >>>= 1, count++) {
            abit = a & 1;
            bbit = b & 1;
            int sumBit = abit ^ bbit ^ carryBit;
            carryBit = (abit & bbit) | (abit & carryBit) | (carryBit & bbit);
            if (count < 32) {
                sum |= (sumBit << count);
            }
        }
        return sum;
    }

    //https://leetcode.com/problems/sum-of-two-integers
    int smartAdd(int a, int b) {
        int sum = a ^ b; // XOR derives the sum bits, without carry
        int carry = (a & b) << 1; // AND derives the carry bits
        if (carry == 0) {
            return sum;
        }
        return smartAdd(sum, carry);
    }
}