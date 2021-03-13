package leetcode.array;

public class BinarySearch {

    //https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
    public int findMinInRotatedArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int start = 0, end = nums.length - 1;
        if (nums[start] < nums[end]) {
            return nums[start];
        }
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }

            if (nums[mid] > nums[0]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    //https://leetcode.com/problems/search-in-rotated-sorted-array/
    public int searchInRotatedArray(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] >= nums[start]) {
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target <= nums[end] && target > nums[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }

            }
        }
        return -1;
    }


    //https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
    public int[] searchRange(int[] nums, int target) {
        int[] targetRange = {-1, -1};
        int leftIndex = extremeInsertionIndex(nums, target, true);
        if (leftIndex == nums.length || nums[leftIndex] != target) {
            return targetRange;
        }

        targetRange[0] = leftIndex;
        targetRange[1] = extremeInsertionIndex(nums, target, false) - 1;
        return targetRange;
    }

    //https://leetcode.com/problems/peak-index-in-a-mountain-array/
    public int peakIndexInMountainArray(int[] arr) {
        int low = 0, high = arr.length, mid = 0;
        while (low < high) {
            mid = (low + high) / 2;
            int left = mid - 1;
            int right = mid + 1;
            if ((arr[left] < arr[mid]) && (arr[mid] > arr[right])) {
                break;
            }
            if (arr[left] > arr[mid]) {
                high = mid;
            }
            if (arr[mid] < arr[right]) {
                low = mid;
            }
        }
        return mid;
    }


    private int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > target || (left && target == nums[mid])) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}
