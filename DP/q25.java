// Longest Common Subsequences
public class q25 {
    public static void main(String[] args) {
        String a="acd";
        String b="ced";
        int n1=a.length();
        int n2=b.length();

        System.out.println(rec(a,n1-1,b,n2-1));

        int[][] dp=new int[n1][n2];
        for(int i=0;i<n1;i++){
            for(int j=0;j<n2;j++){
                dp[i][j]=-1;
            }
        }
        System.out.println(mem(a,n1-1,b,n2-1,dp));



        // Tabulation
        int[][] dp1=new int[n1+1][n2+1];

        for(int i=0;i<=n1;i++){
            dp1[i][0]=0;
        }
        for(int j=0;j<=n2;j++){
            dp1[0][j]=0;
        }

        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                if(a.charAt(i-1)==b.charAt(j-1)){
                    dp1[i][j]=1+(dp1[i-1][j-1]);
                }
                else dp1[i][j]=Math.max(dp1[i-1][j],dp1[i][j-1]);
            }
        }
        System.out.println(dp1[n1][n2]);




        // Space Optimization
        int[] prev=new int[n2+1];
        for(int j=0;j<=n2;j++){
            prev[j]=0;
        }
        for(int i=1;i<=n1;i++){
            int[] temp=new int[n2+1];
            for(int j=1;j<=n2;j++){
                if(a.charAt(i-1)==b.charAt(j-1)){
                    temp[j]=1+(prev[j-1]);
                }
                else temp[j]=Math.max(prev[j],temp[j-1]);
            }
            prev=temp;
        }
        System.out.println(prev[n2]);
    }
    public static int mem(String s1,int n,String s2,int m,int[][] dp){
        if(n<0 || m<0) return 0;

        if(dp[n][m]!=-1) return dp[n][m];

        if(s1.charAt(n)==s2.charAt(m)){
            return dp[n][m]=1+mem(s1, n-1, s2, m-1, dp);
        }
        return dp[n][m]=Math.max(rec(s1, n-1, s2, m),rec(s1, n, s2, m-1));
    }
    public static int rec(String s1,int n,String s2,int m){
        if(n<0 || m<0) return 0;

        if(s1.charAt(n)==s2.charAt(m)){
            return 1+rec(s1, n-1, s2, m-1);
        }
        return Math.max(rec(s1, n-1, s2, m),rec(s1, n, s2, m-1));
    }
}
