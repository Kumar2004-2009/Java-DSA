package BasicQuestion;

import Traversal.LevelOrder;

public class ZigZagLevelOrder {
    public static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val=val;
        }
    }
    public static void nthleve(Node root, int n){  //left to right
        if(root==null) return;
        if(n==1) System.out.print(root.val+" ");

        nthleve(root.left,n-1);
        nthleve(root.right,n-1);
    }
    public static void nthleve2(Node root, int n) {  //right to left
        if (root == null) return;
        if (n == 1) System.out.print(root.val + " ");

        nthleve2(root.right, n - 1);
        nthleve2(root.left, n - 1);

    }
    public static int height(Node root){
        if(root==null) return 0;
        if(root.left==null && root.right==null) return 0;
        return 1+Math.max(height(root.left),height(root.right));
    }

    public static void main(String[] args) {
        Node root=new Node(1);
        Node a=new Node(2);
        Node b=new Node(3);
        root.left=a;
        root.right=b;
        Node c=new Node(4);
        Node d=new Node(5);
        a.left=c;
        a.right=d;
        Node e=new Node(6);
        b.right=e;
        int level=height(root)+1;
        for(int i=1;i<=level;i++){
            if(i%2!=0) nthleve(root,i);
            else nthleve2(root,i);
            System.out.println();
        }
    }
}
