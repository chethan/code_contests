package leetcode.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

public class QuickSortTest {

    @Test
    public void testFindKthLargestElement() {
        QuickSort quickSort = new QuickSort();
        assertThat(quickSort.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4)).isEqualTo(4);
        assertThat(quickSort.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2)).isEqualTo(5);
    }

    @Test
    public void testFindTopKFrequentElements() {
        QuickSort quickSort = new QuickSort();
        assertThat(quickSort.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)).containsExactly(1, 2);
    }
}