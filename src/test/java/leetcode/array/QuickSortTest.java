package leetcode.array;

import static org.assertj.core.api.Assertions.assertThat;

import leetcode.heap.ClosestPointToOrigin;
import org.assertj.core.api.StrictAssertions;
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

    @Test
    public void testKClosestPointToOrigin() {
        QuickSort closestPointToOrigin = new QuickSort();
        assertThat(closestPointToOrigin.kClosest(new int[][]{{1, 3}, {-2, 2}}, 1))
            .containsExactly(new int[]{-2, 2});
    }

}