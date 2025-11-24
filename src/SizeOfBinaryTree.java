import model.BTNode;

import java.util.ArrayList;
import java.util.List;

public class SizeOfBinaryTree {
    public int getSize(BTNode node) {
        if (node == null) return 0;
        int ls = getSize(node.getLeft());
        int rs = getSize(node.getRight());
        return ls+rs+1;
    }

    public int maxValue(BTNode node) {
        if (node == null) return Integer.MIN_VALUE;
        int lm = maxValue(node.getLeft());
        int rm = maxValue(node.getRight());
        return Math.max(lm, Math.max(rm, node.getVal()));
    }

    public boolean isPresent(BTNode node, int val) {
        if (node == null) return false;
        if (node.getVal() == val) return true;
        boolean left = isPresent(node.getLeft(), val);
        boolean right = isPresent(node.getRight(), val);
        return left||right;
    }

    public boolean getPath(BTNode node, int val, ArrayList<Integer> path) {
        if (node == null) return false;
        if (node.getVal() == val) {
            path.add(node.getVal());
            return true;
        }
        boolean left = getPath(node.getLeft(), val, path);
        boolean right = getPath(node.getRight(), val, path);
        if (left || right) {
            path.add(node.getVal());
        }
        if (path.size() > 0) {
            return  true;
        }
        return false;
    }
    public static void main(String[] args) {
        BTNode leftNode = new BTNode(2);
        BTNode rightNode = new BTNode(4);
        BTNode rootNode = new BTNode(1, leftNode, rightNode);
        SizeOfBinaryTree sizeOfBinaryTree = new SizeOfBinaryTree();
        System.out.println(sizeOfBinaryTree.getSize(rootNode));
        System.out.println(sizeOfBinaryTree.maxValue(rootNode));
        System.out.println(sizeOfBinaryTree.isPresent(rootNode, 4));
        ArrayList<Integer> path = new ArrayList<>();
        sizeOfBinaryTree.getPath(rootNode, 4, path);
        path.forEach(x -> System.out.print(x));
    }
}
