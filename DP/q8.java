// count unique paths
public class q8 {
    public static void main(String[] args) {
        int n=2;
        int m=2;

        System.out.println(rec(n-1,m-1));
        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=-1;
            }
        }
        System.out.println(mem(n-1,m-1,dp));


        // Tabulation
        int[][] dp1=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 && j==0){
                    dp1[0][0]=1;
                }
                else{
                    int up=(i-1<0?0:dp[i-1][j]);
                    int left=(j-1<0?0:dp[i][j-1]);
                    dp1[i][j]=up+left;
                }
            }
        }
        System.out.println(dp[n-1][m-1]);


        // Space Optimization
        int[] prev=new int[m];
        
        for(int i=0;i<n;i++){
            int[] temp=new int[m];
            for(int j=0;j<m;j++){
                if(i==0 && j==0) temp[j]=1;
                else{
                    int up=(i>0?prev[j]:0);
                    int left=(j>0?temp[j-1]:0);
                    temp[j]=up+left;
                }
            }
            prev=temp;
        }
        System.out.println(prev[m-1]);
    }
    public static int rec(int i,int j){
        if(i==0 && j==0) return 1;
        if(i<0 || j<0) return 0;

        int up=rec(i-1,j);
        int left=rec(i,j-1);
        return up+left;
    }
    public static int mem(int i,int j,int[][] dp){
        if(i==0 && j==0) return 1;
        if(i<0 || j<0) return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        int up=mem(i-1,j,dp);
        int left=mem(i,j-1,dp);
        return dp[i][j]=up+left;
    }
}
