// fractional knapsack

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

class item{
    int val;
    int wt;

    item(int val,int wt){
        this.val=val;
        this.wt=wt;
    }
}
class itemComparator implements Comparator<item>{
    @Override
    public int compare(item v1,item v2){
        double f1=v1.val/v1.wt;
        double f2=v2.val/v2.wt;

        if(f1<f2){
            return 1;
        }
        else if(f1>f2){
            return -1;
        }
        return 1;
    }
}
public class q13 {
    public static void main(String[] args) {
        int W=90;
        int[][] arr={{100,20},{60,10},{100,50},{200,50}};
        fractional(W,arr);
    }
    private static void fractional(int w,int[][] a){
        ArrayList<item> arr=new ArrayList<>();

        for(int i=0;i<a.length;i++){
            arr.add(new item(a[i][0], a[i][1]));
        }
        itemComparator ic=new itemComparator();
        Collections.sort(arr,ic);

        double total=0;
        for(int i=0;i<a.length;i++){
            if(arr.get(i).wt <= w){
                total+=arr.get(i).val;
                w-=arr.get(i).wt;
            }
            else{
                double frac=arr.get(i).val /arr.get(i).wt;
                total+=(frac*w);
                break;
            }
        }
        System.out.println(total);
    }
}
