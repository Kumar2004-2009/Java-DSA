import java.util.*;
public class recursion4 {
    // PrintSSQ
    static void printSSQ(String s,String currAns){
        if(s.length()==0){
            System.out.println(currAns);
            return;
        }
        char curr=s.charAt(0);
        String remString=s.substring(1);
        printSSQ(remString, currAns+curr);  //add curr
        printSSQ(remString, currAns);  //do not add curr
    }


    // ReturnSSQ
    static ArrayList<String> getSSQ(String s){
        ArrayList<String> ans= new ArrayList<>();

        // base case
        if(s.length()==0){
            ans.add("");
            return ans;
        }

        char curr=s.charAt(0);
        ArrayList<String> smallAns=getSSQ(s.substring(1));
        for(String ss: smallAns){
            ans.add(ss);
            ans.add(curr+ss);
        }
        return ans;
    }



    // Subset sum
    static void subsetSum(int[] a,int n,int idx,int sum){
        if(idx>=n){
            System.out.println(sum);
            return;
        }
        subsetSum(a, n, idx+1, sum+ a[idx]);  //include
        subsetSum(a, n, idx+1, sum);  //exclude
    }

    public static void main(String[] args) {
        printSSQ("abc","");


        ArrayList<String> ans=getSSQ("abc");
        for(String ss:ans){
            System.out.println(ss);
        }


        int[] a={2,4,5};
        subsetSum(a, a.length, 0, 0);
    }
}
