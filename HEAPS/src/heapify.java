import java.util.ArrayList;
import java.util.List;

public class heapify {
    public static void heapify(List<Integer> arr){
        int first_non_leaf_node=((arr.size()-1)-1)/2;

        for(int i=first_non_leaf_node;i>=0;i--){
            push_down_in_MinHeap(arr,i,arr.size()-1);
        }
    }
    private static void push_down_in_MinHeap(List<Integer> heap, int index,int n) {
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
        push_down_in_MinHeap(heap,smallest,n);

    }
    private static void swap(List<Integer> heap, int i, int i1) {
        int temp=heap.get(i);
        heap.set(i,heap.get(i1));
        heap.set(i1,temp);
    }
    public static void main(String[] args) {
        List<Integer> heap=new ArrayList<>();
        heap.add(90);
        heap.add(80);
        heap.add(70);
        heap.add(20);
        heap.add(10);
        heap.add(50);
        heap.add(60);
        System.out.println(heap);
        heapify(heap);
        System.out.println(heap);
    }
}
