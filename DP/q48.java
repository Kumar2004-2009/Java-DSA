// Matrix Chain Multiplication-MCM
import java.util.*;
public class q48 {
    public static void main(String[] args) {
        int[] a={10,30,5,60};
        int n=a.length;

        System.out.println(rec(a,1,n-1));

        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        System.out.println(mem(a,1,n-1,dp));    // TC-O(n3)   SC-O(n2)+O(n)



        // Tabulation
        int[][] dp1=new int[n][n];
        for(int i=0;i<n;i++){
            dp1[i][i]=0;
        }
        
        
    }
    public static int mem(int[] a,int i,int j,int[][] dp){
        if(i==j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];

        int mini=1000000000;
        for(int k=i;k<j;k++){
            int steps=(a[i-1]*a[k]*a[j])+rec(a, i, k)+rec(a, k+1, j);
            mini=Math.min(mini,steps);
        }
        return dp[i][j]=mini;
    }

    public static int rec(int[] a,int i,int j){
        if(i==j) return 0;

        int mini=1000000000;
        for(int k=i;k<j;k++){
            int steps=(a[i-1]*a[k]*a[j])+rec(a, i, k)+rec(a, k+1, j);
            mini=Math.min(mini,steps);
        }
        return mini;
    }
}
