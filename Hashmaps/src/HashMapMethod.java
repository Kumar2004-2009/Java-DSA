
import java.util.*;

public class HashMapMethod {
    static void HashMethod(){
        Map<String,Integer> mp=new HashMap<>();
//        adding
        mp.put("Love",21);
        mp.put("aman",13);
        mp.put("Rishi",22);
        mp.put("Raghav",26);
        mp.put("Kumar",19);
//        Getting the value via key
        System.out.println(mp.get("aman"));    // if key does exist then return null
//        Changing the value
        mp.put("Raghav",28);
//        removing the pair
        System.out.println(mp.remove("aman"));
        System.out.println(mp.remove("raj"));
//        Checking the key exist or not
        System.out.println(mp.containsKey("Rishi"));
        mp.putIfAbsent("Tanishka",19);
        mp.putIfAbsent("Manya",18);
//        get all the keys
        System.out.println(mp.keySet());
//        get all the entries
        System.out.println(mp.entrySet());
//        Traversing the entries
        System.out.println();
        for(String val:mp.keySet()){
            System.out.println("age of "+val+" is "+ mp.get(val));
        }
        System.out.println();
        for(Map.Entry<String,Integer> e:mp.entrySet()){
            System.out.println("age of "+e.getKey()+" is "+ e.getValue());
        }
        System.out.println();
        for(var e:mp.entrySet()){
            System.out.println("age of "+e.getKey()+" is "+ e.getValue());
        }
        System.out.println(mp.values());
    }

    public static void main(String[] args) {
        HashMethod();
    }
}
