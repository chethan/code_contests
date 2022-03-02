package leetcode.array;

//https://leetcode.com/problems/toeplitz-matrix/
public class ToeplitzMatrix {

    //check the top left element
    public boolean isToeplitzMatrix(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (r > 0 && c > 0 && matrix[r - 1][c - 1] != matrix[r][c]) {
                    return false;
                }
            }
        }
        return true;
    }
    //What if the matrix is stored on disk, and the memory is limited such that you can only
    // load at most one row of the matrix into the memory at once?
    //What if the matrix is so large that you can only
    // load up a partial row into the memory at once?
    // Matrix can be split into smaller matrices with one col overlap

    public boolean isToeplitzMatrixFollowUp(int[][] matrix) {
        int[] buffer = new int[matrix[0].length];
        for (int r = 1; r < matrix.length; r++) {
            //load buffer with row r
            for (int c = 0; c < matrix[0].length; c++) {
                buffer[c] = loadFromDisk(matrix, r - 1, c);
            }
            for (int c = 1; c < matrix[0].length; c++) {
                buffer[matrix[0].length - 1] = loadFromDisk(matrix, r, c);
                if (buffer[c - 1] != buffer[matrix[0].length - 1]) {
                    return false;
                }
            }
        }
        return true;
    }

    int loadFromDisk(int[][] matrix, int r, int c) {
        return matrix[r][c];
    }
}
