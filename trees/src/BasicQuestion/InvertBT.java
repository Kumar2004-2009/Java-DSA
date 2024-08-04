package BasicQuestion;

import Traversal.LevelOrder;

public class InvertBT {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
        }
    }
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return root;
        TreeNode l=root.left;
        TreeNode r=root.right;
        root.left=r;
        root.right=l;
        root.left=invertTree(root.left);
        root.right=invertTree(root.right);
        return root;
    }
}
