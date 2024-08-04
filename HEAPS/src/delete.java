import java.util.ArrayList;
import java.util.List;


public class delete {
    public static void deleteFromMinHeap(List<Integer> heap){
        swap(heap,0,heap.size()-1);
        heap.remove(heap.size()-1);

        push_down_in_MinHeap(heap,0);
    }

    private static void swap(List<Integer> heap, int i, int i1) {
        int temp=heap.get(i);
        heap.set(i,heap.get(i1));
        heap.set(i1,temp);
    }

    private static void push_down_in_MinHeap(List<Integer> heap, int index) {
        int n=heap.size()-1;
        if(index==n){
            return;
        }
        int left=(2*index)+1;
        int right=(2*index)+2;

        int smallest=index;
        if(left<=n && heap.get(left)<heap.get(smallest)){
            smallest=left;
        }
        if(right<=n && heap.get(right)<heap.get(smallest)){
            smallest=right;
        }
        if(smallest==index){
            return;
        }

        swap(heap,index,smallest);
        push_down_in_MinHeap(heap,smallest);

    }
    public static void deleteFromMaxHeap(List<Integer> heap){
        swap(heap,0,heap.size()-1);
        heap.remove(heap.size()-1);

        push_down_in_MaxHeap(heap,0);
    }
    private static void push_down_in_MaxHeap(List<Integer> heap, int index) {
        int n=heap.size()-1;
        if(index==n){
            return;
        }
        int left=(2*index)+1;
        int right=(2*index)+2;

        int biggest=index;
        if(left<=n && heap.get(left)>heap.get(biggest)){
            biggest=left;
        }
        if(right<=n && heap.get(right)>heap.get(biggest)){
            biggest=right;
        }
        if(biggest==index){
            return;
        }

        swap(heap,index,biggest);
        push_down_in_MaxHeap(heap,biggest);

    }

    public static void main(String[] args) {
        List<Integer> heap=new ArrayList<>();
        heap.add(5);
        heap.add(20);
        heap.add(10);
        heap.add(40);
        heap.add(50);
        heap.add(30);
        heap.add(60);
        System.out.println(heap);
        deleteFromMinHeap(heap);
        System.out.println(heap);
    }
}
