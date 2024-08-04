// Assign Cookies

import java.util.Arrays;

public class q1{
    public static void main(String[] args) {
        int[] greed={1,5,3,3,4};
        int[] s={4,2,1,2,1,3};
         System.out.println(maximumAssignCookies(greed,s));
    }

    private static int maximumAssignCookies(int[] greed, int[] s) {
        Arrays.sort(greed);
        Arrays.sort(s);
        int i=0;
        int j=0;
        int cnt=0;

        while(i<greed.length && j<s.length){
            if(s[j]>=greed[i]){
                cnt++;
                i++;
            }
            j++;
        }
        return cnt;
    }
}