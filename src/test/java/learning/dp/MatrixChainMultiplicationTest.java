package learning.dp;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 10/3/15.
 */
public class MatrixChainMultiplicationTest {

    @Test
    public void testMinimumMultiplications() throws Exception {
        MatrixChainMultiplication multiplication = new MatrixChainMultiplication();
        assertThat(multiplication.minimumMultiplications(new int[]{40, 20, 30, 10, 30})).isEqualTo(26000);
        assertThat(multiplication.minimumMultiplications(new int[]{10, 20, 30, 40, 30})).isEqualTo(30000);
        assertThat(multiplication.minimumMultiplications(new int[]{10, 20, 30})).isEqualTo(6000);
    }

    @Test
    public void testMinimumSmoke() throws Exception {
        MatrixChainMultiplication multiplication = new MatrixChainMultiplication();
        assertThat(multiplication.minimumSmoke(new int[]{40, 60, 20})).isEqualTo(2400);
        assertThat(multiplication.minimumSmoke(new int[]{18,19})).isEqualTo(342);
        assertThat(multiplication.minimumSmoke(new int[]{1,2,3,4})).isEqualTo(35);
        assertThat(multiplication.minimumSmoke(new int[]{1,2,3,4,5,6,7,8})).isEqualTo(546);
        assertThat(multiplication.minimumSmoke(new int[]{90,10,80,20,10})).isEqualTo(2500);
    }
}
