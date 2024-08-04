package Graph.TopologicalSort;
import java.util.ArrayList;
import java.util.Stack;
public class topoDFS {
    static void dfs(int v,ArrayList<ArrayList<Integer>> adj,Stack<Integer> st,boolean[] vis){
        vis[v]=true;
        
        for(int neigh:adj.get(v)){
            if(!vis[neigh])
                dfs(neigh,adj,st,vis);
        }
        st.push(v);
    }
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        Stack<Integer> st=new Stack<>();
        boolean[] vis=new boolean[V];
        
        for(int i=0;i<V;i++){
            if(!vis[i])
                dfs(i,adj,st,vis);
        }
        
        int[] ans=new int[V];
        int idx=0;
        while(!st.isEmpty()){
            ans[idx++]=st.pop();
        }
        return ans;
    }
}
