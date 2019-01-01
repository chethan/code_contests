package learning.interview.numbers;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.*;

public class RectanglesTest {

    @Test
    public void testIsRectangleOverlap() {
        Rectangles rectangles = new Rectangles();
        assertThat(rectangles.isRectangleOverlap(new int[]{0,0,2,2},new int[]{1,1,3,3} )).isTrue();
        assertThat(rectangles.isRectangleOverlap(new int[]{0,0,1,1},new int[]{1,1,3,3} )).isFalse();
        assertThat(rectangles.isRectangleOverlap(new int[]{0,0,5,5},new int[]{2,2,3,3} )).isTrue();
        assertThat(rectangles.isRectangleOverlap(new int[]{0,0,5,5},new int[]{0,0,5,5} )).isTrue();
        assertThat(rectangles.isRectangleOverlap(new int[]{-6,-10,9,2},new int[]{0,5,4,8} )).isFalse();

    }
    @Test
    public void testIsRectangleIntersectingArea() {
        Rectangles rectangles = new Rectangles();
        assertThat(rectangles.computeArea(-1500000001,0,-1500000000,
                1,1500000000,0,1500000001,1)).isEqualTo(2);
        assertThat(rectangles.computeArea(-3,0,3,
                4,0,-1,9,2)).isEqualTo(45);

    }
}