package codewars;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Chethan on 8/26/16.
 */
public class ScrambliesTest {
    @Test
    public void test() {
        System.out.println("Fixed Tests scramble");
        Assert.assertEquals(Scramblies.isScramblie("rkqodlw", "world"), true);
        Assert.assertEquals(Scramblies.isScramblie("cedewaraaossoqqyt", "codewars"), true);
        Assert.assertEquals(Scramblies.isScramblie("katas", "steak"), false);
        Assert.assertEquals(Scramblies.isScramblie("scriptjavx", "javascript"), false);
        Assert.assertEquals(Scramblies.isScramblie("scriptingjava", "javascript"), true);
        Assert.assertEquals(Scramblies.isScramblie("scriptsjava", "javascripts"), true);
        Assert.assertEquals(Scramblies.isScramblie("javscripts", "javascript"), false);
        Assert.assertEquals(Scramblies.isScramblie("aabbcamaomsccdd", "commas"), true);
        Assert.assertEquals(Scramblies.isScramblie("commas", "commas"), true);
        Assert.assertEquals(Scramblies.isScramblie("sammoc", "commas"), true);
    }
}
