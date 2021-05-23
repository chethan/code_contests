package leetcode.random;

//https://leetcode.com/problems/random-pick-with-weight/
public class RandomPickWithWeight {

    private int[] prefixWeight;

    public RandomPickWithWeight(int[] w) {
        if (w.length == 0) {
            return;
        }
        prefixWeight = new int[w.length];
        prefixWeight[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            prefixWeight[i] += prefixWeight[i - 1] + w[i];
        }
    }

    public int pickIndex() {
        if (prefixWeight == null) {
            return -1;
        }
        double target = Math.random() * prefixWeight[prefixWeight.length - 1];
        int low = 0, high = prefixWeight.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (target > prefixWeight[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
