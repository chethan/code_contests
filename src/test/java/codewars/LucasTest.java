package codewars;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by Chethan on 8/20/15.
 */
public class LucasTest {
    @Test
    public void test_lucasnum() throws Exception{
        assertEquals(2,new Lucas().lucasnum(0));
        assertEquals(1,new Lucas().lucasnum(1));
        assertEquals(-11,new Lucas().lucasnum(-5));
        assertEquals(123,new Lucas().lucasnum(-10));
    }
}