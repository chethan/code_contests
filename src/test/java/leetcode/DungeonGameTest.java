package leetcode;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 9/21/15.
 */
public class DungeonGameTest {

    @Test
    public void testCalculateMinimumHP() throws Exception {
        DungeonGame dungeonGame = new DungeonGame();
        int dungeon [][]=  {{-2, -3, 3},
                            {-5, -10, 1},
                            {10, 30, -5}};
        assertThat(dungeonGame.calculateMinimumHP(dungeon)).isEqualTo(7);
    }
}
