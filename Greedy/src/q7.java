import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
class meetings{
    int st;
    int end;
    int pos;

    meetings(int st,int end,int pos){
        this.st=st;
        this.end=end;
        this.pos=pos;
    }
}
class meetingComparator implements Comparator<meetings>{
    @Override
    public int compare(meetings v1,meetings v2){
        if(v1.end>v2.end){
            return 1;
        }
        else if(v1.end<v2.end){
            return-1;
        }
        return 1;
    }
}
// N meetings in one room
public class q7 {
    public static void main(String[] args) {
        int n=6;
        int[] start={1,3,0,5,8,5};
        int[] end={2,4,5,7,9,9};
        maxMeetings(start,end,n);
    }
    private static void maxMeetings(int[] start, int[] end, int n){
        ArrayList<meetings> arr=new ArrayList<>();

        for(int i=0;i<n;i++){
            arr.add(new meetings(start[i], end[i], i+1));
        }
        meetingComparator mc=new meetingComparator();
        Collections.sort(arr,mc);

        ArrayList<Integer> ans=new ArrayList<>();
        ans.add(arr.get(0).pos);
        int freeTime=arr.get(0).end;

        for(int i=1;i<n;i++){
            if(arr.get(i).st > freeTime){
                ans.add(arr.get(i).pos);
                freeTime=arr.get(i).end;
            }
        }
        for(int i=0;i<ans.size();i++){
            System.out.print(ans.get(i)+" ");
        }
    }
}
