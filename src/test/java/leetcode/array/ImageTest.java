package leetcode.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

public class ImageTest {

    @Test
    public void testRotateImage() {
        Image image = new Image();
        int[][] imageMatrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        image.rotate(imageMatrix);
        assertThat(imageMatrix)
            .containsExactly(new int[]{7, 4, 1}, new int[]{8, 5, 2}, new int[]{9, 6, 3});
    }
}