// minimum path sum
import java.util.*;
public class q10 {
    public static void main(String[] args) {
        int[][] a={{5,9,6},{11,5,2}};
        int n=a.length;
        int m=a[0].length;

        System.out.println(rec(a,n-1,m-1));
        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=-1;
            }
        }
        System.out.println(mem(a,n-1,m-1,dp));


        // Tabulation
        int[][] dp1=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 && j==0) dp1[i][j]=a[0][0];
                else{
                    int up=(i-1>=0?dp1[i-1][j]+a[i][j]:10000000);
                    int left=(j-1>=0?dp1[i][j-1]+a[i][j]:10000000);

                    dp1[i][j]=Math.min(up, left);
                }
            }
        }
        System.out.println(dp1[n-1][m-1]);


        // Space Optimization
        int[] prev=new int[m];
        for(int i=0;i<n;i++){
            int[] temp=new int[m];
            for(int j=0;j<m;j++){
                if(i==0 && j==0) temp[j]=a[i][j];
                else{
                    int up=(i-1>=0?prev[j]+a[i][j]:10000000);
                    int left=(j-1>=0?temp[j-1]+a[i][j]:10000000);

                    temp[j]=Math.min(up, left);
                }
            }
            prev=temp;
        }
        System.out.println(prev[m-1]);
    }
    public static int mem(int[][] a,int i,int j,int[][] dp){
        if(i==0 && j==0) return a[0][0];

        if(i<0 || j<0) return 10000000;
        if(dp[i][j]!=-1) return dp[i][j];

        int up=a[i][j]+mem(a, i-1, j, dp);
        int left=a[i][j]+mem(a, i, j-1, dp);

        return dp[i][j]=Math.min(up,left);
    }
    public static int rec(int[][] a,int i,int j){
        if(i==0 && j==0) return a[0][0];
        if(i<0 || j<0) return 10000000;

        int up=a[i][j]+rec(a, i-1, j);
        int left=a[i][j]+rec(a, i, j-1);

        return Math.min(up,left);
    }
}
