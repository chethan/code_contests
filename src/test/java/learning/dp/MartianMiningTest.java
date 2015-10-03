package learning.dp;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 10/2/15.
 */
public class MartianMiningTest {

    @Test
    public void testMine() throws Exception {
        MartianMining martianMining = new MartianMining();
        int bloggium[][] = {{10, 0, 0, 0},
                {1, 1, 1, 30},
                {0, 0, 5, 5},
                {5, 10, 10, 10}};
        int yeyenum[][] = {{0, 0, 10, 9},
                {1, 3, 10, 0},
                {4, 2, 1, 3},
                {1, 1, 20, 0}};

        assertThat(martianMining.mine(bloggium, yeyenum)).isEqualTo(98);
        assertThat(martianMining.mineOptimized(bloggium, yeyenum)).isEqualTo(98);
    }
}
