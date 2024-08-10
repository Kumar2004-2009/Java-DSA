public class Solution {
    public static double median(int[] a, int[] b) {
        int n=a.length;
        int m=b.length;
        int[] c=new int[n+m];
        int i=0,j=0,idx=0;;
        while(i<n && j<m){
            if(a[i]<b[j]){
                c[idx++]=a[i];
                i++;
            }
            else{
                c[idx++]=b[j];
                j++;
            }
        }
        while(i<n){
            c[idx++]=a[i++];
        }
        while(j<m){
            c[idx++]=b[j++];
        }
        int len=c.length;
        return (len%2==1?(double)c[len/2]:(double)(c[len/2]+c[(len/2)-1])/2);
    }
}


// Better Solution
public class Solution {
    public static double median(int[] a, int[] b) {
    	// Write your code here.
        int n=a.length;
        int m=b.length;
        int len=n+m;
        int cnt=0,idx1Ele=-1,idx2Ele=-1,idx1=len/2,idx2=(len/2)-1;
        int i=0,j=0;
        while(i<n && j<m){
            if(a[i]<b[j]){
                if(cnt==idx1) idx1Ele=a[i];
                if(cnt==idx2) idx2Ele=a[i];
                cnt++;
                i++;
            }
            else{
                if(cnt==idx1) idx1Ele=b[j];
                if(cnt==idx2) idx2Ele=b[j];
                cnt++;
                j++;
            }
        }
        while(i<n){
            if(cnt==idx1) idx1Ele=a[i];
            if(cnt==idx2) idx2Ele=a[i];
            cnt++;
            i++;
        }
        while(j<m){
            if(cnt==idx1) idx1Ele=b[j];
            if(cnt==idx2) idx2Ele=b[j];
            cnt++;
            j++;
        }
        if(len%2==1) return idx1Ele;
        return (((double)idx1Ele+idx2Ele)/2.0);
    }
}


// Optimized solution
public class Solution {
    public static double median(int[] a, int[] b) {
    	// Write your code here.
        int n1=a.length;
        int n2=b.length;
        if(n1>n2) return median(b, a);
        int n=n1+n2;
        int left=(n1+n2+1)/2;
        int low=0,high=n1;

        while(low<=high){
            int mid1=(low+high)>>1;
            int mid2=left-mid1;

            int l1=Integer.MIN_VALUE,l2=Integer.MIN_VALUE;
            int r1=Integer.MAX_VALUE,r2=Integer.MAX_VALUE;

            if(mid1<n1) r1=a[mid1];
            if(mid2<n2) r2=b[mid2];

            if(mid1-1>=0) l1=a[mid1-1];
            if(mid2-1>=0) l2=b[mid2-1];

            if(l1<=r2 && l2<=r1){
                if(n%2==1) return Math.max((double)l1,(double)l2);
                else return (double)(Math.max((double)l1,(double)l2)+Math.min((double)r1,(double)r2))/2.0;
            }
            else if(l1>r2) high=mid1-1;
            else low=mid1+1;
        }
        return 0;
    }
}
