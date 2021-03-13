package leetcode.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

public class ArrayIntersectionTest {

    @Test
    public void testIntersectionOfUnSortedArrays() {
        ArrayIntersection arrayIntersection = new ArrayIntersection();
        assertThat(arrayIntersection.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2}))
            .containsExactly(2);
        assertThat(arrayIntersection.intersection(new int[]{1, 2, 2, 1}, new int[]{3, 4}))
            .containsExactly();
        assertThat(arrayIntersection.intersection(new int[]{}, new int[]{3, 4}))
            .containsExactly();
    }

    @Test
    public void testIntersectionOfUnSortedArraysWithDuplicates() {
        ArrayIntersection arrayIntersection = new ArrayIntersection();
        assertThat(arrayIntersection.intersectionWithDuplicates(new int[]{1, 2, 2, 1}, new int[]{2, 2}))
            .containsExactly(2,2);
        assertThat(arrayIntersection.intersectionWithDuplicates(new int[]{1, 2, 2, 1}, new int[]{3, 4}))
            .containsExactly();
        assertThat(arrayIntersection.intersectionWithDuplicates(new int[]{}, new int[]{3, 4}))
            .containsExactly();
    }

    @Test
    public void testIntersectionOfSortedArrays() {
        ArrayIntersection arrayIntersection = new ArrayIntersection();
        assertThat(arrayIntersection.intersectionOfSortedArrays(new int[]{1, 2,2, 2, 3}, new int[]{2, 2,2}))
            .containsExactly(2);
        assertThat(
            arrayIntersection.intersectionOfSortedArrays(new int[]{1, 2, 2, 3, 4, 4}, new int[]{2, 2, 3, 3, 4}))
            .containsExactly(2, 3, 4);
    }
}