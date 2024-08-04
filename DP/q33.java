// Edit distance
public class q33 {
    public static void main(String[] args) {
        String s1="intention";
        String s2="execution";
        int n1=s1.length();
        int n2=s2.length();

        System.out.println(rec(s1,s2,n1-1,n2-1));

        int[][] dp=new int[n1][n2];
        for(int i=0;i<n1;i++){
            for(int j=0;j<n2;j++){
                dp[i][j]=-1;
            }
        }
        System.out.println(mem(s1, s2, n1-1, n2-1, dp));



        // Tabulation
        int[][] dp1=new int[n1+1][n2+1];
        for(int j=0;j<=n2;j++){
            dp1[0][j]=j;
        }
        for(int i=1;i<=n1;i++){
            dp1[i][0]=i;
        }
        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)) dp1[i][j]=0+dp1[i-1][j-1];

                else dp1[i][j]=Math.min((1+dp1[i][j-1]),Math.min((1+dp1[i-1][j]),(1+dp1[i-1][j-1])));
            }
        }
        System.out.println(dp1[n1][n2]);




        // Space Optimization
        int[] prev=new int[n2+1];
        for(int j=0;j<=n2;j++){
           prev[j]=j;
        }
        
        for(int i=1;i<=n1;i++){
            int []temp=new int[n2+1];
            temp[0]=i;
            for(int j=1;j<=n2;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)) temp[j]=0+prev[j-1];

                else temp[j]=Math.min((1+temp[j-1]),Math.min((1+prev[j]),(1+prev[j-1])));
            }
            prev=temp;
        }
        System.out.println(prev[n2]);
    }
    public static int mem(String s1,String s2,int i,int j,int[][] dp){
        if(i<0) return j+1;
        if(j<0) return i+1;

        if(dp[i][j]!=-1) return dp[i][j];

        if(s1.charAt(i)==s2.charAt(j)) return dp[i][j]=0+rec(s1, s2, i-1, j-1);

        return dp[i][j]=Math.min((1+rec(s1, s2, i, j-1)),Math.min((1+rec(s1, s2, i-1, j)),(1+rec(s1, s2, i-1, j-1))));
    }
    public static int rec(String s1,String s2,int i,int j){
        if(i<0) return j+1;
        if(j<0) return i+1;

        if(s1.charAt(i)==s2.charAt(j)) return 0+rec(s1, s2, i-1, j-1);

        return Math.min((1+rec(s1, s2, i, j-1)),Math.min((1+rec(s1, s2, i-1, j)),(1+rec(s1, s2, i-1, j-1))));
    }
}
