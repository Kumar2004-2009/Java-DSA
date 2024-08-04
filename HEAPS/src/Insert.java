import java.util.ArrayList;
import java.util.List;

public class Insert {
    public static void main(String[] args) {
        List<Integer> heap=new ArrayList<>();
        heap.add(60);
        heap.add(50);
        heap.add(40);
        heap.add(30);
        heap.add(20);
        heap.add(30);
        heap.add(10);
        System.out.println(heap);
//        insert_in_MinHeap(heap,40);
        insert_in_MaxHeap(heap,40);
        System.out.println(heap);
    }

    private static void insert_in_MinHeap(List<Integer> heap, int element) {
//        last me add
        heap.add(element);
        
        int index=heap.size()-1;
        push_up_minheap(heap,index);
    }

    private static void push_up_minheap(List<Integer> heap, int i) {
        int parent_index=(i-1)/2;

//        untill root reached
        if(i==0 || heap.get(parent_index)<heap.get(i)){
            return;
        }

//        swap
        swap(heap,i,parent_index);
        push_up_minheap(heap,parent_index);
    }
    private static void insert_in_MaxHeap(List<Integer> heap, int element) {
//        last me add
        heap.add(element);

        int index=heap.size()-1;
        push_up_maxheap(heap,index);
    }
    private static void push_up_maxheap(List<Integer> heap, int i) {
        int parent_index=(i-1)/2;

//        untill root reached
        if(i==0 || heap.get(parent_index)>heap.get(i)){
            return;
        }

//        swap
        swap(heap,i,parent_index);
        push_up_maxheap(heap,parent_index);
    }

    private static void swap(List<Integer> heap, int i, int parentIndex) {
        int temp=heap.get(i);
        heap.set(i,heap.get(parentIndex));
        heap.set(parentIndex,temp);

    }
}
