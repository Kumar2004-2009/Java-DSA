// Longest Palindromic Subseequence
public class q28 {
    public static void main(String[] args) {
        String t="bbabcbcab";
        int n1=t.length();

        String s="";
        for(int i=n1-1;i>=0;i--){
            s+=t.charAt(i);
        }
        int n2=s.length();
        // Apply lcs
        int[][] dp1=new int[n1+1][n2+1];

        for(int i=0;i<=n1;i++){
            dp1[i][0]=0;
        }
        for(int j=0;j<=n2;j++){
            dp1[0][j]=0;
        }

        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                if(t.charAt(i-1)==s.charAt(j-1)){
                    dp1[i][j]=1+(dp1[i-1][j-1]);
                }
                else dp1[i][j]=Math.max(dp1[i-1][j],dp1[i][j-1]);
            }
        }
        System.out.println(dp1[n1][n2]);
    }
}
