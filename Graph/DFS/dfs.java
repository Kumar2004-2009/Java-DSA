import java.util.ArrayList;

public class dfs {
    private void dfS(int V,ArrayList<ArrayList<Integer>> adj,boolean[] vis,ArrayList<Integer> ans){
        // intially V=0 aur V=1
        vis[V]=true;
        ans.add(V);
        for(int neighbour:adj.get(V)){
            if(!vis[neighbour]){
                dfS(neighbour, adj, vis, ans);
            }
        }
    }
    public static void main(String[] args) {
        
    }
}
