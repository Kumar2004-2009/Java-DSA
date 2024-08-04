// Maximum sum of non adjacent element
import java.util.*;
public class q5 {
    public static void main(String[] args) {
        int[] a={2,1,4,9};
        System.out.println(rec(a,a.length-1));
        int[] dp=new int[a.length];
        Arrays.fill(dp,-1);
        System.out.println(mem(a,a.length-1,dp));

        // Tabulation
        int[] dp1=new int[a.length];
        dp1[0]=a[0];

        for(int i=1;i<a.length;i++){
            int take=a[i]+(i-2>=0?dp1[i-2]:0);
            int nontake=dp1[i-1];

            dp1[i]=Math.max(take,nontake);
        }
        System.out.println(dp1[a.length-1]);


        // Space optimization
        int prev1=a[0];
        int prev2=0;
        for(int i=1;i<a.length;i++){
            int take=a[i]+(i-2>=0?prev2:0);
            int nontake=prev1;

            int cur=Math.max(take,nontake);
            prev2=prev1;
            prev1=cur;
        }
        System.out.println(prev1);

    }
    public static int mem(int[] a,int i,int[] dp){
        if(i==0){
            return a[i];
        }
        if(i<0) return 0;
        if(dp[i]!=-1) return dp[i];

        int pick=a[i]+mem(a,i-2,dp);
        int nonpick=mem(a, i-1,dp);
        return dp[i]=Math.max(pick, nonpick);
    }
    public static int rec(int[] a,int idx){
        if(idx==0){
            return a[idx];
        }
        if(idx<0) return 0;
        
        int pick=a[idx]+rec(a,idx-2);
        int nonpick=rec(a, idx-1);
        return Math.max(pick, nonpick);
    }
}
