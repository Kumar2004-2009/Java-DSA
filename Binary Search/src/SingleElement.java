// Single Element in roated sorted array
import java.util.ArrayList;
public class Solution
{
    public static int singleNonDuplicate(ArrayList<Integer> arr)
    {
        //    Write your code here.
        int n=arr.size();
        if(n==1) return arr.get(0);
        if(!arr.get(0).equals(arr.get(1))) return arr.get(0);
        if(!arr.get(n-1).equals(arr.get(n-2))) return arr.get(n-1);
        int low=1;
        int high=n-2;
        while(low<=high){
            int mid=(low+high)/2;
            if(!arr.get(mid).equals(arr.get(mid-1)) && !arr.get(mid).equals(arr.get(mid+1))){
                return arr.get(mid);
            }
            if((mid%2==1 && arr.get(mid-1).equals(arr.get(mid))) || (mid%2==0 && arr.get(mid).equals(arr.get(mid+1)))){
                low=mid+1;
            }
            else high=mid-1;
        }
        return -1;
    }
}
