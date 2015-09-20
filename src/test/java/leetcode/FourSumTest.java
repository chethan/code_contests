package leetcode;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 9/19/15.
 */
public class FourSumTest {

    @Test
    public void testFourSum() throws Exception {
        FourSum fourSum = new FourSum();
        assertThat(fourSum.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0)).hasSize(3);
        assertThat(new FourSumSpecific().fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0)).hasSize(3);
        assertThat(fourSum.fourSum(new int[]{-495,-477,-464,-424,-411,-409,-363,-337,
                -328,-328,-325,-320,-310,-285,-278,-235,-208,-151,-149,-147,-144,
                -132,-115,-107,-101,-98,-83,-58,-58,-56,-51,-46,-45,-7,0,4,
                4,21,51,52,57,60,104,109,124,141,158,205,206,241,278,
                278,291,314,379,416,437,447,452,496}, -1371)).hasSize(9);
    }


}
