package Leetcode;

public class SameTree {
    public class Node{
        public int val;
        public Node left;
        public Node right;
        Node(int val){
            this.val=val;
        }
    }
    public boolean isSameTree(Node p,Node q){
        if(p==null || q==null) return false;
        if(q==null && p==null) return true;
        if(p.val!=q.val) return false;
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
