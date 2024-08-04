// Distinct Subsequences
public class q32 {
    public static void main(String[] args) {
        String s1="babgbag";
        String s2="bag";
        int n1=s1.length();
        int n2=s2.length();

        System.out.println(rec(s1,s2,n1-1,n2-1));

        int[][] dp=new int[n1][n2];
        for(int i=0;i<n1;i++){
            for(int j=0;j<n2;j++){
                dp[i][j]=-1;
            }
        }
        System.out.println(mem(s1,s2,n1-1,n2-1,dp));



        // Tabulation
        int[][] dp1=new int[n1+1][n2+1];
        for(int i=0;i<=n1;i++){
            dp1[i][0]=1;
        }
        for(int j=1;j<=n2;j++){
            dp1[0][j]=0;
        }
        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp1[i][j]=dp1[i-1][j-1]+dp1[i-1][j];
                }
                else dp1[i][j]=dp1[i-1][j];
            }
        }
        System.out.println(dp1[n1][n2]);
        



        // Space Optimization
        int[] prev=new int[n2+1];
        int[] temp=new int[n2+1];
        prev[0]=temp[0]=1;
        
        for(int i=1;i<=n1;i++){ 
            for(int j=1;j<=n2;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    temp[j]=prev[j-1]+prev[j];
                }
                else temp[j]=prev[j];
            }
            prev=temp;
        }
        System.out.println(prev[n2]);
    }
    public static int mem(String s1,String s2,int i,int j,int[][] dp){
        if(j<0) return 1;
        if(i<0) return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j]=mem(s1, s2, i-1, j-1, dp)+mem(s1, s2, i-1, j,dp);
        }
        return dp[i][j]=mem(s1, s2, i-1, j,dp);
    }
    public static int rec(String s1,String s2,int i,int j){
        if(j<0) return 1;
        if(i<0) return 0;

        if(s1.charAt(i)==s2.charAt(j)){
            return rec(s1, s2, i-1, j-1)+rec(s1, s2, i-1, j);
        }
        return rec(s1, s2, i-1, j);
    }
}
