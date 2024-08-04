public class FirstOccurence {
    static int firstOcc(int[] a,int x){
        int n=a.length;
        int st=0,end=n-1;
        int fo=-1;
        while(st<=end){
            int mid=st+(end-st)/2;
            if(a[mid]==x){
                fo=mid;
                end=mid-1;
            } else if(x<a[mid]){
                end=mid-1;
            } else{
                st=mid+1;
            }
        }
        return fo;
    }
    static int lastOcc(int[] a,int x){
        int n=a.length;
        int st=0,end=n-1;
        int fo=-1;
        while(st<=end){
            int mid=st+(end-st)/2;
            if(a[mid]==x){
                fo=mid;
                st=mid+1;
            } else if(x<a[mid]){
                end=mid-1;
            } else{
                st=mid+1;
            }
        }
        return fo;
    }


//    linear way
    public static int[] firLastOcu(int[] arr,int x){
        int first=-1,last=-1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==x){
                if(first==-1) first=i;
            }
            last=i;
        }
        return new int[]{first,last};
    }

    public static void main(String[] args) {
        int[] a={1,1,2,5,5,6,6,6};
        int x=5;
//        System.out.println(firstOcc(a,x));
        System.out.println(lastOcc(a,x));
    }
}
