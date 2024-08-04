public class questionBIS {
    static void sortFruits(String[] a){
        int n= a.length;
        for(int i=0;i<n-1;i++){
            int min_index=i;
            for(int j=i+1;j<n;j++){
                if(a[j].compareTo(a[min_index])<0){
                    min_index=j;
                }
            }

            String temp= a[i];
            a[i]= a[min_index];
            a[min_index]=temp;
        }
    }
    public static void main(String[] args) {
        // question 1
        // place all the zeroes in the last without sorting
        int[] arr={0,1,10,5,0,4};
        int n=arr.length;

        for(int i=0;i<n;i++){
            for(int j=0; j<n-i-1;j++){
                if(arr[j]==0 && arr[j+1]!=0){

                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        for(int i:arr){
            System.out.print(i+" ");
        }



        // question 2
        // sort the srray of string according to the lexographic order

        String[] fruits={"kiwi","apple","papaya","mango"};
        sortFruits(fruits);
        for(String val:fruits){
            System.out.print(val+" ");
        }
    }
}
