// unique Paths-2  || Maze obstacles
import java.util.*;
public class q9 {
    public static void main(String[] args) {
        int[][] a={{0,0,0},{0,-1,0},{0,0,0}};
        System.out.println(rec(a,a.length-1,a[0].length-1));

        int[][] dp=new int[a.length][a[0].length];
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                dp[i][j]=-1;
            }
        }
        System.out.println(mem(a,a.length-1,a[0].length-1,dp));


        // Tabulation
        int[][] dp1=new int[a.length][a[0].length];
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                if(i>=0 && j>=0 && a[i][j]==-1) dp1[i][j]=0;

                else if(i==0 && j==0) dp1[i][j]=1;
                else{
                    int up=(i-1>=0?dp1[i-1][j]:0);
                    int left=(j-1>=0?dp1[i][j-1]:0);
                    
                    dp1[i][j]=up+left;
                }
            }
        }
        System.out.println(dp1[a.length-1][a[0].length-1]);


        // Space Optimization
        int[] prev=new int[a[0].length];
        for(int i=0;i<a.length;i++){
            int[] temp=new int[a[0].length];
            for(int j=0;j<a[0].length;j++){
                if(i>=0 && j>=0 && a[i][j]==-1) temp[j]=0;

                else if(i==0 && j==0) temp[j]=1;
                else{
                    int up=(i-1>=0?prev[j]:0);
                    int left=(j-1>=0?temp[j-1]:0);
                    
                    temp[j]=up+left;
                }
            }
            prev=temp;
        }
        System.out.println(prev[a[0].length-1]);
    }
    public static int mem(int[][] a,int i,int j,int[][] dp){
        if(i>=0 && j>=0 && a[i][j]==-1){
            return 0;
        }
        if(i==0 && j==0) return 1;
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];

        int up=mem(a, i-1, j, dp);
        int left=mem(a, i, j-1, dp);
        return dp[i][j]=up+left;
    }
    public static int rec(int[][] a,int n,int m){
        if(n>=0 && m>=0 && a[n][m]==-1){
            return 0;
        }
        if(n==0 && m==0) return 1;
        if(n<0 || m<0) return 0;

        int up=rec(a,n-1,m);
        int left=rec(a,n,m-1);
        return up+left;
    }
}
