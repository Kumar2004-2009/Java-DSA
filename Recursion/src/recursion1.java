public class recursion1 {
    // searching of an element in the array
    static boolean search(int[] a,int n,int target,int idx){
        // base case
        if(idx>=n) return false;

        // self work
        if(a[idx]==target) return true;

        // recursive work
        return search(a, n, target, idx+1);
    }


    // first index of element of array
    static int findIndex(int[] a,int n,int target,int idx){
        // base case
        if(idx>=n) return -1;
        // self work
        if(a[idx]==target) return idx;
        // recursive work
        return findIndex(a,n,target,idx+1);
    }



    public static void main(String[] args) {
        int[] a={1,2,4,4,4,5,6};
        int target=4;
        int n=a.length;
        System.out.println(findIndex(a,n,target,0));

        if(search(a,a.length,target,0)){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}


