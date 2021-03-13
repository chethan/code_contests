package leetcode.array;

public class PeakFinder {

    //https://leetcode.com/problems/find-peak-element/description/
    public int findPeakElement(int[] nums) {
        if (nums.length == 0) return -1;
        return findPeakElementRecur(nums, 0, nums.length);
    }

    public int find2DPeak(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return -1;
        return find2DPeakRecur(grid, 0, grid[0].length);
    }

    private int findPeakElementRecur(int[] nums, int low, int high) {
        int mid = (low + high) / 2;
        if (mid != 0 && nums[mid - 1] > nums[mid]) return findPeakElementRecur(nums, low, mid - 1);
        if (mid + 1 != nums.length && nums[mid + 1] > nums[mid]) return findPeakElementRecur(nums, mid + 1, high);
        return mid;
    }

    private int find2DPeakRecur(int[][] grid, int low, int high) {
        int midColumn = (low + high) / 2;
        int maxRowIndex = findMaxIndex(grid, midColumn);
        if (midColumn > 0 &&
                grid[maxRowIndex][midColumn] < grid[maxRowIndex][midColumn - 1]) {
            return find2DPeakRecur(grid, 0, midColumn - 1);
        }
        if (midColumn + 1 < grid[0].length &&
                grid[maxRowIndex][midColumn] < grid[maxRowIndex][midColumn + 1]) {
            return find2DPeakRecur(grid, midColumn + 1, grid[0].length);
        }
        return grid[maxRowIndex][midColumn];
    }

    private int findMaxIndex(int[][] grid, int columnIndex) {
        int max = Integer.MIN_VALUE, maxIndex = 0;
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][columnIndex] > max) {
                max = grid[i][columnIndex];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
