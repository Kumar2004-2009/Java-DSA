// Find the sqrt of element in LogN
import java.util.* ;
import java.io.*; 

public class Solution {

	public static int sqrtN(long N) {
		/*
		 * Write your code here
		 */
		 long l=1;
		 long h=N;
		 long ans=0;
		 while(l<=h){
			 long mid=l+(h-l)/2;
			 long sq=mid*mid;
			 if(sq==N) return (int)mid;
			 else if(sq>N){
				 h=mid-1;
			 }
			 else if(sq<N){
				 l=mid+1;
				 ans=mid;
			 }
		 }
		 return (int)ans;
	}
}
