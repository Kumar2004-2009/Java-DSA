public class sizeMaxSumHeight {
    static int size=0;
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
        size++;
        preorder(root.left);
        preorder(root.right);
    }
    public static int size(Node root){
        if(root==null){
            return 0;
        }
        return 1+size(root.left)+size(root.right);
    }
    public static int sum(Node root){
        if(root==null) return 0;
        return root.val+sum(root.left)+sum(root.right);
    }
    public static int max(Node root){
        if(root==null) return Integer.MIN_VALUE;
        return Math.max(root.val,Math.max(max(root.left),max(root.right)));
    }

//    level wise height
    public static int height(Node root){
        if(root==null) return 0;
        return 1+Math.max(height(root.left),height(root.left));
    }
//    edges wise
    public static int height1(Node root){
        if(root==null) return 0;
        if(root.left==null && root.right==null) return 0;
        return 1+Math.max(height1(root.left),height1(root.left));
    }
    public static int min(Node root){
        if(root==null) return Integer.MAX_VALUE;
        return Math.min(root.val,Math.min(min(root.left),min(root.right)));
    }
    public static int multiply(Node root) {
        if (root == null) return 1;
        return root.val * multiply(root.left) * multiply(root.right);
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
//        System.out.println();
//        System.out.println(size);
//        int size=size(root);
        System.out.println(size);
        System.out.println(sum(root));
        System.out.println(max(root));
        System.out.println(height(root));
        System.out.println(height1(root));
        System.out.println(min(root));
        System.out.println(multiply(root));
    }
}
