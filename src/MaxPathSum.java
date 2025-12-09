import model.TreeNode;

public class MaxPathSum {
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        sumNode(root);
        return ans;
    }

    public int sumNode(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(sumNode(node.left), 0);
        int right = Math.max(sumNode(node.right), 0);

        int tempSum = node.val + left + right;

        ans = Math.max(tempSum, ans);
        return node.val + Math.max(left, right);
    }
}
