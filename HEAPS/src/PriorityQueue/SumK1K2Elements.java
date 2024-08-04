package PriorityQueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class SumK1K2Elements {
    public static void main(String[] args) {
        List<Integer> heap=new ArrayList<>();
        int k1=3;
        int k2=6;
        int sum=0;
        heap.add(20);
        heap.add(8);
        heap.add(22);
        heap.add(4);
        heap.add(12);
        heap.add(10);
        heap.add(14);

        PriorityQueue<Integer> pq=new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0;i<heap.size();i++){
            pq.add(heap.get(i));

            if(pq.size()>k2){
                pq.remove();
            }
        }
        pq.remove();  //so as to remove k2th element;

        while(pq.size()!=k1){
            sum+=pq.remove();
        }
        System.out.println(sum);
    }
}
