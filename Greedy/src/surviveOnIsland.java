import java.util.*;
public class surviveOnIsland {
    public static void main(String[] args) {
        int S=10;
        int M=2;
        int N=15;

        int total_No_days=S*M;
        double result;
        if((M>N) || (7*M>6*N)){
            result=-1;
            System.out.println("Cannot survive");
        }
        else{
            System.out.println("Yes survive");
            result=Math.ceil((double) total_No_days/N);  //double mai answer
        }
        System.out.println(result);
    }
}
