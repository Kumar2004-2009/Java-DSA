public class selectionSort {
    static void selectionSort(int[] a){
        int n=a.length;

        for(int i=0;i<n-1;i++){

            // find the minimum element in the unsorted array
            int min_index=i;
            for(int j=0;j<n;j++){
                if(a[j]<a[min_index]){
                    min_index=j;
                }
            }

            int temp=a[i];
            a[i]=a[min_index];
            a[min_index]=temp;
        }
    }
    public static void main(String[] args) {
        int[] arr={7,6,4,5,1,2};
        selectionSort(arr);
        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]+" ");
        }
    }
}
