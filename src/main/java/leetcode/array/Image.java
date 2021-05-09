package leetcode.array;

public class Image {

    //https://leetcode.com/problems/rotate-image/
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reflect(matrix);

    }

    private void transpose(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    private void reflect(int[][] matrix) {
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = 0; j < matrix.length; j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[j][matrix.length - i - 1];
                matrix[j][matrix.length - i - 1] = temp;
            }
        }
    }
}
