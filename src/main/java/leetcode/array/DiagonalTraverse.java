package leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiagonalTraverse {

    // diagonals have same sum of row index and col index
    // Time O(M*N) , Space O(M*N) where M and N are rowLength and colLength
    public int[] findDiagonalOrder(int[][] mat) {
        int row = mat.length, col = mat[0].length;
        int totalDiagonals = row + col - 1;
        int[] result = new int[row * col];
        Map<Integer, List<Integer>> countMap = new HashMap<>();
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                countMap.putIfAbsent(r + c, new ArrayList<>());
                countMap.get(r + c).add(mat[r][c]);
            }
        }
        int index = 0;
        for (int i = 0; i < totalDiagonals; i++) {
            List<Integer> diagonal = countMap.get(i);
            for (int j = 0; j < diagonal.size(); j++) {
                result[index++] =
                    i % 2 == 1 ? diagonal.get(j) : diagonal.get(diagonal.size() - j - 1);
            }
        }
        return result;
    }
}
