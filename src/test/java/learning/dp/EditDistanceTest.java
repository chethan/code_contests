package learning.dp;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 9/21/15.
 */
public class EditDistanceTest {

    //FOOD
    //MONEY

    @Test
    public void testMinDistance() throws Exception {
        EditDistance editDistance = new EditDistance();
        assertThat(editDistance.minDistance("FOOD", "MONEY")).isEqualTo(4);
    }
}
