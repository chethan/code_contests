package learning.dp;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 9/21/15.
 */
public class KnapsackTest {

    @Test
    public void testMaxInKnapsack() throws Exception {
        Knapsack knapsack = new Knapsack();
        assertThat(knapsack.maxInKnapsack(50, new int[]{10, 20, 30},new int[]{60, 100, 120})).
                isEqualTo(300);
    }
}
