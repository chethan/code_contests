package learning.interview;

import leetcode.array.ChampagneFountain;
import org.testng.annotations.Test;

import static org.assertj.core.api.StrictAssertions.assertThat;

/**
 * Created by Chethan on 9/19/15.
 */
public class ChampagneFountainTest {

    @Test
    public void testGetChampagneIn() throws Exception {
        ChampagneFountain ChampagneFountain = new ChampagneFountain();
        assertThat(ChampagneFountain.getChampagneIn(2, 2)).isEqualTo(0.5);
        assertThat(ChampagneFountain.getChampagneIn(5, 5)).isEqualTo(1.0);
        assertThat(ChampagneFountain.getChampagneIn(7, 8)).isEqualTo(0.5);
        assertThat(ChampagneFountain.getChampagneIn(7, 7)).isEqualTo(0.0);
    }


}
