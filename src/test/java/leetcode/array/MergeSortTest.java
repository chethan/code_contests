package leetcode.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

public class MergeSortTest {

    @Test
    public void testCountSmallerNumbersAfterSelf() {
        MergeSort mergeSort = new MergeSort();
        assertThat(mergeSort.countSmaller(new int[]{5, 2, 6, 1})).containsExactly(2, 1, 1, 0);
        assertThat(mergeSort.countSmaller(new int[]{1, 2, 5, 6})).containsExactly(0, 0, 0, 0);
        assertThat(mergeSort.countSmaller(new int[]{6, 5, 2, 1})).containsExactly(3, 2, 1, 0);
        assertThat(mergeSort.countSmaller(new int[]{5, 5, 5, 5})).containsExactly(0, 0, 0, 0);

    }
}