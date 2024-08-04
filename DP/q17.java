// Count Subsets with sum K
public class q17 {
    public static void main(String[] args) {
        int[] a={1,2,2,3};
        int n=a.length;
        int tar=3;
        System.out.println(rec(a,n-1,tar));

        int[][] dp=new int[n][tar+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<=tar;j++){
                dp[i][j]=-1;
            }
        }
        System.out.println(mem(a,n-1,tar,dp));


        // Tabualtion
        int[][] dp1=new int[n][tar+1];
        for(int i=0;i<n;i++){
            dp1[i][0]=1;
        }

        if(a[0]!=0 && a[0]<=tar) dp1[0][a[0]]=1;
        for(int i=1;i<n;i++){
            for(int j=1;j<=tar;j++){
                int nonPick=dp1[i-1][j];
                int pick=0;
                if(j>=a[i]){
                    pick=dp1[i-1][j-a[i]];
                }
                dp1[i][j]=pick+nonPick;
            }
        }
        System.out.println(dp1[n-1][tar]);



        // Space Optimization
        int[] prev=new int[tar+1];
        int[] cur=new int[tar+1];
        prev[0]=1;
        if(a[0]!=0 && a[0]<=tar) prev[a[0]]=1;

        for(int i=1;i<n;i++){
            for(int j=1;j<=tar;j++){
                int nonPick=prev[j];
                int pick=0;
                if(j>=a[i]){
                    pick=prev[j-a[i]];
                }
                cur[j]=pick+nonPick;
            }
            prev=cur;
        }
        System.out.println(prev[tar]);
    }
    public static int mem(int[] a,int idx,int tar,int[][] dp){
        if(tar==0) return 1;
        if(idx==0) return a[0]==tar ?1:0;
        if(dp[idx][tar]!=-1) return dp[idx][tar];

        int nonPick=mem(a, idx-1, tar, dp);
        int pick=0;
        if(tar>=a[idx]){
            pick=mem(a, idx-1, tar-a[idx], dp);
        }
        return dp[idx][tar]=pick+nonPick;
    }
    public static int rec(int[] a,int idx,int tar){
        if(idx==0){
            if(tar==0 &&a[0]==0) return 2;
            if(tar==0) return 1;
            if(a[idx]==tar) return 1;
            else return 0;
        }

        int nonPick=rec(a, idx-1, tar);
        int pick=0;
        if(tar>=a[idx]){
            pick=rec(a, idx-1, tar-a[idx]);
        }
        return pick+nonPick;
    }
}
