package learning.interview.primitives;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SetBitsCounterTest {

    private SetBitsCounter setBitsCounter;

    @BeforeMethod
    public void setUp() {
        setBitsCounter = new SetBitsCounter();
    }

    @Test
    public void testCountIterative() {
        assertThat(setBitsCounter.countIterative(0)).isSameAs(0);
        assertThat(setBitsCounter.countIterative(-1)).isSameAs(32);
        assertThat(setBitsCounter.countIterative(Integer.MAX_VALUE)).isSameAs(31);
    }

    @Test
    public void testCountRecur() {
        assertThat(setBitsCounter.countRecur(0)).isSameAs(0);
        assertThat(setBitsCounter.countRecur(-1)).isSameAs(32);
        assertThat(setBitsCounter.countRecur(Integer.MAX_VALUE)).isSameAs(31);
    }

    @Test
    public void testCountBetter() {
        assertThat(setBitsCounter.countBetter(0)).isSameAs(0);
        assertThat(setBitsCounter.countBetter(-1)).isSameAs(32);
        assertThat(setBitsCounter.countBetter(Integer.MAX_VALUE)).isSameAs(31);
        assertThat(setBitsCounter.countBetter(Integer.MIN_VALUE)).isSameAs(1);
    }
    @Test
    public void testCountTill() {
        assertThat(setBitsCounter.countTill(0)).containsOnly(0);
        assertThat(setBitsCounter.countTill(10)).containsOnly(0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2);
    }
}