package leetcode.array;

public class BoundedRobot {

    public boolean isRobotBounded(String instructions) {
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int x = 0, y = 0;
        int direction = 0;
        //robot should return to original position at-least after 4 rounds
        for (int i = 0; i < 4; i++) {
            for (char c : instructions.toCharArray()) {
                if (c == 'R') {
                    direction = (direction + 1) % 4;
                } else if (c == 'L') {
                    direction = (direction + 3) % 4;
                } else {
                    x += directions[direction][0];
                    y += directions[direction][1];
                }

            }
            if (x == 0 && y == 0 && direction == 0) {
                return true;
            }
        }
        return false;

    }
}
