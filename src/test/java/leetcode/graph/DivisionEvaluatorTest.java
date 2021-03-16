package leetcode.graph;

import static org.assertj.core.api.StrictAssertions.assertThat;

import java.util.List;
import org.testng.annotations.Test;

public class DivisionEvaluatorTest {

    @Test
    public void testCalculatedEquationsOutput() {
        DivisionEvaluator divisionEvaluator = new DivisionEvaluator();
        assertThat(divisionEvaluator.calcEquation(List.of(List.of("a", "b"), List.of("b", "c")),
            new double[]{2.0, 3.0},
            List.of(List.of("a", "c"), List.of("b", "a"), List.of("a", "e"), List.of("a", "a"), List.of("x", "x"))))
            .containsExactly(6.00000,0.50000,-1.00000,1.00000,-1.00000);
    }
}