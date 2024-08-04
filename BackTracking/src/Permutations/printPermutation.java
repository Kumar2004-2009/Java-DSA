package Permutations;

import java.util.ArrayList;
import java.util.List;

public class printPermutation {
    public static void printp(String str,String t,List<String> l){
        if(str.equals("")){
            l.add(t);
            return;
        }
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            String left=str.substring(0,i);
            String right=str.substring(i+1);
            String res=left+right;
            printp(res,t+ch,l);
        }
    }
    public static void main(String[] args) {
        String str="abc";
        List<String> l=new ArrayList<>();
        printp(str,"",l);
        for(String e:l){
            System.out.print(e+" ");
        }
    }
}
