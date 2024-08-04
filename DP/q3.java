// Frog jump

import java.util.*;

public class q3 {
    static int[] arr={10,20,30,10};
    public static void main(String[] args) {
        
        System.out.println(rec(arr.length-1));
        int[] dp=new int[arr.length];
        Arrays.fill(dp,-1);
        System.out.println(mem(arr.length-1,dp));

        // Tabulation
        int[] dp1=new int[arr.length];
        dp1[0]=0;
        for(int i=1;i<arr.length;i++){
            int l=dp1[i-1]+Math.abs(arr[i]-arr[i-1]);
            int r=Integer.MAX_VALUE;
            if(i>1){
                r=dp1[i-2]+Math.abs(arr[i]-arr[i-2]);
            }
            dp1[i]=Math.min(l,r);
        }
        System.out.println(dp1[3]);



        // Space Optimization
        int prev1=0;
        int prev2=Integer.MAX_VALUE;

        for(int i=1;i<arr.length;i++){
            int l=prev1+Math.abs(arr[i]-arr[i-1]);
            int r=Integer.MAX_VALUE;
            if(i>1){
                r=prev2+Math.abs(arr[i]-arr[i-2]);
            }
            int cur=Math.min(l,r);
            prev2=prev1;
            prev1=cur;
        }
        System.out.println(prev1);
    }
    public static int rec(int idx){
        if(idx==0){
            return 0;
        }
        int l=rec( idx-1)+Math.abs(arr[idx]-arr[idx-1]);
        int r=Integer.MAX_VALUE;
        if(idx>1){
            r=rec(idx-2)+Math.abs(arr[idx]-arr[idx-2]);
        }
        return Math.min(l,r);
    }
    public static int mem(int idx,int[] dp){
        if(idx==0) return 0;
        if(dp[idx]!=-1) return dp[idx];

        int l=mem(idx-1, dp)+Math.abs(arr[idx]-arr[idx-1]);
        int r=Integer.MAX_VALUE;
        if(idx>1){
            r=mem(idx-2,dp)+Math.abs(arr[idx]-arr[idx-2]);
        }
        return dp[idx]=Math.min(l,r);
    }
}
