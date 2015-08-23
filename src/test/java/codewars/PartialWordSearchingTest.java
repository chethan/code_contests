package codewars;

import org.junit.Assert;
import org.testng.annotations.Test;

/**
 * Created by Chethan on 8/19/15.
 */
public class PartialWordSearchingTest {
    @Test
    public void test() {
        String[] test1 = {"lemonade", "limeade", "Yoo-Hoo", "root beer", "grapeade ", "water", "Mr. Pibb"};
        String[] test1results = {"lemonade", "limeade", "grapeade "};
        String[] test2results = {"Tin + Oxygen", "lox"};
        String[] test3results = {"Empty"};
        Assert.assertArrayEquals(test1results, new PartialWordSearching().findWord("ade", test1));
        String[] test2 = new String[320];
        for (int i = 0; i < 320; i++){ test2[i] = "o x"; }
        test2[303] = "lox";
        test2[70] = "Tin + Oxygen";
        Assert.assertArrayEquals(test2results, new PartialWordSearching().findWord("ox", test2));
        Assert.assertArrayEquals(test3results, new PartialWordSearching().findWord("   ", test1));
    }
}