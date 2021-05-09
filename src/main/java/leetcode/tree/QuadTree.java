package leetcode.tree;

public class QuadTree {

    class Node {

        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }

    //https://leetcode.com/problems/construct-quad-tree/
    public Node construct(int[][] grid) {
        if (grid.length == 0) {
            return null;
        }
        return construct(grid, 0, grid.length - 1, 0, grid[0].length - 1);
    }

    private Node construct(int[][] grid, int rowMin, int rowMax, int colMin, int colMax) {
        if (rowMin == rowMax) {
            return new Node(grid[rowMin][colMin] == 1, true);
        }
        int length = rowMax - rowMin + 1;
        int rowMid = rowMin + length / 2;
        int colMid = colMin + length / 2;
        Node topLeft = construct(grid, rowMin, rowMid - 1, colMin, colMid - 1);
        Node topRight = construct(grid, rowMin, rowMid - 1, colMid, colMax);
        Node bottomLeft = construct(grid, rowMid, rowMax, colMin, colMid - 1);
        Node bottomRight = construct(grid, rowMid, rowMax, colMid, colMax);

        Node[] children = new Node[]{topLeft, topRight, bottomLeft, bottomRight};
        boolean val = topLeft.val;
        for (Node child : children) {
            if (!child.isLeaf || child.val != val) {
                return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
            }
        }

        return new Node(val, true);

    }
}
