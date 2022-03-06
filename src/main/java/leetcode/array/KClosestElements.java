package leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class KClosestElements {

    //https://leetcode.com/problems/find-k-closest-elements/
    //Time: O(LogN+K) N is length of array
    //Space : O(1) ignoring result array
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int lo = 0, hi = arr.length - 1;
        List<Integer> result = new ArrayList<>();

        //handling special case
        if (k == arr.length) {
            for (int num : arr) {
                result.add(num);
            }
            return result;
        }

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] >= x) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        lo = lo - 1;
        hi = lo + 1;
        while (hi - lo - 1 < k) {
            if (lo < 0) {
                hi += 1;
                continue;
            }
            if (arr.length == hi || Math.abs(arr[lo] - x) <= Math.abs(arr[hi] - x)) {
                lo -= 1;
            } else {
                hi += 1;
            }

        }
        //1 to 2 -> 2 (2-0
        for (int i = lo + 1; i < hi; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}
