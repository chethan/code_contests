package leetcode.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

public class GasStationsTest {

    @Test
    public void testCanCompleteCircuit() {
        GasStations gasStations = new GasStations();
        assertThat(gasStations.canCompleteCircuit(new int[]{1, 2, 3, 4, 5},
            new int[]{3, 4, 5, 1, 2})).isEqualTo(3);
        assertThat(gasStations.canCompleteCircuit(new int[]{1, 2, 3, 4, 5},
            new int[]{3, 4, 5, 3, 2})).isEqualTo(-1);
        assertThat(gasStations.canCompleteCircuit(new int[]{1, 2, 3, 4, 10},
            new int[]{3, 4, 5, 5, 2})).isEqualTo(4);
    }
}