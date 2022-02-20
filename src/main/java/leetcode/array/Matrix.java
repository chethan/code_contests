package leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class Matrix {

    //https://leetcode.com/problems/set-matrix-zeroes/
    //Use first col/row as a flag
    public void setZeroes(int[][] matrix) {
        boolean isFirstColZero = false;
        int rowSize = matrix.length;
        int colSize = matrix[0].length;
        for (int i = 0; i < rowSize; i++) {
            if (matrix[i][0] == 0) {
                isFirstColZero = true;
            }
            for (int j = 1; j < colSize; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i = 1; i < rowSize; i++) {
            for (int j = 1; j < colSize; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (matrix[0][0] == 0) {
            for (int i = 0; i < colSize; i++) {
                matrix[0][i] = 0;
            }
        }
        if (isFirstColZero) {
            for (int i = 0; i < rowSize; i++) {
                matrix[i][0] = 0;
            }
        }

    }

    //https://leetcode.com/problems/spiral-matrix/
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiralList = new ArrayList<>();
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int currentDirection = 0, changeDirection = 0;
        int visited = 101;
        spiralList.add(matrix[0][0]);
        matrix[0][0] = visited;
        int row = 0, col = 0;
        while (changeDirection < 2) {
            int newRow = row + directions[currentDirection][0];
            int newCol = col + directions[currentDirection][1];
            boolean isWithinRowLimit = newRow >= 0 && newRow < matrix.length;
            boolean isWithinColLimit = newCol >= 0 && newCol < matrix[0].length;
            while (isWithinRowLimit && isWithinColLimit && matrix[newRow][newCol] != visited) {
                changeDirection = 0;
                row = newRow;
                col = newCol;
                spiralList.add(matrix[row][col]);
                matrix[row][col] = visited;
                newRow = row + directions[currentDirection][0];
                newCol = col + directions[currentDirection][1];
                isWithinRowLimit = newRow >= 0 && newRow < matrix.length;
                isWithinColLimit = newCol >= 0 && newCol < matrix[0].length;

            }
            currentDirection = (currentDirection + 1) % 4;
            changeDirection++;
        }
        return spiralList;
    }
}
