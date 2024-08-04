public class sortTwo {
    // quesion1  sort only two elements of ascending order sorted array
    static void display(int[] arr){
        for(int val: arr){
            System.out.print(val+" ");
        }
        System.out.println();
    }

    static void sortArr(int[] num){
        int n=num.length;
        int x=-1,y=-1;

        if(n<=1){   //corner case
            return;
        }
        // process all adjacent elements
        for(int i=1;i<n;i++){
            if(num[i-1]>num[i]){
                if(x==-1){      //1st conflict
                    x=i-1;
                    y=i;
                } else{         //2nd conflict
                    y=i;
                }
            }
        }

        // swap x,y in num
        int temp=num[x];
        num[x]=num[y];
        num[y]=temp;
    }


    public static void main(String[] args) {
        int[] num={3};
        sortArr(num);
        display(num);
    }
}
