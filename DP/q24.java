// Rod cutting Problem
public class q24 {
    public static void main(String[] args) {
        int[] price={2,5,7,8,10};
        int N=5;
        System.out.println(rec(price.length-1,price,N));

        int[][] dp=new int[price.length][N+1];
        for(int i=0;i<price.length;i++){
            for(int j=0;j<=N;j++){
                dp[i][j]=-1;
            }
        }
        System.out.println(mem(price.length-1, price, N, dp));



        // Tabulation
        int[][] dp1=new int[price.length][N+1];
        for(int j=0;j<=N;j++){
            dp1[0][j]=price[0]*(j);
        }
        for(int i=1;i<price.length;i++){
            for(int j=0;j<=N;j++){
                int notTake=dp1[i-1][j];
                int take=-100000000;
                int length=i+1;
                if(length<=j) take=price[i]+dp1[i][j-length];

                dp1[i][j]=Math.max(take,notTake);
            }
        }
        System.out.println(dp1[price.length-1][N]);




        // Space Optimization
        int[] prev=new int[N+1];
        for(int j=0;j<=N;j++){
            prev[j]=price[0]*(j);
        }
        for(int i=1;i<price.length;i++){
            int[] temp=new int[N+1];
            for(int j=0;j<=N;j++){
                int notTake=prev[j];
                int take=-100000000;
                int length=i+1;
                if(length<=j) take=price[i]+temp[j-length];

                temp[j]=Math.max(take,notTake);
            }
            prev=temp;
        }
        System.out.println(prev[N]);
    }
    public static int mem(int idx,int[] price,int N,int[][] dp){
        if(idx==0){
            return price[0]*N;
        }
        if(dp[idx][N]!=-1){
            return dp[idx][N];
        }
        int notTake=mem(idx-1, price, N, dp);
        int take=-100000000;
        int length=idx+1;
        if(length<=N) take=price[idx]+mem(idx, price, N-length, dp);

        return dp[idx][N]=Math.max(take,notTake);
    }
    public static int rec(int idx,int[] price,int N){
        if(idx==0){
            return price[0]*N;
        }
        int notTake=rec(idx-1, price, N);
        int take=-100000000;
        int length=idx+1;
        if(length<=N) take=price[idx]+rec(idx, price, N-length);

        return Math.max(take,notTake);
    }
}
