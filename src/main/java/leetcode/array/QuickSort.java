package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class QuickSort {

    //https://leetcode.com/problems/kth-largest-element-in-an-array/
    public int findKthLargest(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int pivot = quickSelect(nums, left, right);
            if (pivot == k - 1) {
                return nums[pivot];
            }
            if (pivot < k - 1) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }
        return nums[left];
    }

    //https://leetcode.com/problems/top-k-frequent-elements/
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }
        int[] unique = new int[frequency.size()];
        int index = 0;
        for (int num : frequency.keySet()) {
            unique[index++] = num;
        }

        int left = 0, right = unique.length - 1;
        while (left < right) {
            int pivot = quickSelect(unique, frequency, left, right);
            if (pivot == k - 1) {
                break;
            }
            if (pivot < k - 1) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }
        return Arrays.copyOfRange(unique, 0, k);
    }

    //https://leetcode.com/problems/k-closest-points-to-origin/
    public int[][] kClosest(int[][] ints, int i) {
        int left = 0, right = ints.length - 1;
        while (left < right) {
            int pivot = quickSelectPoints(ints, left, right);
            if (pivot == i - 1) {
                break;
            }
            if (pivot < i - 1) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }
        return Arrays.copyOfRange(ints, 0, i);
    }

    //794612
    //246179
    private int quickSelectPoints(int[][] points, int left, int right) {
        int pivotIndex = left;
        double pivot = distance(points[left][0], points[left][1]);
        for (int i = left + 1; i <= right; i++) {
            if (pivot > distance(points[i][0], points[i][1])) {
                pivotIndex++;
                swap(points, pivotIndex, i);
            }
        }
        swap(points, pivotIndex, left);
        return pivotIndex;
    }

    private int quickSelect(int[] nums, Map<Integer, Integer> frequency, int left, int right) {
        int pivotIndex = left;
        int pivot = nums[left];
        for (int i = left + 1; i <= right; i++) {
            if (frequency.get(pivot) < frequency.get(nums[i])) {
                pivotIndex++;
                swap(nums, pivotIndex, i);
            }
        }
        swap(nums, pivotIndex, left);
        return pivotIndex;
    }

    private int quickSelect(int[] nums, int left, int right) {
        int pivotIndex = left;
        int pivot = nums[left];
        for (int i = left + 1; i <= right; i++) {
            if (pivot < nums[i]) {
                pivotIndex++;
                swap(nums, pivotIndex, i);
            }
        }
        swap(nums, pivotIndex, left);
        return pivotIndex;
    }

    private void swap(int[] nums, int to, int from) {
        int temp = nums[to];
        nums[to] = nums[from];
        nums[from] = temp;
    }

    private void swap(int[][] nums, int to, int from) {
        int[] temp = nums[to];
        nums[to] = nums[from];
        nums[from] = temp;
    }

    private double distance(int x, int y) {
        return Math.sqrt(x * x + y * y);
    }

}
