package learning.interview.numbers;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.*;

public class ClockTest {

    @Test
    public void testLargestTimeFromDigits() {
        Clock clock = new Clock();
        assertThat(clock.largestTimeFromDigits(new int[]{1, 2, 3, 4})).isEqualTo("23:41");
        assertThat(clock.largestTimeFromDigits(new int[]{1, 2, 0, 4})).isEqualTo("21:40");
        assertThat(clock.largestTimeFromDigits(new int[]{9, 5, 0, 4})).isEqualTo("09:54");
        assertThat(clock.largestTimeFromDigits(new int[]{5, 5, 5, 5})).isEqualTo("");
        assertThat(clock.largestTimeFromDigits(new int[]{0, 0, 0, 0})).isEqualTo("00:00");

    }
}