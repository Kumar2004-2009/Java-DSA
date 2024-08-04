import java.util.ArrayList;
import java.util.List;

public class sort {
    public static void sort(List<Integer> arr){
        heapify(arr);
        int n=arr.size()-1;
        for(int i=n;i>0;i--){
            swap(arr,0,i);
            push_down_in_MaxHeap(arr,0,i-1);
        }
    }
    public static void heapify(List<Integer> arr){
        int first_non_leaf_node=((arr.size()-1)-1)/2;

        for(int i=first_non_leaf_node;i>=0;i--){
            push_down_in_MaxHeap(arr,i,arr.size()-1);
        }
    }
    private static void push_down_in_MaxHeap(List<Integer> heap, int index,int n) {

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
        push_down_in_MaxHeap(heap,biggest,n);

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
        sort(heap);
        System.out.println(heap);
    }
}
