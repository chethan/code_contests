package leetcode.array;

import static org.assertj.core.api.StrictAssertions.assertThat;

import org.testng.annotations.Test;

public class BinarySearchTest {

    @Test
    public void testSearchingFirstAndLastIndex() {
        BinarySearch binarySearch = new BinarySearch();
        assertThat(binarySearch.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)).containsExactly(3, 4);
        assertThat(binarySearch.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6))
            .containsExactly(-1, -1);
        assertThat(binarySearch.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 5))
            .containsExactly(0, 0);
    }

    @Test
    public void testPeakIndexInMountainArray() {
        BinarySearch binarySearch = new BinarySearch();
        assertThat(binarySearch
            .peakIndexInMountainArray(new int[]{24, 69, 100, 99, 79, 78, 67, 36, 26, 19}))
            .isEqualTo(2);
    }

    @Test
    public void testFindingMinValueInRotatedSortedArray() {
        BinarySearch binarySearch = new BinarySearch();
        assertThat(binarySearch.findMinInRotatedArray(new int[]{11, 13, 15, 17})).isEqualTo(11);
        assertThat(binarySearch.findMinInRotatedArray(new int[]{3, 4, 5, 1, 2})).isEqualTo(1);
    }

    @Test
    public void testSearchInRotatedSortedArray() {
        BinarySearch binarySearch = new BinarySearch();
        assertThat(binarySearch.searchInRotatedArray(new int[]{11, 13, 15, 17}, 15)).isEqualTo(2);
        assertThat(binarySearch.searchInRotatedArray(new int[]{3, 4, 5, 1, 2}, 2)).isEqualTo(4);
        assertThat(binarySearch.searchInRotatedArray(new int[]{3, 4, 5, 1, 2}, 3)).isEqualTo(0);
        assertThat(binarySearch.searchInRotatedArray(new int[]{3, 4, 5, 1, 2}, 6)).isEqualTo(-1);

    }
}