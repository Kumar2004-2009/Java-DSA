// Lower Bound
public class Solution {
    public static int lowerBound(int []arr, int n, int x) {
        // Write your code here
        int low=0;
        int high=n-1;
        int ans=n;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]>=x){
                ans=mid;
                high=mid-1;
                
            }
            else
                low=mid+1;
         }
        return ans;
        
    }
}


// Upper Bound
public class Solution {
    public static int upperBound(int []arr, int x, int n){
        // Write your code here.
        int low=0;
        int high=n-1;
        int ans=n;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]>x){
                ans=mid;
                high=mid-1;
            }
            else
                low=mid+1;
        }
        return ans;
    }
}


// Search and Insert Position
public class Solution {
    public static int searchInsert(int [] arr, int m){
        // Write your code here.
        int n=arr.length;
        int l=0;
        int h=n-1;
        int a=n;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(arr[mid]>=m){
                a=mid;
                h=mid-1;
            }
            else
                l=mid+1;
        }
        return a;
    }
}


// Ceil the floor
import java.util.* ;
import java.io.*; 

public class Solution {
    public static int[] getFloorAndCeil(int[] a, int n, int x) {
      // Wriute your code here.
        int l=0;
        int h=n-1;
        int ceil=-1;
        while(l<=h){
            int m=l+(h-l)/2;
            if(a[m]>=x){
                ceil=a[m];
                h=m-1;
            }
            else
                l=m+1;
        }
        l=0;
        h=n-1;
        int floor=-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(a[mid]<=x){
                floor=a[mid];
                l=mid+1;
            }
            else
                h=mid-1;
        }
       return new int[]{floor,ceil};
    }
    
}
