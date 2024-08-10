// First and Last Occurence
import java.util.ArrayList;

public class Solution {
    public static int lowerbound(ArrayList<Integer> arr,int x){
        int low=0;
        int high=arr.size()-1;
        int first=-1;

        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr.get(mid)>=x){
                first=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return first;
    }
    public static int upperBound(ArrayList<Integer> arr, int x, int n){
        // Write your code here.
        int low=0;
        int high=n-1;
        int ans=n;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr.get(mid)>x){
                ans=mid;
                high=mid-1;
            }
            else
                low=mid+1;
        }
        return ans;
    }

    public static int[] firstAndLastPosition(ArrayList<Integer> arr, int n, int k) {
        // Write your code here.
        // int f=lowerbound(arr,k);
        // int l=upperBound(arr, k,n);
        // if(f==n || arr.get(f)!=k) return new int[]{-1,-1};
        // return new int[]{f,l-1};


        // Binary Search
        int first=-1;
        int l=0;
        int h=n-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(arr.get(mid)==k){
                first=mid;
                h=mid-1;
            }
            else if(arr.get(mid)<k){
                l=mid+1;
            }
            else{
                h=mid-1;
            }
        }
        int last=-1;
        l=0;
        h=n-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(arr.get(mid)==k){
                last=mid;
                l=mid+1;
            }
            else if(arr.get(mid)>k){
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return new int[]{first,last};
    }

};


// Count Occurence
public class Solution {
    public static int lowerbound(int[] arr,int x){
        int low=0;
        int high=arr.length-1;
        int first=arr.length;

        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]>=x){
                first=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return first;
    }
    public static int upperBound(int[] arr, int x, int n){
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
    public static int count(int arr[], int n, int x) {
        //Your code goes here
        int f=lowerbound(arr,x);
        int l=upperBound(arr, x,n);
        if(f==n || arr[f]!=x) return 0;
        return (l-1)-f+1;
    }
}
