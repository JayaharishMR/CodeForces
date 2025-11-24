import model.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class DataObj
{
    long min;
    long max;
    boolean isBst;
    DataObj(Long min,Long max,boolean isBst)
    {
        this.min=min;
        this.max=max;
        this.isBst=isBst;
    }
}
class IsBst {

    public DataObj isBsthelper(TreeNode root)
    {
        if(root==null)
        {
            return new DataObj(Long.MAX_VALUE,Long.MIN_VALUE,true);
        }
        DataObj dataObj_left= isBsthelper(root.left);
        DataObj dataObj_right= isBsthelper(root.right);
        long min=Math.min(root.val,Math.min(dataObj_left.min,dataObj_right.min));
        long max=Math.max(root.val,Math.max(dataObj_right.max,dataObj_left.max));
        boolean c1=dataObj_left.max<root.val;
        boolean c2=dataObj_right.min>root.val;
        boolean c3= dataObj_right.isBst && dataObj_left.isBst;
        boolean myiBST= c1 && c2 && c3;
        return new DataObj(min,max,myiBST);
    }
    public boolean isValidBST(TreeNode root) {
        DataObj ans= isBsthelper(root);
        return ans.isBst;
    }
}