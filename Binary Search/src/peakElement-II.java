// Peak Element in 2D array
class Solution {
    public int maximum(int[][] a,int n,int col){
        int row=-1;
        int max=-1;
        for(int i=0;i<n;i++){
            if(a[i][col]>max){
                max=a[i][col];
                row=i;
            }
        }
        return row;
    }
    public int[] findPeakGrid(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        
        int low=0,high=m-1;
        while(low<=high){
            int mid=(low+high) >>1;
            
            int row=maximum(mat,n,mid);
            int left=(mid-1>=0)?mat[row][mid-1]:-1;
            int right=(mid+1<m)?mat[row][mid+1]:-1;
            
            if(mat[row][mid]>left && mat[row][mid]>right){
                return new int[]{row,mid};
            }
            else if(mat[row][mid]<left){
                high=mid-1;
            }
            else low=mid+1;
        }
        return new int[]{-1,-1};
    }
}
