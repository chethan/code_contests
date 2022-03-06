package leetcode.array;

import java.util.List;

public class LeftMostColumn {

    //Time: O(MLogN)  M rows N columns
    //Space: O(1)
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimension = binaryMatrix.dimensions();
        int rowSize = dimension.get(0), colSize = dimension.get(1);
        int minIndex = colSize;
        for (int i = 0; i < rowSize; i++) {
            int index = binarySearch(binaryMatrix, i, 0, minIndex - 1);
            if (index != -1) {
                minIndex = index;
            }
        }
        return minIndex == colSize ? -1 : minIndex;
    }

    //Start at Top Right, Move Only Left and Down
    //Time: O(N)
    //Space: O(1)
    public int leftMostColumnWithOneOptimized(BinaryMatrix binaryMatrix) {
        List<Integer> dimension = binaryMatrix.dimensions(

        );
        int rowSize = dimension.get(0), colSize = dimension.get(1);
        int index = -1, row = 0, col = colSize - 1;
        while (row < rowSize && col >= 0) {
            int value = binaryMatrix.get(row, col);
            if (value == 1) {
                index = col;
                col--;
            } else {
                row++;
            }
        }
        return index;

    }

    int binarySearch(BinaryMatrix binaryMatrix, int row, int lo, int hi) {
        int candidate = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int midElement = binaryMatrix.get(row, mid);
            if (midElement == 1) {
                candidate = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return candidate;
    }

    interface BinaryMatrix {

        int get(int row, int col);

        List<Integer> dimensions();
    }
}
