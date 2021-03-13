package leetcode;

import org.testng.annotations.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Chethan on 8/9/15.
 */
public class TwoSumTest {

    @Test
    public void shouldReturnCorrectIndexes(){
        TwoSum twoSum = new TwoSum();
        assertArrayEquals(new int[]{0,1}, twoSum.twoSum(new int[]{2, 7, 11, 15}, 9));
        assertArrayEquals(new int[]{0,3}, twoSum.twoSum(new int[]{0,4,3,0}, 0));
        assertArrayEquals(new int[]{1,2}, twoSum.twoSum(new int[]{3,2,4}, 6));
    }

    @Test
    public void testTwoSumForSortedArray(){
        TwoSum twoSum = new TwoSum();
        assertArrayEquals(new int[]{0,1}, twoSum.twoSumSorted(new int[]{2, 7, 11, 15}, 9));
        assertArrayEquals(new int[]{0,1}, twoSum.twoSumSorted(new int[]{0,0,4,3}, 0));
        assertArrayEquals(new int[]{0,2}, twoSum.twoSumSorted(new int[]{2,3,4}, 6));
    }

}
