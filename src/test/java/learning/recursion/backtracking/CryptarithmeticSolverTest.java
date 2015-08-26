package learning.recursion.backtracking;

import org.testng.annotations.Test;

import java.util.TreeMap;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 8/26/15.
 */
public class CryptarithmeticSolverTest {

    @Test
    public void testSolve() throws Exception {
        assertThat(new TreeMap<>(new CryptarithmeticSolver().solve("SEND", "MORE", "MONEY")).toString()).
                isEqualTo("{D=7, E=5, M=1, N=6, O=0, R=8, S=9, Y=2}");
    }
}