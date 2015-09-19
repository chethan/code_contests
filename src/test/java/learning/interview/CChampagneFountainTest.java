package learning.interview;

import org.testng.annotations.Test;

import static org.assertj.core.api.StrictAssertions.assertThat;

/**
 * Created by Chethan on 9/19/15.
 */
public class CChampagneFountainTest {

    @Test
    public void testGetChampagneIn() throws Exception {
        CChampagneFountain ChampagneFountain = new CChampagneFountain();
        assertThat(ChampagneFountain.getChampagneIn(2, 2)).isEqualTo(0.5);
        assertThat(ChampagneFountain.getChampagneIn(5, 5)).isEqualTo(1.0);
        assertThat(ChampagneFountain.getChampagneIn(7, 8)).isEqualTo(0.5);
        assertThat(ChampagneFountain.getChampagneIn(7, 7)).isEqualTo(0.0);
    }


}
