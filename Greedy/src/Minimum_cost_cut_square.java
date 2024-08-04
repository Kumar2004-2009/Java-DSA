import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Minimum_cost_cut_square {
    public static void main(String[] args) {
        int M=6;
        int N=4;
        List<Integer> X=new ArrayList<>();
        List<Integer> Y=new ArrayList<>();
        X.add(2); X.add(1); X.add(3); X.add(1); X.add(4);
        Y.add(4); Y.add(1); Y.add(2);

        X.sort(Comparator.reverseOrder());  //O(MlogM)
        Y.sort(Comparator.reverseOrder());  //O(NlogN)
        int Horizontal_pieces=1;
        int Vertical_pieces=1;
        int i=0, j=0;
        int total_cost=0;

        while(i<M-1 && j<N-1){  //O(M)
            if(X.get(i)>Y.get(j)){
                total_cost+=X.get(i)*Horizontal_pieces;
                Vertical_pieces++;
                i++;
            }
            else{
                total_cost+=Y.get(j)*Vertical_pieces;
                Horizontal_pieces++;
                j++;
            }
        }
//        O(M/N)
        while(i<M-1){   //if seek hi baar chalega
            total_cost+=X.get(i)*Horizontal_pieces;
            i++;
        }
        while(j<N-1){
            total_cost+=Y.get(j)*Vertical_pieces;
            j++;
        }
        System.out.println(total_cost);
    }
}
