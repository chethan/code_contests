package leetcode;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 9/19/16.
 */
public class DuplicateFinder2Test {

    @Test
    public void testContainsNearbyDuplicate() throws Exception {
        DuplicateFinder2 duplicateFinder2 = new DuplicateFinder2();
        assertThat(duplicateFinder2.containsNearbyDuplicate(new int[]{},0)).isFalse();
        assertThat(duplicateFinder2.containsNearbyDuplicate(new int[]{2,3,4,5,3},3)).isTrue();
        assertThat(duplicateFinder2.containsNearbyDuplicate(new int[]{2,3,4,5,3},2)).isFalse();
    }
}
