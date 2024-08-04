// Best Time to sell and buy the stock-I
public class q35 {
    public static void main(String[] args) {
        int[] a={7,1,5,3,6,4};
        int n=a.length;

        int minNum=a[0];
        int profit=0;

        for(int i=1;i<n;i++){
            int prof=a[i]-minNum;
            profit=Math.max(prof,profit);
            minNum=Math.min(minNum,a[i]);
        }
        System.out.println(profit);
    }
}
