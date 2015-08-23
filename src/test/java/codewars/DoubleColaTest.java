package codewars;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by Chethan on 8/22/15.
 */
public class DoubleColaTest {
    @Test
    public void test1() {
        String[] names = new String[] { "Sheldon", "Leonard", "Penny", "Rajesh", "Howard" };
        int n = 1;
        assertEquals("Sheldon", DoubleCola.WhoIsNext(names, n));
    }
    @Test
    public void test2() {
        String[] names = new String[] { "Sheldon", "Leonard", "Penny", "Rajesh", "Howard" };
        int n = 6;
        assertEquals("Sheldon", DoubleCola.WhoIsNext(names, n));
    }

}