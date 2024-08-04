import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PredAndSuccInorder {
    public static class Node {
        int val;
        Node left;
        Node right;
        Node(int val) {
            this.val = val;
        }

    }
    public static Node construct(String[] arr){
        int x=Integer.parseInt(arr[0]);
        int n= arr.length;
        Node root=new Node(x);
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        int i=1;
        while(i<n-1){
            Node temp=q.remove();
            Node left=new Node(0);
            Node right=new Node(0);
            if(arr[i].equals("")){
                left=null;
            }else{
                int l=Integer.parseInt(arr[i]);
                left.val=l;
                q.add(left);
            }
            if(arr[i+1].equals("")){
                right=null;
            }else{
                int r=Integer.parseInt(arr[i+1]);
                right.val=r;
                q.add(right);
            }
            temp.left=left;
            temp.right=right;
            i+=2;
        }
        return root;
    }
    private static void inorder(Node root,List<Integer> arr) {
        if(root==null) return;

        inorder(root.left,arr);
        arr.add(root.val);
        inorder(root.right,arr);

    }

    public static void main(String[] args) {
        String[] a = {"50", "20", "60", "17", "34", "55", "89", "10", "", "28", "", "", "", "70", "", "", "14"};
        Node root = construct(a);
        List<Integer> arr=new ArrayList<>();
        inorder(root,arr);
        int val=70;
        int idx=-1;
        for(int i=0;i<arr.size();i++){
            if(arr.get(i)==val){
                idx=i;
                break;
            }
        }
        System.out.println("Pred is: "+arr.get(idx-1));
        System.out.println("succ is: "+arr.get(idx+1));
    }
}
