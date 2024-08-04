import java.util.HashMap;

public class TargetSum {
//    O(n^2)
    public int[] twoSum(int[] num,int target){
        int n=num.length;
        int[] ans={-1};
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(num[j]==target-num[i]){
                    ans=new int[]{i,j};
                    return ans;
                }
            }
        }
        return ans;
    }

    public int[] twoSum1(int[] num,int target){
        int n=num.length;
        int[] ans={-1};
        HashMap<Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<n;i++){
            int partner=target-num[i];
            if(mp.containsKey(partner)){
                ans=new int[]{i,mp.get(partner)};
                return ans;
            }
            mp.put(num[i],i);
        }
        return ans;
    }
}
