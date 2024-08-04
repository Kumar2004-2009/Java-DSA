// Ways to make coin change   || coin change-2
import java.util.*;
public class q22 {
    public static void main(String[] args) {
        int[] a={1,2,3};
        int n=a.length;
        int tar=4;
        System.out.println(rec(a,n-1,tar));

        int[][] dp=new int[n][tar+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<=tar;j++){
                dp[i][j]=-1;
            }
        }

        System.out.println(mem(a,n-1,tar,dp));



        // Tabulation
        int[][] dp1=new int[n][tar+1];
        for(int j=0;j<=tar;j++){
            if(j%a[0]==0){
                dp1[0][j]=1;
            }
            else{
                dp1[0][j]=0;
            }
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<=tar;j++){
                int nonTake=0+dp1[i-1][j];
                int take=0;
                if(a[i]<=j) take=dp1[i][j-a[i]];

                dp1[i][j]=take+nonTake;
            }
        }
        System.out.println(dp1[n-1][tar]);



        // Space Optimization
        int[] prev=new int[tar+1];
        for(int j=0;j<=tar;j++){
            if(j%a[0]==0){
                prev[j]=1;
            }
            else{
                prev[j]=0;
            }
        }
        for(int i=1;i<n;i++){
            int[] temp=new int[tar+1];
            for(int j=0;j<=tar;j++){
                int nonTake=0+prev[j];
                int take=0;
                if(a[i]<=j) take=temp[j-a[i]];

               temp[j]=take+nonTake;
            }
            prev=temp;
        }
        System.out.println(prev[tar]);
        
    }
    public static int mem(int[] a,int idx,int t,int[][] dp){
        if(idx==0){
            return (t%a[0]==0?1:0);
        }
        if(dp[idx][t]!=-1) return dp[idx][t];
        int nonTake=0+mem(a, idx-1, t, dp);
        int take=0;
        if(a[idx]<=t) take=mem(a, idx, t-a[idx], dp);

        return dp[idx][t]=take+nonTake;
    }
    public static int rec(int[] a,int idx,int t){
        if(idx==0){
            return (t%a[0]==0?1:0);
        }
        int nonTake=0+rec(a, idx-1, t);
        int take=0;
        if(a[idx]<=t) take=rec(a, idx, t-a[idx]);

        return take+nonTake;
    }
}
