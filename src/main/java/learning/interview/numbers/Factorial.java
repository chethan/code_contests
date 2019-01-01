package learning.interview.numbers;

class Factorial {
   //https://leetcode.com/problems/factorial-trailing-zeroes
   int trailingZeroes(int n) {
       return n==0?0:(n/5 + trailingZeroes(n/5));
    }
}
