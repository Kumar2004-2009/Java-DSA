// Minimum Insertions to Make String Palindromic
public class q29 {
    public static void main(String[] args) {
        String a="codingninjas";
        int n1=a.length();

        String b="";
        for(int i=n1-1;i>=0;i--){
            b+=a.charAt(i);
        }
        int n2=b.length();
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
                if(a.charAt(i-1)==b.charAt(j-1)){
                    dp1[i][j]=1+(dp1[i-1][j-1]);
                }
                else dp1[i][j]=Math.max(dp1[i-1][j],dp1[i][j-1]);
            }
        }
        System.out.println(a.length()-dp1[n1][n2]);
    }
}
