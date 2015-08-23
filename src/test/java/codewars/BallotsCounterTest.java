package codewars;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by Chethan on 8/19/15.
 */
public class BallotsCounterTest {
    BallotsCounter ballotsCounter = new BallotsCounter();

    @Test
    public void testGetWinner_01() {
        assertThat(ballotsCounter.getWinner(Arrays.asList("A")), is("A"));
    }

    @Test
    public void testGetWinner_02() {
        assertThat(ballotsCounter.getWinner(Arrays.asList("A", "A", "A", "B", "B", "B", "A")), is("A"));
    }

    @Test
    public void testGetWinner_03() {
        assertThat(ballotsCounter.getWinner(Arrays.asList("A", "A", "A", "B", "B", "B")), is(nullValue()));
    }

    @Test
    public void testGetWinner_04() {
        assertThat(ballotsCounter.getWinner(Arrays.asList("A", "A", "A", "B", "C", "B")), is(nullValue()));
    }

    @Test
    public void testGetWinner_05() {
        assertThat(ballotsCounter.getWinner(Arrays.asList("A", "A", "B", "B", "C")), is(nullValue()));
    }
}