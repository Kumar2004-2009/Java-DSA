// Longest Common Substring
public class q27 {
    public static void main(String[] args) {
        String a="abcjklp";
        String b="acjkp";
        int n1=a.length();
        int n2=b.length();

        int[][] dp1=new int[n1+1][n2+1];

        for(int i=0;i<=n1;i++){
            dp1[i][0]=0;
        }
        for(int j=0;j<=n2;j++){
            dp1[0][j]=0;
        }
        int max=0;
        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                if(a.charAt(i-1)==b.charAt(j-1)){
                    dp1[i][j]=1+(dp1[i-1][j-1]);
                    max=Math.max(max,dp1[i][j]);
                }
                else dp1[i][j]=0;
            }
        }
        System.out.println(max);
    }
}
