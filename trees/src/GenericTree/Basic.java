package GenericTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static java.util.Collections.max;
import static java.util.Collections.reverse;

public class Basic {
    private static class Node{
        int val;
        List<Node> child;
        Node(int val){
            this.val=val;
            child=new ArrayList<>();
        }
    }
    static void preOrderTraversal(Node root){
        if(root.child.isEmpty()){
            System.out.print(root.val+" ");
            return;
        }
        System.out.print(root.val+" ");
        int n=root.child.size();
        for(int i=0;i<n;i++){
            preOrderTraversal(root.child.get(i));
        }
    }
    static void postOrderTraversal(Node root){
        if(root.child.isEmpty()){
            System.out.print(root.val+" ");
            return;
        }
        int n=root.child.size();
        for(int i=0;i<n;i++){
            postOrderTraversal(root.child.get(i));
        }
        System.out.print(root.val+" ");
    }

    static void levelOrder(Node root){
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node currentNode=q.remove();
            System.out.print(currentNode.val+" ");
            int noOfChild=currentNode.child.size();
            for(int i=0;i<noOfChild;i++){
                q.add(currentNode.child.get(i));
            }
        }
    }
    static void zigZaglevelOrder(Node root){
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        boolean flag=false;
        while(!q.isEmpty()){
            int levelSize=q.size();
            List<Node> currentLevel=new ArrayList<>();
            while((levelSize--)>0) {
                Node currentNode = q.remove();
                currentLevel.add(currentNode);

                int noOfChild = currentNode.child.size();
                for (int i = 0; i < noOfChild; i++) {
                    q.add(currentNode.child.get(i));
                }
            }
            if(flag==false){
                printNodeList(currentLevel);
            }
            else{
                reverse(currentLevel);
                printNodeList(currentLevel);
            }
            flag=!flag;
        }
    }

    public static int findMax(Node root){
        if(root.child.isEmpty()){
            return root.val;
        }
        int maxTill= root.val;
        int n=root.child.size();
        for(int i=0;i<n;i++){
            int childMax=findMax(root.child.get(i));
            if(childMax>maxTill){
                maxTill=childMax;
            }
        }
        return maxTill;
    }
    static void printNodeList(List<Node> nodelist){
        for(int i=0;i<nodelist.size();i++){
            System.out.print(nodelist.get(i).val+" ");
        }
        System.out.println();
    }

    static void mirrorTree(Node root){
        if(root.child.isEmpty()) return;
        int noOfChild=root.child.size();
        if(noOfChild==1) return;

        for(int i=0;i<noOfChild;i++){
            mirrorTree(root.child.get(i));
            reverse(root.child);
        }
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        (root.child).add(new Node(2));
        (root.child).add(new Node(3));
        (root.child.get(0).child).add(new Node(4));
        (root.child.get(0).child).add(new Node(5));
        (root.child.get(1).child).add(new Node(6));
        (root.child.get(1)).child.add(new Node(7));
        (root.child.get(1).child).add(new Node(8));

//        preOrderTraversal(root);
//        System.out.println();
//        postOrderTraversal(root);
//        System.out.println();
//        levelOrder(root);
//        System.out.println();
        zigZaglevelOrder(root);
//        int res=findMax(root);
//        System.out.println(res);
//
//        mirrorTree(root);
//        levelOrder(root);
//        int n=root.child.size();
//        for(int i=0;i<n;i++){
//            System.out.println(root.child.get(i));
//        }
    }
}
