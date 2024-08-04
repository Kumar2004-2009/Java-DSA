package Traversal;

import java.util.ArrayList;

public class MorrisTraversalInorder {
    public static class Node {
        int val;
        Node left;
        Node right;
        Node(int val) {
            this.val = val;
        }

    }
    public ArrayList<Integer> inorderTraversal(Node root){
        Node curr=root;
        ArrayList<Integer> arr=new ArrayList<>();
        while(curr!=null){
            if(curr.left!=null) { //find pred
                Node pred = curr.left;
                while (pred.right != null && pred.right != curr) {
                    pred = pred.right;
                }
                if (pred.right == null) {  //connect pred to curr
                    pred.right = curr;
                    curr = curr.left;
                }
                if (pred.right == curr) {  // unlink
                    pred.right = null;
                    arr.add(curr.val);
                    curr = curr.right;
                }
            }else{
                arr.add(curr.val);
                curr=curr.right;
            }
        }
        return arr;
    }
}
