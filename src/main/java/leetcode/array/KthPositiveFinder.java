package leetcode.array;

//https://leetcode.com/problems/kth-missing-positive-number/
public class KthPositiveFinder {

    public int findKthPositive(int[] arr, int k) {
        int prev = 0;
        for (int element : arr) {
            int missingCount = element - prev - 1;
            if (k <= missingCount) {
                return prev + k;
            }
            k -= missingCount;
            prev = element;
        }
        return arr[arr.length - 1] + k;
    }

    //https://leetcode.com/problems/kth-missing-positive-number/
    public int findKthPositiveBinarySearch(int[] arr, int k) {
        int lo = 0, hi = arr.length - 1, index = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int diff = arr[mid] - mid - 1;
            if (diff < k) {
                index = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return k + index + 1;
    }
}
