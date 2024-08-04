// Triangle   || fixes point and variable ending point
import java.util.*;
public class q11 {
    public static void main(String[] args) {
        int[][] a={{1},{2,3},{3,6,7},{8,9,6,10}};
        int n=a.length;
        int m=a[0].length;

        System.out.println(rec(a,0,0));
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        } 
        System.out.println(mem(a,0,0,dp));


        // Tabulation
        int[][] dp1=new int[n][n];
        for(int j=0;j<n;j++){
            dp1[n-1][j]=a[n-1][j];
        }

        for(int i=n-2;i>=0;i--){
            for(int j=0;j<a[i].length;j++){
                int down=a[i][j]+dp1[i+1][j];
                int diagonal=a[i][j]+dp1[i+1][j+1];

                dp1[i][j]=Math.min(down, diagonal);
            }
        }
        System.out.println(dp1[0][0]);


        // Space Optimization
        int[] prev=new int[n];
        for(int j=0;j<n;j++){
            prev[j]=a[n-1][j];
        }
        for(int i=n-2;i>=0;i--){
            int[] temp=new int[i+1];
            for(int j=0;j<a[i].length;j++){
                int down=a[i][j]+prev[j];
                int diagonal=a[i][j]+prev[j+1];

                temp[j]=Math.min(down,diagonal);
            }
            prev=temp;
        }
        System.out.println(prev[0]);
    }
    public static int mem(int[][] a,int i,int j,int[][] dp){
        if(i==a.length-1) return a[i][j];
        if(dp[i][j]!=-1) return dp[i][j];


        int down=a[i][j]+mem(a, i+1, j, dp);
        int diagonal=a[i][j]+mem(a, i+1, j+1, dp);

        return dp[i][j]=Math.min(down, diagonal);
    }
    public static int rec(int[][] a,int i,int j){
        if(i==a.length-1) return a[i][j];

        int down=a[i][j]+rec(a,i+1,j);
        int diagonal=a[i][j]+rec(a, i+1, j+1);

        return Math.min(down, diagonal);
    }
}
