// Shortest Job First

import java.util.Arrays;

public class q3 {
    public static void main(String[] args) {
        int[] bt={4,3,7,1,2};
        System.out.println(shortestTime(bt));
    }

    private static int shortestTime(int[] bt) {
        Arrays.sort(bt);
        int sumStart=0;
        int cnt=0;
        for(int i=0;i<bt.length-1;i++){
            cnt=cnt+bt[i];
            sumStart+=cnt;
        }
        return sumStart/bt.length;
    }
}
