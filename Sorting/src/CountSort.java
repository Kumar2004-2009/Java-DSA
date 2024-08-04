public class CountSort {

    static int findMax(int[] arr) {
        int mx = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > mx) {
                mx = arr[i];
            }
        }
        return mx;
    }

    static void basicCountSort(int[] arr){
        int max=findMax(arr);
        int[] count=new int[max+1];
        for(int i=0;i<arr.length;i++){
            count[arr[i]]++;
        }


        int k=0;
        for(int i=0;i<count.length;i++){
            for(int j=0;j<count[i];j++){
                arr[k++]=i;
            }
        }

    }

    static void display(int[] arr){
        for(int val: arr){
            System.out.print(val+ " ");
        }
    }


    public static void main(String[] args) {
        int[] arrr={1,4,5,2,2,5};
        basicCountSort(arrr);
        display(arrr);
    }
}
