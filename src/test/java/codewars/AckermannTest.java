package codewars;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by Chethan on 8/20/15.
 */
public class AckermannTest {
    @Test
    public void shouldWork() {
        assertEquals(3, new Ackermann().ackermann(1, 1));
        assertEquals(13, new Ackermann().ackermann(4, 0));
    }
}