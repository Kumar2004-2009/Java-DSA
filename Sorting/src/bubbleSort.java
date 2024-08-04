public class bubbleSort {
    static void bubbleSort(int[] a){

        int n= a.length;

        // n-1 iteration
        for(int i=0;i<n-1;i++){
            boolean flag=false;
            for(int j=0;j<n-i-1;j++){

                //
                // last i elements are already at correct sorted position
                // no need to check them

                if(a[j]>a[j+1]){
                    int temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                    flag=true;  //some swap happens

                }
            }
            if(flag==false){
                return;
            }
        }

    }
    public static void main(String[] args) {
        int[] a={3,2,4,5,6};
        bubbleSort(a);

        for(int i:a){
            System.out.print(i+" ");
        }

    }
}
