package leetcode.graph;

//https://leetcode.com/problems/flood-fill/
public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int currentColor = image[sr][sc];
        if (currentColor != newColor) {
            dfs(image, sr, sc, currentColor, newColor);
        }
        return image;
    }

    void dfs(int[][] image, int sr, int sc, int currentColor, int newColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length
            || image[sr][sc] != currentColor) {
            return;
        }
        image[sr][sc] = newColor;
        int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        for (int[] direction : directions) {
            int newSr = sr + direction[0];
            int newSc = sc + direction[1];
            dfs(image, newSr, newSc, currentColor, newColor);
        }
    }
}
