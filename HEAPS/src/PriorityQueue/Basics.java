package PriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Basics {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(); //min heap
        PriorityQueue<Integer> pq1=new PriorityQueue<>(20);
        PriorityQueue<Integer> pq2=new PriorityQueue<>(pq);
        PriorityQueue<Integer> pq3=new PriorityQueue<>(Comparator.reverseOrder());  //max heap

//   priority queue jaise jaise element remove hota rehte hai by default vo ascending order
//   hote rahte hai

        pq.add(1);
        pq.add(2);
        pq.add(3);
        pq.add(4);
        pq.add(1);
        pq.offer(3);
        System.out.println(pq);
        System.out.println(pq.poll());
        System.out.println(pq);
        System.out.println(pq.poll());
        System.out.println(pq);
        System.out.println(pq.poll());
    }
}
