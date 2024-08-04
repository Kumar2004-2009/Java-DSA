// house robber-2
public class q6 {
    public static void main(String[] args) {
        int[] a={2,1,4,9};

        int[] a1={1,4,9};
        int a2[]={2,1,4};
        if(a.length==1) System.out.println(a[0]);
        int res=Math.max(rob(a1),rob(a2));
        System.out.println(res);
    }
    public static int rob(int[] a){
        int prev1=a[0];
        int prev2=0;

        for(int i=1;i<a.length;i++){
            int take=a[i]+(i-2>=0?prev2:0);
            int nontake=prev1;

            int cur=Math.max(take,nontake);
            prev2=prev1;
            prev1=cur;
        }
        return prev1;
    }
}
