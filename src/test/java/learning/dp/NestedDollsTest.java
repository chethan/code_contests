package learning.dp;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 10/4/15.
 */
public class NestedDollsTest {

    @Test
    public void testMinimumDolls() throws Exception {
        NestedDolls nestedDolls = new NestedDolls();
        assertThat(nestedDolls.minimumDolls(new Tuple[]{
                new Tuple(10, 30), new Tuple(20, 20), new Tuple(30, 10)
        })).isEqualTo(3);
        assertThat(nestedDolls.minimumDolls(new Tuple[]{
                new Tuple(20, 30), new Tuple(40, 50), new Tuple(30, 40)
        })).isEqualTo(1);
        assertThat(nestedDolls.minimumDolls(new Tuple[]{
                new Tuple(20, 30), new Tuple(10, 10), new Tuple(30, 20),new Tuple(40,50)
        })).isEqualTo(2);
        assertThat(nestedDolls.minimumDolls(new Tuple[]{
                new Tuple(20, 30), new Tuple(10, 10), new Tuple(30, 20),new Tuple(40,50),new Tuple(31,21)
        })).isEqualTo(2);
    }
}
