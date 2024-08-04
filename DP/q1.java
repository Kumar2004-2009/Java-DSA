import java.util.*;
public class q1{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(recFib(n));
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(memFib(n, dp));

        // Tabulation
        int[] dp1=new int[n+1];
        dp1[0]=0;
        dp1[1]=1;

        for(int i=2;i<n+1;i++){
            dp1[i]=dp1[i-1]+dp1[i-2];
        }
        System.out.println(dp[n]);


        // Space Optimization
        int cur=1;
        int prev=0;

        for(int i=2;i<n+1;i++){
            int temp=cur;
            cur=prev+cur;
            prev=temp;
        }
        System.out.println(cur);
    }
    public static int recFib(int n){
        if(n<=1){
            return n;
        }
        return recFib(n-1)+recFib(n-2);
    }
    public static int memFib(int n,int[] dp){
        if(n<=1) return n;
        if(dp[n]!=-1) return dp[n];

        dp[n]=memFib(n-1, dp)+memFib(n-2, dp);
        return dp[n];
    }
}