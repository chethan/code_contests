package leetcode;

/**
 * Created by Chethan on 9/21/15.
 */
// https://leetcode.com/problems/dungeon-game/
public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        int width = dungeon[0].length;
        int height = dungeon.length;
        int[][] minimumHP = new int[height][width];
        minimumHP[height - 1][width - 1] = Math.max(1 - dungeon[height - 1][width - 1], 1);

        for (int i = width - 2; i >= 0; i--) {
            minimumHP[height - 1][i] = Math.max(minimumHP[height - 1][i + 1] - dungeon[height - 1][i], 1);
        }
        for (int j = height - 2; j >= 0; j--) {
            minimumHP[j][width - 1] = Math.max(minimumHP[j + 1][width - 1] - dungeon[j][width - 1], 1);
        }

        for (int i = height - 2; i >= 0; i--) {
            for (int j = width - 2; j >= 0; j--) {
                int down = Math.max(minimumHP[i + 1][j] - dungeon[i][j], 1);
                int right = Math.max(minimumHP[i][j + 1] - dungeon[i][j], 1);
                minimumHP[i][j] = Math.min(down, right);
            }
        }
        return minimumHP[0][0];
    }
}
