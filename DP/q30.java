// Minimum number of Operation(Insertion/Deletion) to make s1 to s2
public class q30 {
    public static void main(String[] args) {
        String s1="abcd";
        String s2="anc";
        int n1=s1.length();
        int n2=s2.length();

        int[][] dp1=new int[n1+1][n2+1];

        for(int i=0;i<=n1;i++){
            dp1[i][0]=0;
        }
        for(int j=0;j<=n2;j++){
            dp1[0][j]=0;
        }

        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp1[i][j]=1+(dp1[i-1][j-1]);
                }
                else dp1[i][j]=Math.max(dp1[i-1][j],dp1[i][j-1]);
            }
        }
        int deletion=n1-dp1[n1][n2];
        int insertion=n2-dp1[n1][n2];
        System.out.println(deletion+insertion);
    }
}
