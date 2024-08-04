// Climb Stairs
import java.util.*;
public class q2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(rec(n));
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(mem(n,dp));
    }
    public static int mem(int n,int[] dp){
        if(n==0 || n==1) return 1;

        if(dp[n]!=-1) return dp[n];

        int l=mem(n-1, dp);
        int r=mem(n-2, dp);
        return dp[n]=l+r;
    }
    public static int rec(int n){
        if(n==0) return 1;
        if(n==1) return 1;

        int l=rec(n-1);
        int r=rec(n-2);
        return l+r;
    }
}
