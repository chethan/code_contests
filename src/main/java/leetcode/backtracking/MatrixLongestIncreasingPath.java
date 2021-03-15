package leetcode.backtracking;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
public class MatrixLongestIncreasingPath {
    public int longestIncreasingPath(int[][] matrix) {
        Map<String,Integer> cache = new HashMap<>();
        if(matrix.length==0){
            return 0;
        }
        int longestPath = -1;
        for(int row=0;row<matrix.length;row++){
            for(int col=0;col<matrix[0].length;col++){
                int path= bfs(matrix,row,col,-1,cache);
                longestPath=Math.max(path,longestPath);
            }
        }
        return longestPath;
    }

    private int bfs(int[][] matrix,int row, int col,int previousValue,Map<String,Integer> cache){
        int rowLength = matrix.length;
        int colLength = matrix[0].length;

        if(row<0 || row >= rowLength || col< 0  || col>=colLength
            || matrix[row][col] <= previousValue || matrix[row][col]== -1){
            return 0;
        }

        if(cache.containsKey(row+"_"+col)){
            return cache.get(row+"_"+col);
        }
        int currentValue =matrix[row][col];
        matrix[row][col]= -1;
        int[][] directions = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};

        int longestPath = -1;
        for(int[] direction:directions){
            int nextRow = row +  direction[0];
            int nextCol = col +  direction[1];
            longestPath = Math.max(bfs(matrix,nextRow,nextCol,currentValue,cache),longestPath);
        }

        matrix[row][col]=currentValue;
        cache.put(row+"_"+col,longestPath + 1);
        return longestPath + 1;
    }
}
