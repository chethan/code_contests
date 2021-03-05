package leetcode.tree;

import ds.TreeNode;

//https://leetcode.com/problems/diameter-of-binary-tree/
public class DiameterOfATree {
    public int diameter(TreeNode root) {
        return maxDepth(root).diameter;
    }

    public TreeMetadata maxDepth(TreeNode node){
        if(node==null) return new TreeMetadata(0, 0);
        TreeMetadata left=maxDepth(node.left);
        TreeMetadata right=maxDepth(node.right);
        int depth= 1 + Math.max(left.depth, right.depth);
        int diameter = Math.max(left.depth+right.depth,
            Math.max(left.diameter,right.diameter));
        return new TreeMetadata(diameter, depth);
    }

    static class TreeMetadata{
        int diameter;
        int depth;

        TreeMetadata(int diameter,int depth){
            this.diameter = diameter;
            this.depth = depth;
        }
    }
}
