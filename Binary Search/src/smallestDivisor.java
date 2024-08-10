// Find the smallest divisor for the threshold
public class Solution {
    public static boolean ifPossible(int[] a,int limit,int divisor){
        int ans=0;
        for(int i=0;i<a.length;i++){
            ans+=(int)Math.ceil((double)a[i]/(double)divisor);
        }
        if(ans<=limit) return true;
        return false;
    }
    public static int smallestDivisor(int arr[], int limit) {
        // Write your coder here
        int low=Integer.MAX_VALUE;
        int high=Integer.MIN_VALUE;

        for(int i=0;i<arr.length;i++){
            low=Math.min(low,arr[i]);
            high=Math.max(high,arr[i]);
        }
        int ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(ifPossible(arr,limit,mid)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
}
