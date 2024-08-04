package Leetcode;


import Leetcode.Nodes;
public class DiameterOfBT {
    public static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val=val;
        }
    }

    public static int height(Node root){
        if(root==null) return 0;
        if(root.left==null && root.right==null) return 0;
        return 1+Math.max(height(root.left),height(root.right));
    }
    public int diameter(Node root){
        if(root==null ||(root.left==null && root.right==null)) return 0;
        int leftAns=diameter(root.left);
        int rightAns=diameter(root.right);
        int mid=height(root.left)+height(root.right);
        if(root.right!=null) mid++;
        if(root.left!=null) mid++;
        int max=Math.max(leftAns,Math.max(rightAns,mid));
        return max;
    }
}
