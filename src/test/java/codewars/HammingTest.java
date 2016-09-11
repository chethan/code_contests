package codewars;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Chethan on 9/10/16.
 */
public class HammingTest {

    @Test
    public void testHamming() throws Exception {
        Assert.assertEquals(1, Hamming.hamming(1));
        Assert.assertEquals(2, Hamming.hamming(2));
        Assert.assertEquals(3, Hamming.hamming(3));
        Assert.assertEquals(4, Hamming.hamming(4));
        Assert.assertEquals(5, Hamming.hamming(5));
        Assert.assertEquals(6, Hamming.hamming(6));
        Assert.assertEquals(8, Hamming.hamming(7));
        Assert.assertEquals(9, Hamming.hamming(8));
        Assert.assertEquals(10, Hamming.hamming(9));
        Assert.assertEquals(12, Hamming.hamming(10));
        Assert.assertEquals(15, Hamming.hamming(11));
        Assert.assertEquals(16, Hamming.hamming(12));
        Assert.assertEquals(18, Hamming.hamming(13));
        Assert.assertEquals(20, Hamming.hamming(14));
        Assert.assertEquals(24, Hamming.hamming(15));
        Assert.assertEquals(25, Hamming.hamming(16));
        Assert.assertEquals(27, Hamming.hamming(17));
        Assert.assertEquals(30, Hamming.hamming(18));
        Assert.assertEquals(32, Hamming.hamming(19));
    }
}
