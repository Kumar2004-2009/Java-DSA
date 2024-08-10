// Capacity to Ship Packages With D days
import java.util.* ;
import java.io.*; 
public class Solution {
    public static boolean ifPossible(int[] w,int d,int cap){
        int day=1,load=0;
        for(int i=0;i<w.length;i++){
            if(load+w[i]>cap){
                day=day+1;
                load=w[i];
            }
            else{
                load+=w[i];
            }
        }
        if(day<=d) return true;
        return false;
    }
    public static int leastWeightCapacity(int[] weights, int d) {
        // Write your code here.
        int low=Integer.MIN_VALUE;
        int high=0;
        for(int i=0;i<weights.length;i++){
            low=Math.max(weights[i], low);
            high+=weights[i];
        }

        int ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(ifPossible(weights,d,mid)){
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
