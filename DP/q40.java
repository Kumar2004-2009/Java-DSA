// buy and sell stock with transaction fees
public class q40 {
    public static void main(String[] args) {
        int[] a={1,3,2,8,4,9};
        int n=a.length;
        int fee=2;

        int[][] dp1=new int[n+1][2];
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
                    profit=Math.max(dp1[i+1][1]+a[i]-fee,dp1[i+1][0]);
                }
                dp1[i][j]=profit;
            }
        }
        System.out.println(dp1[0][1]);
    }
}
