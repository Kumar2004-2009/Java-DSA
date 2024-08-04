// Maximum falling path sum  ||Variable starting and variable ending
public class q12 {
    public static void main(String[] args) {
        int[][] a={{1,2,10,4},{100,3,2,1},{1,1,20,2},{1,2,2,1}};
        int n=a.length;
        int m=a[0].length;

        int max=Integer.MIN_VALUE;
        for(int j=0;j<m;j++){
            max=Math.max(max,rec(a,n-1,j));
        }
        System.out.println(max);

        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=-1;
            }
        }
        int maxi=Integer.MIN_VALUE;
        for(int j=0;j<m;j++){
            maxi=Math.max(maxi,mem(a, n-1,j, dp));
        }
        System.out.println(maxi);



        // Tabulation
        int[][] dp1=new int[n][m];
        for(int j=0;j<m;j++){
            dp[0][j]=a[0][j];
        }

        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                int up=a[i][j]+dp[i-1][j];
                int left=a[i][j]+(j-1<0?-100000000:dp[i-1][j-1]);
                int right=a[i][j]+(j+1>=m?-10000000:dp[i-1][j+1]);

                dp[i][j]=Math.max(Math.max(left, right),up);
            }
        }
        int max2=dp[n-1][0];
        for(int j=1;j<m;j++){
            max2=Math.max(max2, dp[n-1][j]);
        }
        System.out.println(max2);



        // Space Optimization
        int[] prev=new int[m];
        for(int j=0;j<m;j++){
            prev[j]=a[0][j];
        }
        for(int i=1;i<n;i++){
            int[] temp=new int[m];
            for(int j=0;j<m;j++){
                int up=a[i][j]+prev[j];
                int left=a[i][j]+(j-1<0?-100000000:prev[j-1]);
                int right=a[i][j]+(j+1>=m?-10000000:prev[j+1]);

                temp[j]=Math.max(Math.max(left, right),up);
            }
            prev=temp;
        }
        int max3=prev[0];
        for(int i=1;i<m;i++){
            max3=Math.max(max3,prev[i]);
        }
        System.out.println(max3);
    }
    
    public static int mem(int[][] a,int i,int j,int[][] dp){
        if(j<0 || j>=a[0].length) return -100000000;

        if(i==0) return a[0][j];

        if(dp[i][j]!=-1) return dp[i][j];

        int up=a[i][j]+mem(a, i-1, j, dp);
        int left=a[i][j]+mem(a, i-1, j-1, dp);
        int right=a[i][j]+mem(a, i-1, j+1, dp);

        return dp[i][j]=Math.max(Math.max(left, right),up);
    }
    public static int rec(int[][] a,int i,int j){
        if(j<0 || j>=a[0].length) return -100000000;

        if(i==0) return a[0][j];

        int up=a[i][j]+rec(a,i-1,j);
        int left=a[i][j]+rec(a,i-1,j-1);
        int right=a[i][j]+rec(a, i-1, j+1);

        return Math.max(Math.max(left, right),up);
    }
}
