public class sort012 {
    // Count sort with 2 passes
    static void displayArr(int[] arr){
        for(int val: arr){
            System.out.print(val+" ");
        }
        System.out.println();
    }

    static void sort012_(int[] num){
        int count_0=0, count_1=1, count_2=2;
        for(int j:num){
            if(j==0){
                count_0++;
            }
            else if(j==1){
                count_1++;
            }
            else{
                count_2++;
            }
        }
        int k=0;
        while(count_0>0){
            num[k++]=0;
            count_0--;
        }
        while(count_1>0){
            num[k++]=1;
            count_1--;
        }
        while(count_2>0){
            num[k++]=2;
            count_2--;
        }
    }


    // Method 2 with  1 pass
    static void swap(int[] a,int x,int y){
        int temp=a[x];
        a[x]=a[y];
        a[y]=temp;
    }

    static void Sorting012(int[] a){
        int lo=0, mid=0,hi=a.length-1;
        // explore the unknown region
        while(mid<=hi){
            if(a[mid]==0){
                swap(a, mid, lo);
                mid++;
                lo++;
            }
            else if(a[mid]==1){
                mid++;
            }
            else{
                swap(a, mid, hi);
                hi--;
            }
        }
    }

    public static void main(String[] args) {
        int[] num2={2,2,1,2,2,0,1,0,2,0};
        sort012_(num2);
        displayArr(num2);


        System.out.println("Sorting using second method");
        Sorting012(num2);
        displayArr(num2);
    }
}
