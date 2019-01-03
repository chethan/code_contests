package learning.interview.arrays;

class Duplicates {
    //Invariance: 0-writeIndex(no dupilcates)
    int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int writeIndex = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[writeIndex - 1] != nums[i]) {
                nums[writeIndex++] = nums[i];
            }
        }
        return writeIndex;
    }

    //https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii
    int removeDuplicatesAppearingMoreThanTwice(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int writeIndex = 1, duplicateCount = 1;
        for (int i = 1; i < nums.length; i++) {
            duplicateCount = (nums[writeIndex - 1] == nums[i]) ? duplicateCount + 1 : 1;
            if (duplicateCount <= 2) {
                nums[writeIndex++] = nums[i];
            }
        }
        return writeIndex;
    }

    int removeElement(int[] nums, int val) {
        int writeIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[writeIndex++] = nums[i];
            }
        }
        return writeIndex;
    }

    int[] moveZeros(int[] nums) {
        int writeIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[writeIndex] != 0) {
                writeIndex++;
            } else if (nums[i] != 0) {
                nums[writeIndex++] = nums[i];
                nums[i] = 0;
            }
        }
        return nums;

    }
}
