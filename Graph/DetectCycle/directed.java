package Graph.DetectCycle;
import java.util.ArrayList;
public class directed {
    private boolean dfs(int v,ArrayList<ArrayList<Integer>> adj,boolean[] vis,boolean[] recS){
        vis[v]=true;
        recS[v]=true;
        for(int neigh:adj.get(v)){
            if(!vis[neigh]){
                if(dfs(neigh,adj,vis,recS))
                    return true;
            }
            else if(recS[neigh]) return true;
        }
        recS[v]=false;
        return false;
    }
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean vis[]=new boolean[V];
        boolean recS[]=new boolean[V];
        
        for(int i=0;i<V;i++){
            if(!vis[i]){
                if(dfs(i,adj,vis,recS)){
                    return true;
                }
            }
        }
        return false;
    }
}
