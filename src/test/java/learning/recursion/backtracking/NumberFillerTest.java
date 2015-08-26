package learning.recursion.backtracking;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 8/25/15.
 */
public class NumberFillerTest {

    @Test
    public void shouldFillSlots(){
        assertThat(new NumberFiller().fill(2)).isEmpty();
        assertThat(new NumberFiller().fill(4).get()).contains(4, 1, 3, 1, 2, 4, 3, 2);
        assertThat(new NumberFiller().fill(3).get()).contains(3, 1, 2, 1, 3, 2);

    }

}