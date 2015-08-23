package codewars;

import java.util.stream.Stream;

/**
 * Created by Chethan on 8/21/15.
 */
public class PascalsTriangle {
    public static int[][] pascal(int depth) {
        return Stream.iterate(new int[]{1}, PascalsTriangle::nextPascalRow).limit(depth).toArray(int[][]::new);
    }


    public static int[] nextPascalRow(int[] row){
        int[] nextRow = new int[row.length+1];
        nextRow[0]=nextRow[nextRow.length-1]=1;
        for (int i = 0; i < row.length-1; i++) {
            nextRow[i+1]=row[i]+row[i+1];
        }
        return nextRow;
    }
}
