package leetcode;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 9/19/16.
 */
public class DuplicateFinderTest {

    @Test
    public void testContainsDuplicate() throws Exception {
        DuplicateFinder duplicateFinder = new DuplicateFinder();
        assertThat(duplicateFinder.containsDuplicate(new int[]{1,2,3,4,1})).isTrue();
        assertThat(duplicateFinder.containsDuplicate(new int[]{1,2,3,4})).isFalse();
        assertThat(duplicateFinder.containsDuplicate(new int[]{})).isFalse();
    }
}
