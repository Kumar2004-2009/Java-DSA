// Print the LIS

import java.util.Arrays;

public class q42 {
    public static void main(String[] args) {
        int[] a={10,9,2,5,3,7,101,18};
        int n=a.length;
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        int[] hash=new int[n];

        int maxi=1;
        int lastIndex=0;

        for(int i=0;i<n;i++){
            hash[i]=i;
            for(int prev=0;prev<i;prev++){
                if(a[prev]<a[i] && 1+dp[prev]>dp[i]){

                    dp[i]=1+dp[prev];
                    hash[i]=prev;
                }
            }
            if(dp[i]>maxi){
                maxi=dp[i];
                lastIndex=i;
            }
        }

        int lis[] =new int[maxi];
        lis[0]=a[lastIndex];
        int idx=1;
        while(hash[lastIndex]!=lastIndex && idx<maxi){
            lastIndex=hash[lastIndex];
            lis[idx++]=a[lastIndex];
        }
        for(int i=0;i<lis.length;i++){
            System.out.print(lis[i]+" ");
        }
    }
}
