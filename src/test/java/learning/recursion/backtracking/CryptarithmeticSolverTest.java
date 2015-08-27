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
        assertThat(new TreeMap<>(new CryptarithmeticSolver().solve("swathi", "chethan", "talents")).toString()).
                isEqualTo("{a=6, c=2, e=0, h=7, i=8, l=5, n=1, s=9, t=3, w=4}");
    }
}