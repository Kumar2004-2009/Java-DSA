// Ubounded KnapSack
public class q23 {
    public static void main(String[] args) {
        int[] wt={2,4,6};
        int val[]={5,11,13};
        int W=10;
        int n=wt.length;

        System.out.println(rec(wt,n-1,val,W));

        int[][] dp=new int[n][W+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<=W;j++){
                dp[i][j]=-1;
            }
        }
        System.out.println(mem(wt,n-1,val,W,dp));



        // Tabulation
        int[][] dp1=new int[n][W+1];
        for(int j=0;j<=W;j++){
            dp1[0][j]=val[0]*(j/wt[0]);
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<=W;j++){
                int notTake=0+dp1[i-1][j];
                int take=0;
                if(wt[i]<=j){
                    take=val[i]+dp1[i][j-wt[i]];
                }
                dp1[i][j]=Math.max(take,notTake);
            }
        }
        System.out.println(dp1[n-1][W]);



        // Space Optimization
        int[] prev=new int[W+1];
        for(int j=0;j<=W;j++){
            prev[j]=val[0]*(j/wt[0]);
        }
        for(int i=1;i<n;i++){
            int[] temp=new int[W+1];
            for(int j=0;j<=W;j++){
                int notTake=0+prev[j];
                int take=0;
                if(wt[i]<=j){
                    take=val[i]+temp[j-wt[i]];
                }
                temp[j]=Math.max(take,notTake);
            }
            prev=temp;
        }
        System.out.println(prev[W]);
    }
    public static int mem(int[] wt,int idx,int[] val,int W,int[][] dp){
        if(idx==0){
            return val[0]*(W/wt[0]);
        }
        if(dp[idx][W]!=-1){
            return dp[idx][W];
        }
        int notTake=0+mem(wt, idx-1, val, W, dp);
        int take=0;
        if(wt[idx]<=W){
            take=val[idx]+mem(wt, idx, val, W-wt[idx], dp);
        }
        return dp[idx][W]=Math.max(take,notTake);
    }
    public static int rec(int[] wt,int idx,int[] val,int W){
        if(idx==0){
                return val[0]*(W/wt[0]);
        }
        int notTake=0+rec(wt, idx-1, val, W);
        int take=0;
        if(wt[idx]<=W){
            take=val[idx]+rec(wt, idx, val, W-wt[idx]);
        }
        return Math.max(take,notTake);
    }
}
