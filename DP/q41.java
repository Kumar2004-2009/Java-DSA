// Longest Increasing Subsequence

import java.util.Arrays;

public class q41 {
    public static void main(String[] args) {
        int[] a={10,9,2,5,3,7,101,18};
        int n=a.length;

        System.out.println(rec(0,-1,a));

        int[][] dp=new int[n][n+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<=n;j++){
                dp[i][j]=-1;
            }
        }
        System.out.println(mem(0,-1,a,dp));



        // Tabulation
        int[][] dp1=new int[n+1][n+1];
        
        for(int i=n-1;i>=0;i--){
            for(int j=i-1;j>=-1;j--){
                int len=0;
                len=0+dp1[i+1][j+1];

                if(j==-1 || a[i]>a[j]){
                    len=Math.max(1+dp1[i+1][i+1],len);
                }
                dp1[i][j+1]=len;
            }
        }
        System.out.println(dp1[0][0]);




        // Space Optimization
        int[] after=new int[n+1];
        
        for(int i=n-1;i>=0;i--){
            int[] temp=new int[n+1];
            for(int j=i-1;j>=-1;j--){
                int len=0;
                len=0+after[j+1];

                if(j==-1 || a[i]>a[j]){
                    len=Math.max(1+after[i+1],len);
                }
                temp[j+1]=len;
            }
            after=temp;
        }
        System.out.println(after[0]);





        // single array
        int maxi=0;
        int[] dp2=new int[n];
        Arrays.fill(dp2, 1);
        for(int i=0;i<n;i++){
            for(int prev=0;prev<i;prev++){
                if(a[prev]<a[i] && dp2[prev]+1>dp2[i]){
                    dp2[i]=1+dp2[prev];
                }
            }
            maxi=Math.max(maxi, dp2[i]);
        }
        System.out.println(maxi);
    }
    public static int mem(int i,int prev,int[] a,int[][] dp){
        if(i==a.length) return 0;
        if(dp[i][prev+1]!=-1) return dp[i][prev+1];

        int len=0;
        len=0+rec(i+1, prev, a);

        if(prev==-1 || a[i]>a[prev]){
            len=Math.max(1+rec(i+1, i, a), len);
        }
        return dp[i][prev+1]=len;
    }
    public static int rec(int i,int prev,int[] a){
        if(i==a.length) return 0;

        int len=0;
        len=0+rec(i+1, prev, a);

        if(prev==-1 || a[i]>a[prev]){
            len=Math.max(1+rec(i+1, i, a), len);
        }
        return len;
    }
}
