public class longestCommonSubsequence {

    private static int rec(String s1,String s2,int i,int j, int[][] dp){
        if(i==0 ||j==0){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(s1.charAt(i-1)==s2.charAt(j-1)){
//            match
            return dp[i][j]=1+rec(s1,s2,i-1,j-1,dp);
        }
//        not match
        return dp[i][j]=Math.max(rec(s1,s2,i-1,j,dp),rec(s1,s2,i,j-1,dp));
    }

    public static void main(String[] args) {
        String s1="HARSH";
        String s2="SHARMA";
        int[][] dp=new int[s1.length()+1][s2.length()+1];
//        for(int i=0;i<=s1.length();i++){
//            for(int j=0;j<=s2.length();j++){
//                dp[i][j]=-1;
//            }
//        }

//        for(int j=0;j<=s2.length();j++){
//            dp[0][j]=0;
//        }
//        for(int i=0;i<=s1.length();i++){
//            dp[i][0]=0;
//        }

        int[] curr=new int[s2.length()+1];
        int[] prev=new int[s2.length()+1];
        for(int j=0;j<=s2.length();j++){
            prev[j]=0;
        }

        for(int i=1;i<=s1.length();i++){
            for(int j=1;j<=s2.length();j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
//            match
                    curr[j]=1+prev[j-1];
                }
//        not match
                else {
                    curr[j] = Math.max(prev[j], curr[j - 1]);
                }
            }
            prev=curr;
        }
        System.out.println(prev[s2.length()]);
//        System.out.println(dp[s1.length()][s2.length()]);
//        System.out.println(rec(s1,s2,s1.length(),s2.length(),dp));
    }
}
