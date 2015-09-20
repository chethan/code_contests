package leetcode;

/**
 * Created by Chethan on 9/19/15.
 */
public class HammingWeight {
    public int hammingWeight(int n) {
        return hammingWeightU(0xffffffffL&n);
    }

    public int hammingWeightU(long n){
        if (n == 0) return 0;
        return (int) (n % 2 + hammingWeightU(n / 2));
    }
}
