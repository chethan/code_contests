package codewars;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by Chethan on 8/20/15.
 */
public class PersistTest {

    @Test
    public void testName() throws Exception {
        System.out.println("****** Basic Tests ******");
        assertEquals(3, new Persist().persistence(39));
        assertEquals(0, new Persist().persistence(4));
        assertEquals(2, new Persist().persistence(25));
        assertEquals(4, new Persist().persistence(999));
    }
}