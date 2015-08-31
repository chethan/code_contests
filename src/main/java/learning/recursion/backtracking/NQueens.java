package learning.recursion.backtracking;

import ds.Grid;

import java.util.stream.IntStream;

/**
 * Created by Chethan on 8/31/15.
 */
public class NQueens {
    public Grid<Boolean> place(int size) {
        Grid<Boolean> grid = new Grid<>(size, size);
        grid.onAll((r, c) -> grid.set(r, c, Boolean.FALSE));
        return place(grid, size, 0);
    }

    private Grid<Boolean> place(Grid<Boolean> grid, int size, int row) {
        if (row >= size) return null;
        for (int i = 0; i < size; i++) {
            boolean rowFree = grid.getRow(row).stream().noneMatch(b -> b);
            boolean columnFree = grid.getCol(i).stream().noneMatch(b -> b);
            boolean diagonalFree = grid.getDiagonal(row, i).stream().noneMatch(b -> b);
            if (rowFree && columnFree && diagonalFree) {
                grid.set(row, i, Boolean.TRUE);
                if (allPlaced(grid, size) || place(grid, size, row + 1) != null) {
                    return grid;
                }
                grid.set(row, i, Boolean.FALSE);
            }
        }
        return null;
    }

    private boolean allPlaced(Grid<Boolean> grid, int size) {
        return IntStream.range(0, size).mapToObj(value -> grid.getRow(value).stream().
                anyMatch(b -> b)).filter(b -> b).count() == size;
    }
}
