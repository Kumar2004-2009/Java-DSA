package BasicQuestion;

import Traversal.LevelOrder;

import java.util.ArrayList;
import java.util.List;

public class RightSideView {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
        }
    }
    public void nthleve(TreeNode root, int n,List<Integer>arr){  //left to right
        if(root==null) return;
        if(n==1) arr.add(root.val);

        nthleve(root.left,n-1,arr);
        nthleve(root.right,n-1,arr);
    }
    public static int height(TreeNode root){
        if(root==null) return 0;
        if(root.left==null && root.right==null) return 0;
        return 1+Math.max(height(root.left),height(root.right));
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        int level=height(root)+1;
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null) return ans;
        for(int i=1;i<=level;i++){
            List<Integer>arr=new ArrayList<>();
            nthleve(root,i,arr);

            ans.add(arr);

        }
        return ans;
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<List<Integer>> lo=levelOrder(root);
        List<Integer> ans=new ArrayList<>();

        for(int i=0;i<lo.size();i++){
            List<Integer> arr=lo.get(i);
            int lastEle=arr.get(arr.size()-1);
            ans.add(lastEle);
        }
        return ans;
    }
}
