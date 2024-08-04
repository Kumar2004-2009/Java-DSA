// Wildcard Matching
public class q34 {
    public static void main(String[] args) {
        String s1="ab*cd";
        String s2="abefgcd";
        int n1=s1.length();
        int n2=s2.length();

        System.out.println(rec(s1,s2,n1-1,n2-1));

        int[][] dp=new int[n1][n2];
        for(int i=0;i<n1;i++){
            for(int j=0;j<n2;j++){
                dp[i][j]=-1;
            }
        }
        System.out.println((mem(s1,s2,n1-1,n2-1,dp)==1?true:false));




        // Tabulation
        boolean[][] dp1=new boolean[n1+1][n2+1];
        dp1[0][0]=true;
        for(int j=1;j<=n2;j++){
            dp1[0][j]=false;
        }
        for(int i=1;i<=n1;i++){
            boolean flag=true;
            for(int i1=1;i1<=i;i1++){
                if(s1.charAt(i1-1)!='*') {
                    flag=false;
                    break;
                }
            }
            dp1[i][0]=flag;
            
        }
        for(int i=1;i<=n1;i++){
            for(int j=1;i<=n2;j++){

                if((s1.charAt(i-1)==s2.charAt(j-1)) || s1.charAt(i-1)=='?'){
                    dp1[i][j]=dp1[i-1][j-1];
                }
                else if(s1.charAt(i-1)=='*')
                    dp1[i][j]=dp1[i-1][j] || dp1[i][j-1];

                else dp1[i][j]=false;
            }
        }
        System.out.println(dp1[n1][n2]);
    }
    public static int mem(String s1,String s2,int i,int j,int[][] dp){
        if(i<0 && j<0) return 1;
        if(i<0 && j>=0) return 0;

        if(j<0 && i>=0){
            for(int idx=0;idx<=i;idx++){
                if(s1.charAt(idx)!='*') return 0;
            }
            return 1;
        }
        if(dp[i][j]!=-1) return dp[i][j];

        if(s1.charAt(i)==s2.charAt(j) || s1.charAt(i)=='?'){
            return dp[i][j]=(rec(s1, s2, i-1, j-1)?1:0);
        }
        else if(s1.charAt(i)=='*')
            return dp[i][j]=(rec(s1, s2, i-1, j)|| rec(s1, s2, i, j-1)?1:0);

        return dp[i][j]=0;
    } 
    public static boolean rec(String s1,String s2,int i,int j){
        if(i<0 && j<0) return true;
        if(i<0 && j>=0) return false;

        if(j<0 && i>=0){
            for(int idx=0;idx<=i;idx++){
                if(s1.charAt(idx)!='*') return false;
            }
            return true;
        }
        if(s1.charAt(i)==s2.charAt(j) || s1.charAt(i)=='?'){
            return rec(s1, s2, i-1, j-1);
        }
        else if(s1.charAt(i)=='*')
            return rec(s1, s2, i-1, j)|| rec(s1, s2, i, j-1);

        return false;
    }
}
