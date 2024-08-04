// Jump game-2

import java.util.Arrays;

public class q5 {
    public static void main(String[] args) {
        int[] arr={2,3,1,4,1,1,1,2};
        int[][] dp=new int[arr.length][arr.length];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                dp[i][j]=-1;
            }
        }
        System.out.println(minJump(arr,0,0));
        System.out.println(minDp(arr,0,0,dp));
        System.out.println(minJum(arr));
    }
    private static int minJum(int[] a){
        int n=a.length;
        int l=0,r=0,jump=0;
        while(r<n-1){
            int far=0;
            for(int i=l;i<=r;i++){
                far=Math.max(far,i+a[i]);
            }
            l=r+1;
            r=far;
            jump++;
        }
        return jump;
    }
    private static int minJump(int[] a,int idx,int jump){
        if(idx>=a.length-1){
            return jump;
        }
        int min=Integer.MAX_VALUE;
        for(int i=1;i<=a[idx];i++){
            min=Math.min(min, minJump(a, idx+i, jump+1));
        }
        return min;
    }
    private static int minDp(int[] a,int idx,int jump,int[][] dp){
        if(idx>=a.length-1){
            return jump;
        }
        if(dp[idx][jump]!=-1){
            return dp[idx][jump];
        }
        int min=Integer.MAX_VALUE;
        for(int i=1;i<=a[idx];i++){
            min=Math.min(min, minJump(a, idx+i, jump+1));
        }
        return dp[idx][jump]=min;
    }
    
}
