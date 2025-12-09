import model.TreeNode;

public class BuildBinaryTreeFromPreOrderAndInOrder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    public TreeNode helper(int[] preOrder, int preOrderStartingIndex, int preOrderEndingIndex, int[] inOrder, int inOrderStartingIndex, int inOrderEndingIndex) {
        if (preOrderStartingIndex > preOrderEndingIndex || inOrderStartingIndex > preOrderEndingIndex) {
            return null;
        }
        int rootVal = preOrder[preOrderStartingIndex];
        TreeNode node = new TreeNode(rootVal);
        int indexOfRootValInOrder = -1;
        for (int i = inOrderStartingIndex; i <= inOrderEndingIndex; i++) {
            if (inOrder[i] == rootVal) {
                indexOfRootValInOrder = i;
            }
        }
        int leftTreeSize = indexOfRootValInOrder - inOrderStartingIndex;
        node.left = helper(preOrder, preOrderStartingIndex+1, preOrderStartingIndex+leftTreeSize, inOrder, inOrderStartingIndex, indexOfRootValInOrder-1);
        node.right = helper(preOrder, preOrderStartingIndex+leftTreeSize+1, preOrderEndingIndex, inOrder, indexOfRootValInOrder+1, inOrderEndingIndex);
        return node;
    }

    public static void main(String[] args) {
        BuildBinaryTreeFromPreOrderAndInOrder buildBinaryTreeFromPreOrderAndInOrder = new BuildBinaryTreeFromPreOrderAndInOrder();
        int[] preorder = new int[] {3,9,20,15,7};
        int[] inorder = new int[] {9,3,15,20,7};
        buildBinaryTreeFromPreOrderAndInOrder.buildTree(preorder, inorder);
    }
}
