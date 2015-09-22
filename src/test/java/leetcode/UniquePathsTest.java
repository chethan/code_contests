package leetcode;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 9/22/15.
 */
public class UniquePathsTest {

    @Test
    public void testUniquePaths() throws Exception {
        UniquePaths uniquePaths = new UniquePaths();
        assertThat(uniquePaths.uniquePaths(3,7)).isEqualTo(28);
        int grid [][]=  {{0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}};

        assertThat(uniquePaths.uniquePathsWithObstacles(grid)).isEqualTo(2);
    }
}
