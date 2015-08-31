package ds;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Created by Chethan on 8/30/15.
 */
public class Grid<T extends Object> {
    private int totalRows;
    private int totalColumns;
    T[][] gridData;

    public Grid(int row, int column) {
        this.totalRows = row;
        this.totalColumns = column;
        gridData = (T[][]) new Object[row][column];
    }

    public void resetAll() {
        onAll(this::reset);
    }

    public void onAll(BiConsumer<Integer, Integer> func) {
        for (int i = 0; i < totalRows; i++) {
            for (int j = 0; j < totalColumns; j++) {
                func.accept(i, j);
            }
        }
    }

    public List<T> applyOnAll(BiFunction<Integer, Integer, T> func) {
        List<T> list = new ArrayList<>();
        for (int i = 0; i < totalRows; i++) {
            for (int j = 0; j < totalColumns; j++) {
                list.add(func.apply(i, j));
            }
        }
        return list;
    }

    public void set(int row, int column, T value) {
        gridData[row][column] = value;
    }

    public void reset(int row, int column) {
        set(row, column, null);
    }

    public T get(int row, int column) {
        return gridData[row][column];
    }

    public boolean isEmpty(int row, int column) {
        return gridData[row][column] == null;
    }

    public List<T> getCol(int column) {
        return onRow(n -> get(n,column));
    }

    public List<T> onColumn(int column,Function<Integer, T> func) {
        List<T> columns = new ArrayList<>();
        for (int i = 0; i < totalRows; i++) {
            columns.add(func.apply(i));
        }
        return columns;
    }

    public List<T> getRow(int row) {
        return onRow(n -> get(row,n));
    }

    public List<T> onRow(Function<Integer, T> func) {
        List<T> rows = new ArrayList<>();
        for (int i = 0; i < totalColumns; i++) {
            rows.add(func.apply(i));
        }
        return rows;
    }

    public List<T> getDiagonal(int rowNum, int columnNum) {
        List<T> values = new ArrayList<>();
        for (int i = 0; i < totalRows; i++) {
            for (int j = 0; j < totalColumns; j++) {

                if (Math.abs(rowNum - i) == Math.abs(columnNum - j)) {
                    values.add(gridData[i][j]);
                }
            }
        }
        return values;
    }

}
