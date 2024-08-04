package HashSet;

import java.util.HashSet;

public class LomgestConsecutive {
    public static int longestConsecutivr(int[] num){
        HashSet<Integer> st= new HashSet<>();
        for(int n: num){
            st.add(n);
        }
        int maxStreak=0;
        for(int n:st){
            if(!st.contains(n-1)) {
                int currrNum = n;
                int currStreak = 1;
                while (st.contains(currrNum + 1)) {
                    currStreak++;
                    currrNum++;
                }
                maxStreak = Math.max(maxStreak, currStreak);
            }
        }
        return maxStreak;
    }
}
