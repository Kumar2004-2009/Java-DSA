import java.util.Arrays;

public class arrays {
    public static int missingNumber(int[] nums) {
        int n=nums.length;
        int var=0;
        boolean flag=false;
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            if(nums[i]!=i){
                flag=true;
                var=i;
                break;
            }
        }
        if(flag==true){
            return var;
        }
        return n;
    }

    public static void main(String[] args) {
        int[] arr={3,0,1};
        int res=missingNumber(arr);
        System.out.println(res);
    }
}
