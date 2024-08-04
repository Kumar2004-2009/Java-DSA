import java.util.HashMap;

public class LargestSubArray {
    static int zeroSum(int[] arr,int n){
        HashMap<Integer,Integer> mp=new HashMap<>();
        int maxLen=0, prefSum=0;
        mp.put(0,-1);
        for(int i=0;i<arr.length;i++){
            prefSum+=arr[i];
            if(mp.containsKey(prefSum)){
                maxLen=Math.max(maxLen,i-mp.get(prefSum));
            }else{
                mp.put(prefSum,i);
            }
        }
        return maxLen;
    }
}
