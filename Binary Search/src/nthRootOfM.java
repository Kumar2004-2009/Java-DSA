// Find the nth root of Integer
public class Solution {
    public static int NthRoot(int n, int m) {
        // Write your code here.
        int l=1;
        int h=m;
        while(l<=h){
            int mid=l+(h-l)/2;
            int val=(int)Math.pow((double)mid,(double)n);
            if(val==m) return mid;

            else if(val>m) h=mid-1;

            else l=mid+1;
        }
        return -1;
    }
}
