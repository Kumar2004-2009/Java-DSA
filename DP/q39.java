// buy and sell stocks with cooldown
public class q39 {
    public static void main(String[] args) {
        int[] a={4,9,0,4,10};
        int n=a.length;

        System.out.println(rec(0, 1, a));

        int[][] dp=new int[n][2];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                dp[i][j]=-1;
            }
        }
        System.out.println(mem(0,1,a,dp));



        // Tabulation
        int[][] dp1=new int[n+2][2];
        for(int j=0;j<2;j++){
            dp1[n][j]=0;
        }
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<2;j++){
                int profit=0;
                if(j==1){
                    profit=Math.max(dp1[i+1][0]-a[i],dp1[i+1][1]);
                }
                else{
                    profit=Math.max(dp1[i+2][1]+a[i],dp1[i+1][0]);
                }
                dp1[i][j]=profit;
            }
        }
        System.out.println(dp1[0][1]);


    }
    public static int mem(int idx,int buy,int[] a,int[][] dp){
        if(idx>=a.length) return 0;

        if(dp[idx][buy]!=-1) return dp[idx][buy];
        int profit=0;
        if(buy==1){
            profit=Math.max((mem(idx+1, 0, a, dp)-a[idx]),mem(idx+1, 1, a,dp));
        }
        else{
            profit=Math.max((mem(idx+2, 1, a,dp)+a[idx]),mem(idx+1, 0, a,dp));
        }
        return dp[idx][buy]=profit;
    }
    public static int rec(int idx,int buy,int[] a){
        if(idx>=a.length) return 0;

        if(buy==1){
            return Math.max((rec(idx+1, 0, a)-a[idx]),rec(idx+1, 1, a));
        }
        else{
            return Math.max((rec(idx+2, 1, a)+a[idx]),rec(idx+1, 0, a));
        }
        
    }
}
