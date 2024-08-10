// Search in rotated sorted array-I
class Solution {
    public int search(int[] nums, int target) {
        int n=nums.length;
        int l=0;
        int h=n-1;
        while(l<=h){
            int mid=l+(h-l)/2;

            if(nums[mid]==target){
                return mid;
            }
            else if(nums[l]<=nums[mid]){
                if(nums[l]<=target && target<=nums[mid]){
                    h=mid-1;
                }
                else{
                    l=mid+1;
                }
            }
            else{
                if(target<=nums[h] && target>=nums[mid]){
                    l=mid+1;
                }
                else h=mid-1;
            }
        }
        return -1;
    }
}


// Search in rotated sorted array-II
public class Solution {
    public static boolean searchInARotatedSortedArrayII(int []A, int key) {
        // Write your code here.
        int low=0;
        int high=A.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(A[mid]==key) return true;
            else if(A[mid]==A[low] && A[mid]==A[high]){
                low++;
                high--;
            }
            else if(A[mid]>=A[low]){
                if(key>=A[low] && A[mid]>=key) high=mid-1;
                else low=mid+1;
            }
            
            else{
                if(A[mid]<=key && A[high]>=key) low=mid+1;
                else high=mid-1;
            }
        }
        return false;
    }
}
