package Traversal;

public class Traversal {
    public static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val=val;
        }
    }
    public static void preorder(Node root){
        if(root==null) return;
        System.out.print(root.val+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void postorder(Node root){
        if(root==null) return;
        preorder(root.left);
        preorder(root.right);
        System.out.print(root.val+" ");
    }

    public static void inorder(Node root){
        if(root==null) return;
        inorder(root.left);
        System.out.print(root.val+" ");
        inorder(root.right);
    }

    public static void pip(int n){
        if(n==0) return;
        System.out.println("Pre"+n);
        pip(n-1);
        System.out.println("In"+n);
        pip(n-1);
        System.out.println("Post"+n);
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
        preorder(root);
        System.out.println();
        inorder(root);
        System.out.println();
        postorder(root);

        System.out.println();
        pip(3);
//        111
//        211121112
//        321112111232111211123

    }
}

