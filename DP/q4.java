// frog jump-2
import java.util.*;
public class q4 {
    public static void main(String[] args) {
        int[] arr={10,20,30,10};
        int k=2;
        System.out.println(rec(arr,arr.length-1,k));
        int[] dp=new int[arr.length];
        Arrays.fill(dp,-1);
        System.out.println(mem(arr,arr.length-1,k,dp));

        // Tabulation
        int[] dp1=new int[arr.length];
        dp[0]=0;

        for(int i=1;i<arr.length;i++){
            int minStep=Integer.MAX_VALUE;

            for(int j=1;j<=k;j++){
                int jump=Integer.MAX_VALUE;
                if(i-j>=0){
                    jump=dp[i-j]+Math.abs(arr[i]-arr[i-j]);
                }
                minStep=Math.min(minStep, jump);
            }
            dp[i]=minStep;
        }
        System.out.println(dp[arr.length-1]);
    }
    public static int mem(int[] arr,int idx,int k,int[] dp){
        if(idx==0) return 0;
        if(dp[idx]!=-1) return dp[idx];

        int minStep=Integer.MAX_VALUE;
        for(int j=1;j<=k;j++){
            int jump=Integer.MAX_VALUE;
            if(idx-j>=0){
                jump=mem(arr, idx-j, k, dp)+Math.abs(arr[idx]-arr[idx-j]);
            }
            minStep=Math.min(minStep, jump);
        }
        return dp[idx]=minStep;
    }
    public static int rec(int[] arr,int idx,int k){
        if(idx==0) return 0;
        int minStep=Integer.MAX_VALUE;

        for(int j=1;j<=k;j++){
            int jump=Integer.MAX_VALUE;
            if(idx-j>=0){
                jump=rec(arr, idx-j, k)+Math.abs(arr[idx]-arr[idx-j]);
            }
            minStep=Math.min(minStep, jump);
        }
        return minStep;
    }
}
