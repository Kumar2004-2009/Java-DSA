// count partition with given differnce
import java.util.*;
public class q18 {
    public static void main(String[] args) {
        int[] a={5,2,6,4};
        int d=3;
        int n=a.length;

        int sum=0;
        for(int i=0;i<n;i++){
            sum+=a[i];
        }
        if(sum-d<0 || (sum-d)%2==1) System.out.println(0);
        else{
            int tar=(sum-d)/2;
            int[][] dp=new int[n][tar+1];
            for(int i=0;i<n;i++){
                for(int j=0;j<=tar;j++){
                    dp[i][j]=-1;
                }
            }
            System.out.println(mem(a, n-1, tar,dp));
        }
    }
    public static int mem(int[] a,int idx,int tar,int[][] dp){
        if(idx==0){
            if(tar==0 &&a[0]==0) return 2;
            if(tar==0) return 1;
            if(a[idx]==tar) return 1;
            else return 0;
        }
        if(dp[idx][tar]!=-1) return dp[idx][tar];

        int nonPick=mem(a, idx-1, tar, dp);
        int pick=0;
        if(tar>=a[idx]){
            pick=mem(a, idx-1, tar-a[idx], dp);
        }
        return dp[idx][tar]=pick+nonPick;
    }
}
