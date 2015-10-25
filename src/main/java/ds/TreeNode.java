package ds;

/**
 * Created by Chethan on 10/20/15.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }

    public static TreeNode.Builder builder(){
        return new Builder();
    }

    public static class Builder {

        private final TreeNode treeNode;

        public Builder() {
            treeNode = new TreeNode();
        }

        public Builder val(int value) {
            treeNode.val = value;
            return this;
        }

        public Builder left(TreeNode value) {
            treeNode.left = value;
            return this;
        }

        public Builder right(TreeNode value) {
            treeNode.right = value;
            return this;
        }

        public TreeNode build() {
            return treeNode;
        }
    }
}
