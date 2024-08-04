// Best time to sell and buy stock-III
public class q37 {
    public static void main(String[] args) {
        int[] a={3,3,5,0,0,3,1,4};
        int n=a.length;

        System.out.println(rec(0,1,2,a));

        int[][][] dp=new int[n+1][2][3];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                for(int k=0;k<3;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        System.out.println(mem(0,1,2,a,dp));




        // Tabulation
        int[][][] dp1=new int[n+1][2][3];
        for(int j=0;j<2;j++){
            for(int k=0;k<3;k++){
                dp1[n][j][k]=0;
            }
        }
        for(int i=0;i<n+1;i++){
            for(int j=0;j<2;j++){
                dp1[i][j][0]=0;
            }
        }
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<2;j++){
                for(int k=1;k<3;k++){
                    if(j==1){
                        dp1[i][j][k]=Math.max(dp1[i+1][0][k]-a[i],
                        dp1[i+1][1][k]);
                    }
                    else{
                        dp1[i][j][k]=Math.max(dp1[i+1][1][k-1]+a[i],
                        dp1[i+1][0][k-1]);
                    }
                }
            }
        }
        System.out.println(dp1[0][1][2]);




        // Space Optimization
        int[][] next=new int[2][3];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<2;j++){
                next[j][0]=0;
            }
        }
        for(int i=n-1;i>=0;i--){
            int[][]  temp=new int[2][3];
            for(int j=0;j<2;j++){
                for(int k=1;k<3;k++){
                    if(j==1){
                        temp[j][k]=Math.max(next[0][k]-a[i],
                        next[1][k]);
                    }
                    else{
                        temp[j][k]=Math.max(next[1][k-1]+a[i],
                        next[0][k-1]);
                    }
                }
            }
            next=temp;
        }
        System.out.println(next[1][2]);
    }
    public static int mem(int i,int buy,int cap,int[] a,int[][][] dp){
        if(cap==0 || i==a.length) return 0;

        if(dp[i][buy][cap]!=-1) return dp[i][buy][cap];

        if(buy==1){
            return dp[i][buy][cap]=Math.max((rec(i+1, 0, cap, a)-a[i]),
            rec(i+1, 1, cap, a));
        }
        else{
            return dp[i][buy][cap]=Math.max((rec(i+1, 1, cap-1, a)+a[i]),
            rec(i+1, 0, cap-1, a));
        }
    }
    public static int rec(int i,int buy,int cap,int[] a){
        if(cap==0 || i==a.length) return 0;

        if(buy==1){
            return Math.max((rec(i+1, 0, cap, a)-a[i]),
            rec(i+1, 1, cap, a));
        }
        else{
            return Math.max((rec(i+1, 1, cap-1, a)+a[i]),
            rec(i+1, 0, cap-1, a));
        }
    }
}
