// Candy Problem
public class q12 {
    public static void main(String[] args) {
        int[] arr={0,2,4,3,2,1,1,3,5,6,4};
        candy(arr); // sc-O(2N)   tc-O(3N)
        candyI(arr); // sc-O(N)   tc-O(2N)
        candyII(arr);// sc-O(1)   tc-O(N)
    }
    private static void candyII(int[] a){
        int sum=1;
        int i=1;

        while(i<a.length){
            if(a[i]==a[i-1]){
                sum++;
                i++;
                continue;
            }
            int peak=1;
            while(i<a.length && a[i]>a[i-1]){
                peak+=1;
                sum+=peak;
                i++;
            }
            int down=1;
            while(i<a.length && a[i]<a[i-1]){
                sum+=down;
                i++;
                down+=1;
            }
            if(down>peak){
                sum+=down-peak;
            }
        }
        System.out.println(sum);

    }
    private static void candyI(int[] a){
        int n=a.length;
        int[] l=new int[n];
        l[0]=1;

        for(int i=1;i<n;i++){
            if(a[i]>a[i-1]){
                l[i]=l[i-1]+1;
            }
            else{
                l[i]=1;
            }
        }
        int curr=1;
        int r=1;
        int sum=Math.max(r, l[n-1]);

        for(int i=n-2;i>=0;i--){
            if(a[i]>a[i+1]){
                curr=r+1;
                r=curr;
            }
            else{
                curr=1;
            }
            sum+=Math.max(curr,l[i]);
        }
        System.out.println(sum);
    }
    private static void candy(int[] a){
        int n=a.length;
        int[] l=new int[n];
        int[] r=new int[n];
        l[0]=1;
        r[n-1]=1;

        for(int i=1;i<n;i++){
            if(a[i]>a[i-1]){
                l[i]=l[i-1]+1;
            }
            else{
                l[i]=1;
            }
        }
        for(int i=n-2;i>=0;i--){
            if(a[i]>a[i+1]){
                r[i]=r[i+1]+1;
            }
            else{
                r[i]=1;
            }
        }
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=Math.max(l[i],r[i]);
        }
        System.out.println(sum);
    }
}
