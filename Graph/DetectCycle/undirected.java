package Graph.DetectCycle;
import java.util.ArrayList;

public class undirected {
    private boolean dfs(int V, ArrayList<ArrayList<Integer>> adj,boolean vis[],int parent){
        vis[V]=true;
        
        for(int neigh:adj.get(V)){
            if(!vis[neigh]){
                if(dfs(neigh,adj,vis,V)) return true;
            }
            else if(parent!=neigh){
                return true;
            }
        }
        return false;
    }
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean vis[]=new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                if(dfs(i,adj,vis,-1)){
                    return true;
                }
            }
            
        }
        return false;
    }
}
