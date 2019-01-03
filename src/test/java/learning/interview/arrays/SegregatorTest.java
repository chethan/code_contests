package learning.interview.arrays;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.*;

public class SegregatorTest {

    @Test
    public void testEvenOdd() {
        Segregator segregator = new Segregator();
        assertThat(segregator.evenOdd(new int[]{12, 24, 45, 9, 8, 10, 3})).containsExactly(12, 24, 10, 8, 9, 3, 45);
        assertThat(segregator.evenOdd(new int[]{12, 24, 8, 10})).containsExactly(12, 24, 8,10);
        assertThat(segregator.evenOdd(new int[]{7,9,3})).containsExactly(9,3,7);
        assertThat(segregator.evenOdd(new int[]{2})).containsExactly(2);
        assertThat(segregator.evenOdd(new int[]{})).isEmpty();

    }

    @Test
    public void testColors() {
        Segregator segregator = new Segregator();
        assertThat(segregator.colors(new int[]{2,0,1})).containsExactly(0,1,2);
        assertThat(segregator.colors(new int[]{1,0,2})).containsExactly(0,1,2);
        assertThat(segregator.colors(new int[]{1,2,0})).containsExactly(0,1,2);
        assertThat(segregator.colors(new int[]{2,0,2,1,1,0})).containsExactly(0,0,1,1,2,2);
        assertThat(segregator.colors(new int[]{0,1})).containsExactly(0,1);
        assertThat(segregator.colors(new int[]{})).isEmpty();
        assertThat(segregator.colors(new int[]{2})).containsExactly(2);
        assertThat(segregator.colors(new int[]{2,2,2,2,2,2})).containsExactly(2,2,2,2,2,2);
    }
}