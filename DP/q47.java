// Number of LIS

import java.util.Arrays;

public class q47 {
    public static void main(String[] args) {
        int[] a={1,5,4,3,2,6,7,10,8,9};
        int n=a.length;

        int[] dp=new int[n];
        int[] cnt=new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(cnt, 1);

        int maxi=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(a[j]<a[i] && dp[j]+1>dp[i]){
                    dp[i]=1+dp[j];
                    cnt[i]=cnt[j];
                }
                else if(a[j]<a[i] && dp[j]+1==dp[i]){
                    cnt[i]+=cnt[j];
                }
            }
            if(dp[i]>maxi){
                maxi=dp[i];
            }
        }
        int nos=0;
        for(int i=0;i<n;i++){
            if(dp[i]==maxi){
                nos+=cnt[i];
            }
        }
        System.out.println(nos);
    }
}
