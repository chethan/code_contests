package learning.interview.arrays;

class Segregator {
    /*
        Segregate even and odd elements in place
    */
    //Invariance: 0->evenMarker [even] , oddMarker->end [odd]
    int[] evenOdd(int[] input) {
        int evenMarker = 0, oddMarker = input.length - 1;
        while (evenMarker < oddMarker) {
            if ((input[evenMarker] & 1) == 0) {
                evenMarker++;
            } else {
                swap(input, oddMarker--, evenMarker);
            }
        }
        return input;
    }

    //Invariance: 0->low [0] , low->mid [1], mid->high [???> high ->end [2]
    //https://leetcode.com/problems/sort-colors/
    int[] colors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, mid++, low++);
            }
            else if (nums[mid] == 1) {
                mid++;
            }
            else if (nums[mid] == 2) {
                swap(nums, mid, high--);
            }
        }
        return nums;
    }

    private void swap(int[] nums, int from, int to) {
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }
}