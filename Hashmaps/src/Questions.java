import java.util.HashMap;
import java.util.Map;

public class Questions {
    static void mostFrequent(int[] arr){
        int n=arr.length;
        Map<Integer,Integer> mp=new HashMap<>();
        int i=0;
        while(i<arr.length){

            if(mp.containsKey(arr[i])){
                mp.put(arr[i],mp.get(arr[i])+1);
            }else{
                mp.put(arr[i],1);
            }
            i++;
        }
        System.out.println(mp.entrySet());
        int max=1;
//        for(var e:mp.values()){
//            if(max< e){
//                max=e;
//            }
//        }
//        System.out.println(max);
        int anskey=-1;
        for(var e:mp.entrySet()){
            if(max<e.getValue()){
                max=e.getValue();
                anskey=e.getKey();
            }
        }
        System.out.println("Maximum frequency key is :"+anskey);

    }
    public static void main(String[] args) {
        int[] arr={1,2,3,1,4,1};
        mostFrequent(arr);

    }
}
