// non overlaping intervals

import java.util.Arrays;

public class q8 {
    public static void main(String[] args) {
        int[][] intervals={{1,2},{2,3},{3,4},{1,3}};
        eraseOverlap(intervals);
    }
    private static void eraseOverlap(int[][] inter){
        Arrays.sort(inter,(a,b)->a[1]-b[1]);
        int cnt=1;
        int freeTime=inter[0][1];

        for(int i=1;i<inter.length;i++){
            if(inter[i][0] >= freeTime){
                cnt++;
                freeTime=inter[i][1];
            }
        }
        System.out.println(inter.length-cnt);
    }
}
