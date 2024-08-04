// subset sum equal to k
import java.util.*;
public class q14 {
    public static void main(String[] args) {
        int[] a={2,3,1,1};
        System.out.println(rec(a.length-1,4,a));

        int[][] dp=new int[a.length][4+1];  
        for(int i=0;i<a.length;i++){
            for(int j=0;j<5;j++){
                dp[i][j]=-1;
            }
        }
        System.out.println(mem(a.length-1,4,a,dp));

        
        // Tabulation
        boolean[][] dp1=new boolean[a.length][5];
        for(int i=0;i<a.length;i++){
            dp1[i][0]=true;
        }
        dp1[0][a[0]]=true;
        for(int i=1;i<a.length;i++){
            for(int target=1;target<5;target++){
                boolean nontake=dp1[i-1][target];
                boolean take=false;
                if(target>=a[i]){
                    take=dp1[i-1][target-a[i]];
                }
                dp1[i][target]=take || nontake;
            }
        }
        System.out.println(dp1[a.length-1][4]);



        // space optimization
        boolean[] prev=new boolean[5];
        prev[0]=true;
        boolean[] cur=new boolean[5];
        cur[0]=true;
        if(a[0]<=4) prev[a[0]]=true;
        for(int i=1;i<a.length;i++){
            for(int target=1;target<5;target++){
                boolean nontake=prev[target];
                boolean take=false;
                if(target>=a[i]){
                    take=prev[target-a[i]];
                }
                cur[target]=take || nontake;
            }
            prev=cur;
        }
        System.out.println(prev[4]);
    }
    public static boolean mem(int idx,int target,int[] a,int[][] dp){
        if(target ==0) return true;
        if(idx==0) return a[0]==target;
        if(dp[idx][target]!=-1) return (dp[idx][target]==1?true:false);

        boolean nontake=mem(idx-1, target, a,dp);
        boolean take=false;
        if(target>=a[idx]){
            take=mem(idx-1, target-a[idx], a,dp);
        }
        dp[idx][target]=(take|| nontake==true?1:0);
        return take|| nontake;
    }
    public static boolean rec(int idx,int target,int[] a){
        if(target ==0) return true;
        if(idx==0) return a[0]==target;

        boolean nontake=rec(idx-1, target, a);
        boolean take=false;
        if(target>=a[idx]){
            take=rec(idx-1, target-a[idx], a);
        }
        return take|| nontake;
    }
}
