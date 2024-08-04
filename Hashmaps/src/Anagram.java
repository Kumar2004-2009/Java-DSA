import java.util.HashMap;

public class Anagram {
    static HashMap<Character,Integer> makeFrequency(String str){
        HashMap<Character,Integer> mp=new HashMap<>();
        for(int i=0;i<str.length();i++){
            Character ch=str.charAt(i);
            if(!mp.containsKey(ch)){
                mp.put(ch,1);
            }else{
                int currfreq=mp.get(ch);
                mp.put(ch,currfreq+1);
            }
        }
        return mp;
    }
    public boolean isAnagram(String s,String t){
        if(s.length()!=t.length()) return false;
        HashMap<Character,Integer> mp1=makeFrequency(s);
        HashMap<Character,Integer> mp2=makeFrequency(t);
        return mp1.equals(mp2);
    }

    public boolean isAnagram1(String s,String t){
        if(s.length()!=t.length()) return false;
        HashMap<Character,Integer> mp=makeFrequency(s);
        for(int i=0;i<t.length();i++){
            Character ch=t.charAt(i);
            if(!mp.containsKey(ch)) return false;
            int currfreq= mp.get(ch);
            mp.put(ch,currfreq-1);
        }

        for(Integer i:mp.values()){
            if(i!=0) return false;
        }
        return true;
    }
}
