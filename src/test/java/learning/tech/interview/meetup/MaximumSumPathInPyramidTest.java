package learning.tech.interview.meetup;

import org.testng.annotations.Test;

import static org.assertj.core.api.StrictAssertions.assertThat;

/**
 * Created by Chethan on 3/19/16.
 */
public class MaximumSumPathInPyramidTest {

    @Test
    public void testFindMaximumSum() throws Exception {
        MaximumSumPathInPyramid maximumSumPathInPyramid = new MaximumSumPathInPyramid();
        assertThat(maximumSumPathInPyramid.findMaximumSum(new int[][]{{55},
                {94, 48},
                {95, 30, 96},
                {77, 71, 26, 67},
        })).isEqualTo(321);
        assertThat(maximumSumPathInPyramid.findMaximumSum(new int[][]{{8},
                {6, 4},
                {3, 5, 15},
                {8, 5, 3, 10},
        })).isEqualTo(37);
        assertThat(maximumSumPathInPyramid.findMaximumSum(new int[][]{{8},
                {0, 4},
                {5, 5, 5},
                {8, 8, 3, 4},
                {1, 5, 6, 7, 8},
        })).isEqualTo(31);
    }
}
