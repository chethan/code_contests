package leetcode.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

public class FruitsIntoBasketTest {

    @Test
    public void testMaxTotalFruits() {
        FruitsIntoBasket fruitsIntoBasket = new FruitsIntoBasket();
        assertThat(fruitsIntoBasket.totalFruit(new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}))
            .isEqualTo(5);
    }
}