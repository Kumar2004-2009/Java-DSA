// Minimum Coins
public class q20 {
    public static void main(String[] args) {
        int[] a={9,6,5,1};
        int tar=11;
        int n=a.length;

        System.out.println(rec(a,tar,n-1));

        int[][] dp=new int[n][tar+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<=tar;j++){
                dp[i][j]=-1;
            }
        }
        System.out.println(mem(a,tar,n-1,dp));



        // Tabulation
        int[][] dp1=new int[n][tar+1];
        for(int j=0;j<=tar;j++){
            if(j%a[0]==0) dp1[0][j]=j/a[0];
            else dp1[0][j]=1000000000;
        }

        for(int i=1;i<n;i++){
            for(int j=0;j<=tar;j++){
                int nonPick=dp1[i-1][j];
                int pick=1000000000;
                if(a[i]<=j){
                    pick=1+dp1[i][j-a[i]];
                }
                dp1[i][j]=Math.min(pick,nonPick);
            }
        }
        System.out.println(dp[n-1][tar]);



        // Space Optimization
        int[] prev=new int[tar+1];
        for(int j=0;j<=tar;j++){
            if(j%a[0]==0) prev[j]=j/a[0];
            else prev[j]=1000000000;
        }
        for(int i=1;i<n;i++){
            int[] temp=new int[tar+1];
            for(int j=0;j<=tar;j++){
                int nonPick=prev[j];
                int pick=1000000000;
                if(a[i]<=j){
                    pick=1+temp[j-a[i]];
                }
                temp[j]=Math.min(pick,nonPick);
            }
            prev=temp;
        }
        System.out.println(prev[tar]);
    }
    public static int mem(int[] coins,int t,int idx,int[][] dp){
        if(idx==0){
            if(t%coins[0]==0) return t/coins[0];
            else return 1000000000;
        }
        if(dp[idx][t]!=-1) return dp[idx][t];
        int nonPick=mem(coins, t, idx-1,dp);
        int pick=1000000000;
        if(coins[idx]<=t){
            pick=1+mem(coins, t-coins[idx], idx,dp);
        }
        return dp[idx][t]=Math.min(pick,nonPick);
    }
    public static int rec(int[] coins,int t,int idx){
        if(idx==0){
            if(t%coins[0]==0) return t/coins[0];
            else return 1000000000;
        }
        int nonPick=rec(coins, t, idx-1);
        int pick=1000000000;
        if(coins[idx]<=t){
            pick=1+rec(coins, t-coins[idx], idx);
        }
        return Math.min(pick,nonPick);
    }
}
