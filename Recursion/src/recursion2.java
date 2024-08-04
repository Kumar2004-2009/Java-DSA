import java.util.*;
public class recursion2 {
    static void allIndices2(int[] a,int n,int x,int idx){
        // base case
        if(idx>=n) return;

        // self work
        if(a[idx]==x) System.out.println(idx);

        // recursive work
        allIndices2(a, n, x, idx+1);
    }

    static ArrayList<Integer> allIndices(int[] a,int n, int x,int idx){
        if(idx>=n){
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> ans= new ArrayList<>();
        if(a[idx]==x){
            ans.add(idx);
        }
        ArrayList<Integer> smallans=allIndices(a, n, x, idx+1);
        ans.addAll(smallans);
        return ans;
    }

    static int firstIndex(int[] a,int n,int target,int idx){
        if(idx==-1) return-1;
        if(a[idx]==target) return idx;
        return firstIndex(a, n, target, idx+1);
    }

    static int lastIndex(int[] a,int n,int target,int idx){
        if(idx==-1) return-1;
        if(a[idx]==target) return idx;
        return lastIndex(a, n, target, idx-1);
    }




    public static void main(String[] args) {
        int[] a={1,2,4,4,5,4};
        int target=4;
        int n=a.length;
        System.out.println(firstIndex(a, n, target, 0));
        System.out.println(lastIndex(a, n, target, n-1));
        allIndices(a, n, target, 0);
        ArrayList<Integer> ans=allIndices(a, n, target, 0);
        for(int i:ans){
            System.out.print(i+ ",");
        }


    }
}
