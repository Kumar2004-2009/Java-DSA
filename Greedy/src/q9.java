// insert intervals
import java.util.*;
public class q9 {
    public static void main(String[] args) {
        int[][] intervals={{1,2},{3,4},{6,7},{8,10},{12,16}};
        int[] newInterval={5,8};
        int[][] ans=insert(intervals,newInterval);
    }
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> arr=new ArrayList<>();
        int i=0;
        int n=intervals.length;

        while(i<n && intervals[i][1]<newInterval[0]){
            arr.add(intervals[i]);
            i++;
        }
        while(i<n && intervals[i][0]<=newInterval[1]){
            newInterval[0]=Math.min(newInterval[0],intervals[i][0]);
            newInterval[1]=Math.max(newInterval[1],intervals[i][1]);
            i++;
        }
        arr.add(newInterval);
        while(i<n){
            arr.add(intervals[i]);
            i++;
        }
        int[][] res=new int[arr.size()][2];
        for(int j=0;j<arr.size();j++){
            res[j]=arr.get(j);
        }
        return res;
    }
}
