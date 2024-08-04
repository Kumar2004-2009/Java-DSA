package PriorityQueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class kthLargest {
    public static void main(String[] args) {
        List<Integer> arr=new ArrayList<>();
        int k=3;
        arr.add(3);
        arr.add(7);
        arr.add(2);
        arr.add(9);
        arr.add(5);
        List<Integer> sortedArr=new ArrayList<>(arr);
        sortedArr.sort(Comparator.reverseOrder()); //O(NLOGN)
        System.out.println(sortedArr.get(k-1));

//        Better
        PriorityQueue<Integer> pq=new PriorityQueue<>();

        for(int i=0;i<arr.size();i++){
            if(pq.size()==k){

                if(pq.peek()<arr.get(i)){
                    pq.remove();
                    pq.add(arr.get(i));
                }
                continue;
            }
            pq.add(arr.get(i));
        }

        System.out.println(pq.peek());
    }
}
