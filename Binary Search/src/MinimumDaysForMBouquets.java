// Minimum Number of Days to Make m Bouquets
class Solution {
    public boolean ifPossible(int[] a,int day,int m,int k){
        int cnt=0,nb=0;
        for(int i=0;i<a.length;i++){
            if(day>=a[i]){
                cnt++;
            }
            else{
                nb+=(cnt/k);
                cnt=0;
            }
        }
        nb+=(cnt/k);
        if(nb>=m){
            return true;
        }
        return false;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int low=Integer.MAX_VALUE;
        for(int i=0;i<bloomDay.length;i++){
            low=Math.min(low,bloomDay[i]);

        }
        int high=Integer.MIN_VALUE;
        for(int i=0;i<bloomDay.length;i++){
            high=Math.max(high,bloomDay[i]);
        }
        int ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(ifPossible(bloomDay,mid,m,k)){
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
