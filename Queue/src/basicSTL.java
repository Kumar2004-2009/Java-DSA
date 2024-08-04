import java.util.ArrayDeque;
import java.util.Queue;


public class basicSTL {
    public static void main(String[] args) {
        Queue<Integer> q=new ArrayDeque<>();  //LinkedList<>()
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
//        System.out.println(q.size());
//        System.out.println(q);
//        System.out.println(q.poll());   //q.remove()
//        System.out.println(q);
//        System.out.println(q.peek());  //or q.element


//        Qn:Print all the elements of the queue
        Queue<Integer> temp=new ArrayDeque<>();
        while(q.size()>0){
            System.out.println(q.peek());
            temp.add(q.remove());
        }
        while(temp.size()>0){
            q.add(temp.remove());
        }

    }
}
