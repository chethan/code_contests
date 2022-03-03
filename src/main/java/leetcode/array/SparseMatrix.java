package leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class SparseMatrix {

    //https://leetcode.com/problems/sparse-matrix-multiplication/
    //Time: O(M*K*N) -> M and N are result matrix row and col size,
    // k is col size of first matrix
    //Space: O(1)
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int row = mat1.length;
        int col = mat2[0].length;
        int common = mat2.length;
        int[][] result = new int[row][col];
        for (int r = 0; r < row; r++) {
            for (int k = 0; k < common; k++) {
                if (mat1[r][k] != 0) {
                    for (int c = 0; c < col; c++) {
                        result[r][c] += (mat1[r][k] * mat2[k][c]);
                    }
                }

            }
        }
        return result;
    }

    //if the matrix is too big to store in the memory, but there are
    // only a few non-zero elements. Here, he wants to see how we handle huge space waste. He expects
    // us to store the matrix efficiency and do multiplication using that.
    //Time: O(M*K*N) -> M and N are result matrix row and col size,
    // k is col size of first matrix
    //Space: O(1)
    public int[][] multiplySpaceOptimized(int[][] mat1, int[][] mat2) {
        int row = mat1.length;
        int col = mat2[0].length;
        int[][] result = new int[row][col];
        List<List<Pair>> compressed1 = compress(mat1);
        List<List<Pair>> compressed2 = compress(mat2);
        for (int r = 0; r < row; r++) {
            for (Pair pair1 : compressed1.get(r)) {
                int commonIndex = pair1.col;
                for (Pair pair2 : compressed2.get(commonIndex)) {
                    result[r][pair2.col] += pair1.value * pair2.value;
                }
            }
        }
        return result;
    }

    private List<List<Pair>> compress(int[][] mat) {
        List<List<Pair>> compressed = new ArrayList<>();
        int row = mat.length;
        int col = mat[0].length;
        for (int r = 0; r < row; r++) {
            List<Pair> rows = new ArrayList<>();
            for (int c = 0; c < col; c++) {
                if (mat[r][c] != 0) {
                    rows.add(new Pair(c, mat[r][c]));
                }
            }
            compressed.add(rows);
        }
        return compressed;
    }

    private static class Pair {

        int col;
        int value;

        Pair(int col, int value) {
            this.col = col;
            this.value = value;
        }
    }
}
