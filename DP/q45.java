// Longest String Chain
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class q45 {
    static Comparator<String> comp = (s1, s2) -> s1.length() - s2.length();
    public static void main(String[] args) {
        List<String> a = Arrays.asList("a", "b", "ba", "bca", "bda", "bdca");
        int n=a.size();
        a.sort(comp);

        int[] dp=new int[n];
        Arrays.fill(dp,1);
        int[] hash=new int[n];

        int maxi=1;
        int lastIndex=0;

        for(int i=0;i<n;i++){
            hash[i]=i;
            for(int prev=0;prev<i;prev++){
                if(compare(a.get(i),a.get(prev)) && 1+dp[prev]>dp[i]){

                    dp[i]=1+dp[prev];
                    hash[i]=prev;
                }
            }
            if(dp[i]>maxi){
                maxi=dp[i];
                lastIndex=i;
            }
        }

        System.out.println(maxi);
    }
    public static boolean compare(String s1,String s2){
        // Sorting using comparator
        
        if(s1.length()!=s2.length()+1) return false;

        int f=0;
        int s=0;
        while(f<s1.length()){
            if(s<s2.length() && s1.charAt(f)==s2.charAt(s)){
                f++;
                s++;
            }
            else{
                f++;
            }
        }
        if(f==s1.length() && s==s2.length()) return true;
        return false;
    }
}
