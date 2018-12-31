package learning.interview.bitwise;

class HammingDistance {

    //https://leetcode.com/problems/total-hamming-distance/
    /*
    For each bit position 1-32 in a 32-bit integer, we count the number of integers in the array which have that bit set.
    Then, if there are n integers in the array and k of them have a particular bit set and (n-k) do not,
    then that bit contributes k*(n-k) hamming distance to the total
     */
    int totalHammingDistance(int[] nums) {
        int totalDistance = 0;
        for (int i = 0; i < 32; i++) {
            int bitCount = 0;
            for (int num : nums) {
                bitCount += ((num >>> i) & 1);
            }
            totalDistance += (bitCount * (nums.length - bitCount));
        }
        return totalDistance;
    }

    //https://leetcode.com/problems/hamming-distance/
    int hammingDistance(int x, int y) {
        SetBitsCounter setBitsCounter = new SetBitsCounter();
        return setBitsCounter.countBetter(x ^ y);
    }
}
