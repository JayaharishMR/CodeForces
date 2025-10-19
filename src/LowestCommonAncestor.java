import model.TreeNode;

public class LowestCommonAncestor {
    public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode l = LCA(root.left, p, q);
        TreeNode r = LCA(root.right, p,q);
        if (l==null) {
            return r;
        } else if (r == null) {
            return l;
        } else {
            return root;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(4);
        TreeNode left1 = new TreeNode(5);
        TreeNode right = new TreeNode(1);
        root.left = left;
        root.right = right;
        LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();
        TreeNode result = lowestCommonAncestor.LCA(root, left, right);
        System.out.println(result.val);
    }
}
