// Minimum number of platforms required

import java.util.Arrays;

public class q10 {
    public static void main(String[] args) {
        int[] arr={900,945,955,1100,1500,1800};
        int[] dep={920,1200,1130,1150,1900,2000};
        minimumPlatforms(arr,dep);
    }
    private static void minimumPlatforms(int[] a,int[] d){
        Arrays.sort(a);
        Arrays.sort(d);
        int i=0;
        int j=0;
        int maxCnt=0;
        int cnt=0;
        while(i<a.length && j<d.length){
            if(a[i]<d[j]){
                cnt++;
                i++;
            }
            else if(d[j]<a[i]){
                cnt--;
                j++;
            }
            maxCnt=Math.max(maxCnt,cnt);
        }
        System.out.println(maxCnt);
    }
}
