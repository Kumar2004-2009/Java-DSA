package PriorityQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MultiplyKTimesSmallest {
    public static void main(String[] args) {
        List<Integer> heap=new ArrayList<>();
        int k=3;
        heap.add(2);
        heap.add(4);
        heap.add(1);
        heap.add(3);
        heap.add(5);

        PriorityQueue<Integer> pq=new PriorityQueue<>(heap);
        for(int i=0;i<k;i++){
            int f=pq.remove();
            int s=pq.remove();
            pq.add(f*s);
        }
        while(pq.size()!=1){
            pq.remove();
        }
        System.out.println(pq.peek());
    }
}
