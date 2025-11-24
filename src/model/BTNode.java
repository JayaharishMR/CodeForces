package model;

public class BTNode {
    int val;
    BTNode right;
    BTNode left;

    public BTNode getLeft() {
        return left;
    }

    public void setLeft(BTNode left) {
        this.left = left;
    }

    public BTNode getRight() {
        return right;
    }

    public void setRight(BTNode right) {
        this.right = right;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public BTNode(int val, BTNode right, BTNode left) {
        this.val = val;
        this.right = right;
        this.left = left;
    }

    public BTNode(int val) {
        this.val = val;
    }
}
