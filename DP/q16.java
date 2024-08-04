// Partition A set into 2 Subset with Minimum absolute Difference
import java.util.*;
public class q16 {
    public static void main(String[] args) {
        int[] a={1,2,3,4};
        int n=a.length;
        int sum=0;
        for(int i=0;i<a.length;i++){
            sum+=a[i];
        }
        boolean[][] dp1=new boolean[n][sum+1];
        for(int i=0;i<a.length;i++){
            dp1[i][0]=true;
        }
        if(a[0]<=sum)
        dp1[0][a[0]]=true;
        for(int i=1;i<a.length;i++){
            for(int target=1;target<sum+1;target++){
                boolean nontake=dp1[i-1][target];
                boolean take=false;
                if(target>=a[i]){
                    take=dp1[i-1][target-a[i]];
                }
                dp1[i][target]=take || nontake;
            }
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<=sum;i++){
            if(dp1[n-1][i]==true){
                int s1=i;
                int s2=sum-i;
                min=Math.min(min,Math.abs(s2-s1));
            }
        }
        System.out.println(min);
    }
}
