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

    //https://leetcode.com/problems/median-of-two-sorted-arrays/
    //https://medium.com/@hazemu/finding-the-median-of-2-sorted-arrays-in-logarithmic-time-1d3f2ecbeb46
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int leftLength = nums1.length;
        int rightLength = nums2.length;

        if (leftLength > rightLength) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int mergedLength = (leftLength + rightLength - 1) / 2;
        int l = 0, r = Math.min(mergedLength, leftLength);

        while (l < r) {
            int midl = (l + r) / 2;
            int midr = mergedLength - midl;

            if (nums1[midl] < nums2[midr]) {
                l = midl + 1;
            } else {
                r = midl;
            }
        }

        int maxLeftNums1 = l <= 0 ? Integer.MIN_VALUE : nums1[l - 1];
        int maxLeftNums2 = (mergedLength - l) < 0 ? Integer.MIN_VALUE : nums2[mergedLength - l];
        // Check if we have found the match
        // Check if the combined array is of even/odd length
        if ((leftLength + rightLength) % 2 == 0) {
            // If there are no elements left on the right side after partition
            int minRightNums1 = l > leftLength ? Integer.MAX_VALUE : nums1[l];
            // Similarly for nums2
            int minRightNums2 =
                (mergedLength - l + 1) >= rightLength ? Integer.MAX_VALUE
                    : nums2[mergedLength - l + 1];
            return (Math.max(maxLeftNums1, maxLeftNums2) +
                Math.min(minRightNums1, minRightNums2)) / 2.0;
        } else {
            return Math.max(maxLeftNums1, maxLeftNums2);
        }

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
