package learning.interview.arrays;

import java.util.Arrays;

class JumpGame {
    // https://leetcode.com/problems/jump-game/
    boolean canJump(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0 || (i == nums.length - 1)) {
                continue;
            }
            boolean canJump = false;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] > (i - j)) {
                    canJump = true;
                    break;
                }
            }
            if (!canJump) return false;

        }
        return true;
    }

    boolean canJumpSmart(int[] nums) {
        int maxJump = 0, finalPoint = nums.length - 1;
        for (int i = 0; i <= maxJump && maxJump < finalPoint; i++) {
            maxJump = Math.max(maxJump, i + nums[i]);
        }
        return maxJump >= finalPoint;
    }

    int jump(int[] nums) {
        int maxJump = 0, finalPoint = nums.length - 1, jumps = 0, currentEnd = 0;
        for (int i = 0; i < finalPoint; i++) {
            maxJump = Math.max(maxJump, i + nums[i]);
            if (i == currentEnd) {
                jumps++;
                currentEnd = maxJump;
            }
        }
        return maxJump >= finalPoint ? jumps : 0;
    }
}
