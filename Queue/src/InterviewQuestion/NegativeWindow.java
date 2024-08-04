package InterviewQuestion;

import java.util.LinkedList;
import java.util.Queue;

public class NegativeWindow {
    public long[] firstNegative(long[] a,int n,int k){
        long[] res=new long[n-k+1];
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(a[i]<0){
                q.add(i);
            }
        }
        for(int i=0;i<n-k+1;i++){
            if(q.size()>0 && q.peek()<i) q.remove();
            if(q.size()>0 && q.peek()<=i+k-1){
                res[i]=a[q.peek()];
            }
            else if(q.size()==0) res[i]=0;
            else res[i]=0;
        }
        return res;
    }
}
