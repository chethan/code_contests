package codewars;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by Chethan on 8/21/15.
 */
public class MultipleOf3And5Test {

    @Test
    public void testSolution() throws Exception {
        assertEquals(23, new MultipleOf3And5().solution(10));
    }
}