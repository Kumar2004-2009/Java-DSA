// Print the Longest COmmon subsequence
public class q26 {
    public static void main(String[] args) {
        String a="abcde";
        String b="bdgek";
        int n1=a.length();
        int n2=b.length();

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
        int len=dp1[n1][n2];
        String ans[]=new String[len];

        for(int i=0;i<len;i++){
            ans[i]="$";
        }

        int idx=len-1;
        int k=n1,m=n2;
        while(k>0 && m>0){
            if(a.charAt(k-1)==b.charAt(m-1)){
                ans[idx]=a.charAt(k-1)+"";
                idx--;
                k--;
                m--;
            }
            else if(dp1[k-1][m]>dp1[k][m-1]){
                k--;
            }
            else{
                m--;
            }
        }
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i]+"");
        }
    }
}
