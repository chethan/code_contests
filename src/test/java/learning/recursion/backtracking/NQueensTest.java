package learning.recursion.backtracking;

import ds.Grid;
import org.testng.annotations.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 8/31/15.
 */
public class NQueensTest {
    @Test
    public void shouldPlaceNQueens() {
        int size = 8;
        Grid<Boolean> booleanGrid = new NQueens().place(size);
        IntStream.range(0, size).forEach(i -> assertThat(booleanGrid.getRow(i)).containsOnlyOnce(Boolean.TRUE));
        IntStream.range(0, size).forEach(i -> assertThat(booleanGrid.getCol(i)).containsOnlyOnce(Boolean.TRUE));
    }

}