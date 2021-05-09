package leetcode.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

public class CarPoolingTest {

    @Test
    public void testCarPooling() {
        CarPooling carPooling = new CarPooling();
        assertThat(carPooling.carPooling(new int[][]{{2, 1, 5}, {3, 3, 7}, {2, 4, 7}}, 5)).isFalse();
        assertThat(carPooling.carPooling(new int[][]{{2, 1, 5}, {3, 3, 7}, {2, 5, 7}}, 5)).isTrue();
    }
    @Test
    public void testCarPoolingWithBucketSort() {
        CarPooling carPooling = new CarPooling();
        assertThat(carPooling.carPoolingWithBucketSort(new int[][]{{2, 1, 5}, {3, 3, 7}, {2, 4, 7}}, 5)).isFalse();
        assertThat(carPooling.carPoolingWithBucketSort(new int[][]{{2, 1, 5}, {3, 3, 7}, {2, 5, 7}}, 5)).isTrue();
    }
}