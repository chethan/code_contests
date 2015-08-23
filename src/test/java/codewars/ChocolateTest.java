package codewars;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by Chethan on 8/19/15.
 */
public class ChocolateTest {

    @Test
    public void testBreakChocolate() throws Exception {
        assertEquals(new Chocolate().breakChocolate(5, 5) , 24);
        assertEquals(new Chocolate().breakChocolate(1, 1) , 0);

    }
}