// Buy and sell stock-IV
public class q38 {
    public static void main(String[] args) {
        int[] prices={3,2,6,5,0,3};
        int c=2;
        int[][] next=new int[2][c+1];
        int n=prices.length;

        for(int i=0;i<n+1;i++){
            for(int j=0;j<2;j++){
                next[j][0]=0;
            }
        }
        for(int i=n-1;i>=0;i--){
            int[][]  temp=new int[2][3];
            for(int j=0;j<2;j++){
                for(int k=1;k<3;k++){
                    if(j==1){
                        temp[j][k]=Math.max(next[0][k]-prices[i],
                        next[1][k]);
                    }
                    else{
                        temp[j][k]=Math.max(next[1][k-1]+prices[i],
                        next[0][k-1]);
                    }
                }
            }
            next=temp;
        }
        System.out.println(next[1][c]);
    }
}
