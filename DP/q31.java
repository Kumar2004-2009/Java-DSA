// Shortest Common Supersequence
public class q31 {
    public static void main(String[] args) {
        String s1="bleed";
        String s2="blue";
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
        
        System.out.println(n1+n2-dp1[n1][n2]);

        int len=dp1[n1][n2];
        String ans="";


        int k=n1,m=n2;
        while(k>0 && m>0){
            if(s1.charAt(k-1)==s2.charAt(m-1)){
                ans+=s1.charAt(k-1);
                k--;
                m--;
            }
            else if(dp1[k-1][m]>dp1[k][m-1]){
                ans+=s1.charAt(k-1);
                k--;
            }
            else{
                ans+=s2.charAt(m-1);
                m--;
            }
        }
        while(k>0){
            ans+=s1.charAt(k-1);
            k--;
        }
        while(m>0){
            ans+=s2.charAt(m-1);
            m--;
        }
        System.out.println(ans);
    
    }
}
