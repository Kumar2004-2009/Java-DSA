package PriorityQueue;

import java.util.*;

public class Median {
//    O(logN)
    private static void add(PriorityQueue<Integer> leftPq, PriorityQueue<Integer> rightPq ,int element){
        if(leftPq.isEmpty()){
            leftPq.add(element);
            return;
        }
//       agar left mai jna hai
        if(element<leftPq.peek()){
            if(leftPq.size()==rightPq.size()){
                leftPq.add(element);
            }
            else{
                rightPq.add(leftPq.remove());
                leftPq.add(element);
            }
        }
//       agar right mai jana hai
        else{
            if(leftPq.size()==rightPq.size()){
                leftPq.add(rightPq.remove());
                rightPq.add(element);
            }else{
                rightPq.add(element);
            }
        }
    }
//    O(1)
    private static double median(PriorityQueue<Integer> leftPq, PriorityQueue<Integer> rightPq){
        if(leftPq.isEmpty()) return -1;
        if(leftPq.size()-rightPq.size()==1){
            return leftPq.peek();
        }else{
            return (double) (leftPq.peek()+ rightPq.peek())/2;
        }
    }
    public static void main(String[] args) {

        PriorityQueue<Integer> leftpq=new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> rightpq=new PriorityQueue<>();
        add(leftpq,rightpq,15);
        System.out.println(median(leftpq,rightpq));
        add(leftpq,rightpq,10);
        System.out.println(median(leftpq,rightpq));
        add(leftpq,rightpq,5);
        add(leftpq,rightpq,20);
        System.out.println(median(leftpq,rightpq));
        add(leftpq,rightpq,25);
    }
}
