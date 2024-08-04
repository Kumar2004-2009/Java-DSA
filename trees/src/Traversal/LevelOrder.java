package Traversal;

import java.util.*;

public class LevelOrder {
    public static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val=val;
        }
    }
    public static void nthleve(Node root, int n){
        if(root==null) return;
        if(n==1) System.out.print(root.val+" ");

        nthleve(root.left,n-1);
        nthleve(root.right,n-1);
    }
    public static int height(Node root){
        if(root==null) return 0;
        if(root.left==null && root.right==null) return 0;
        return 1+Math.max(height(root.left),height(root.right));
    }

    public static void bfs(Node root){
        Queue<Node> q=new LinkedList<>();
        if(root!=null) q.add(root);
        while(q.size()>0){
            Node temp=q.peek();
            if(temp.left!=null) q.add(temp.left);
            if(temp.right!=null) q.add(temp.right);
            System.out.print(temp.val+" ");
            q.remove();
        }
    }

//    DFS
    public List<Integer> inorderTraversal(Node root){
        List<Integer> arr=new ArrayList<>();
        Stack<Node> st=new Stack<>();
        if(root==null) return arr;
        st.push(root);
        while(st.size()>0){
            Node temp=st.peek();
            if(temp.left!=null){
                st.push(temp.left);
                temp.left=null;   //VVIP
            }else {
                st.pop();
                arr.add(temp.val);
                if(temp.right!=null) st.push(temp.right);
            }
        }
        return arr;
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
//        using nth level printing
        int level=height(root)+1;
        for(int i=1;i<=level;i++){   //O(logn)
            nthleve(root,i); //O(n)
        }
        System.out.println();
//        total=O(nlogn)
        bfs(root);
    }
}
