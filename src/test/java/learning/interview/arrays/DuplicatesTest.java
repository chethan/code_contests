package learning.interview.arrays;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DuplicatesTest {
    @Test
    public void testRemoveDuplicates() {
        Duplicates duplicates = new Duplicates();
        assertThat(duplicates.removeDuplicates(new int[]{2, 2, 2, 2})).isEqualTo(1);
        assertThat(duplicates.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4})).isEqualTo(5);
    }

    @Test
    public void testRemoveDuplicatesAppearingMoreThanTwice() {
        Duplicates duplicates = new Duplicates();
        assertThat(duplicates.removeDuplicatesAppearingMoreThanTwice(new int[]{2, 2, 2, 2})).isEqualTo(2);
        assertThat(duplicates.removeDuplicatesAppearingMoreThanTwice(new int[]{1,1,1,2,2,3})).isEqualTo(5);
        assertThat(duplicates.removeDuplicatesAppearingMoreThanTwice(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4})).isEqualTo(9);
        assertThat(duplicates.removeDuplicatesAppearingMoreThanTwice(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3})).isEqualTo(7);
    }

    @Test
    public void testRemoveElement() {
        Duplicates duplicates = new Duplicates();
        assertThat(duplicates.removeElement(new int[]{3, 2, 2, 3}, 3)).isEqualTo(2);
        assertThat(duplicates.removeElement(new int[]{2, 2, 2, 2}, 2)).isEqualTo(0);
        assertThat(duplicates.removeElement(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}, 3)).isEqualTo(8);
    }

    @Test
    public void testMoveZeros() {
        Duplicates duplicates = new Duplicates();
        assertThat(duplicates.moveZeros(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4})).containsExactly(1, 1, 1, 2, 2, 3, 3, 4, 0, 0);
        assertThat(duplicates.moveZeros(new int[]{1, 0, 3, 12, 0})).containsExactly(1, 3, 12, 0, 0);
        assertThat(duplicates.moveZeros(new int[]{1, 3, 12})).containsExactly(1, 3, 12);
        assertThat(duplicates.moveZeros(new int[]{0})).containsExactly(0);
    }
}