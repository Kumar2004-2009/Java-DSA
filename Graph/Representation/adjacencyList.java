import java.util.*;
public class adjacencyList {
    private static void addelement(ArrayList<ArrayList<Integer>> adj,int s,int d){
        adj.get(s).add(d);
        adj.get(d).add(s);
    }
    public static void main(String[] args) {
        int v=5;
        int e=10;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<=v;i++){
            adj.add(new ArrayList<>());
        }
    }
}
