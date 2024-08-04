// Partition equal subset sum
import java.util.*;
public class q15 {
    public static void main(String[] args) {
        int a[]={5,5,8};
        int n=a.length;
        int sum=0;
        for(int i=0;i<a.length;i++){
            sum+=a[i];
        }
        if(sum%2!=0){
            System.out.println(false);
        }
        else{
            int target=sum/2;
            boolean[] prev=new boolean[target+1];
            boolean []cur=new boolean[target+1];
            prev[0]=cur[0]=true;
            if(a[0]<=target) prev[a[0]]=true;

            for(int i=1;i<n;i++){
                for(int tar=1;tar<=target;tar++){
                    boolean nontake=prev[tar];
                    boolean take=false;
                    if(tar>=a[i]){
                        take=prev[tar-a[i]];
                    }
                    cur[tar]=take || nontake;
                }
                prev=cur;
            }
            System.out.println(prev[target]);
        }
    }
}
