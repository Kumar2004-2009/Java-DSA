// Kth Missing Positive Number
public class Solution {
    public static int missingK(int[] vec, int n, int k) {
        // Write your code here.
        int low=0;
        int high=vec.length-1;

        while(low<=high){
            int mid=low+(high-low)/2;
            int missing=vec[mid]-(mid+1);

            if(missing<k){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return low+k;
    }
}
