// 0/1 KnapSack
public class q19 {
    public static void main(String[] args) {
        int[] wt={3,2,5};
        int[] val={30,40,60};
        int W=6;
        int n=3;
        System.out.println(rec(wt,val,W,n-1));

        int[][] dp=new int[n][W+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<=W;j++){
                dp[i][j]=-1;
            }
        }

        System.out.println(mem(wt,val,W,n-1,dp));



        // Tabulation
        int[][] dp1=new int[n][W+1];
        for(int i=wt[0];i<=W;i++){
            dp1[0][i]=val[0];
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<=W;j++){
                int nonTake=dp1[i-1][j];
                int take=-10000000;
                if(wt[i]<=j){
                    take=val[i]+dp1[i-1][j-wt[i]];
                }
                dp1[i][j]=Math.max(take,nonTake);
            }
        }
        System.out.println(dp1[n-1][W]);



        // Space Optimization
        int[] prev=new int[W+1];
        for(int i=wt[0];i<=W;i++){
            prev[i]=val[0];
        }
        for(int i=1;i<n;i++){
            int[] temp=new int[W+1];
            for(int j=0;j<=W;j++){
                int nonTake=prev[j];
                int take=-10000000;
                if(wt[i]<=j){
                    take=val[i]+prev[j-wt[i]];
                }
                temp[j]=Math.max(take,nonTake);
            }
            prev=temp;
        }
        System.out.println(prev[W]);
    }
    public static int mem(int[] wt,int[] val,int W,int idx,int[][] dp){
        if(idx==0){
            if(wt[idx]<=W) return val[idx];
            else return 0;
        }
        if(dp[idx][W]!=-1) return dp[idx][W];
        int nonTake=mem(wt, val, W, idx-1,dp);
        int take=-10000000;
        if(wt[idx]<=W){
            take=val[idx]+mem(wt, val, W-wt[idx], idx-1,dp);
        }

        return dp[idx][W]=Math.max(take,nonTake);
    }
    public static int rec(int[] wt,int[] val,int W,int idx){
        if(idx==0){
            if(wt[idx]<=W) return val[idx];
            else return 0;
        }
        int nonTake=rec(wt, val, W, idx-1);
        int take=-10000000;
        if(wt[idx]<=W){
            take=val[idx]+rec(wt, val, W-wt[idx], idx-1);
        }

        return Math.max(take,nonTake);
    } 
}
