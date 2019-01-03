package learning.interview.arrays;

class WaterContainer {
    //https://leetcode.com/problems/container-with-most-water
    int maxArea(int[] height) {
        int maxArea = 0;
        for (int left = 0, right = height.length - 1; left < right; ) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return maxArea;
    }
}
