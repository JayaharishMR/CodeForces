import model.TreeNode;

public class MaxDepthTreeNode {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left),  maxDepth(root.right))+1;
    }
    public static void main (String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(4);
        TreeNode left1 = new TreeNode(5);
        root.left = left;
        left.left = left1;
        MaxDepthTreeNode maxDepthTreeNode = new MaxDepthTreeNode();
        System.out.println(maxDepthTreeNode.maxDepth(root));
    }
}
