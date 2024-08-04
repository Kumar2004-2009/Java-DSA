public class _2DSearching {
    static boolean searchMatrix(int[][] a,int target){
//       Qust 1:  number of rows=n, nu. of columns=m
        int n=a.length, m=a[0].length;

        int st=0, end=m*n-1;

        while(st<=end){
            int mid=st+(end-st)/2;
            int midElt=a[mid/m][mid%m];

            if(midElt== target) return true;

            if(target<midElt){
                end=mid-1;
            } else{
                st=mid+1;
            }
        }
        return false;
    }


    static boolean search(int[][] a,int target){
        int n=a.length, m=a[0].length;
        int i=0, j=m-1;

        while(i<n&& j>=0){
            if(a[i][j]==target) return true;

            if(target< a[i][j]){
                j--;  // move left
            } else{
                i++;  //move down
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] a={{1,3,5},{10,11,16},{23,30,34}};
        int target=34;
        System.out.println(searchMatrix(a,target));
    }
}
