// Jump game-1
public class q4 {
    public static void main(String[] args) {
        int[] arr={3,2,1,0,4};
        System.out.println(reachLast(arr));
    }
    private static boolean reachLast(int[] a){
        int n=a.length;
        int maxIdx=0;
        int i=0;
        while(maxIdx<n){
            maxIdx=Math.max(maxIdx,i+a[i]);
            if(i<maxIdx){
                i++;
            }
            else{
                return false;
            }
        }
        return true;
    }
}
