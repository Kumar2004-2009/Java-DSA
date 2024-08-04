package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Pair implements Comparable<Pair>{
    int wt;
    int v;
    Pair(int v,int wt){
        this.v=v;
        this.wt=wt;
    }
    public int compareTo(Pair that){
        return this.wt-that.wt;
    }
}
public class Prims {
    static int spanningTree(int V, int E, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        // Code Here.
        boolean[] vis=new boolean[V];
        PriorityQueue<Pair> q=new PriorityQueue<>();
        
        q.add(new Pair(0,0));
        int ans=0;
        while(q.size()!=0){
            Pair cur=q.remove();
            
            int u=cur.v;
            if(vis[u]){
                continue;
            }
            ans+=cur.wt;
            vis[u]=true;
            
            ArrayList<ArrayList<Integer>> neigh=adj.get(u);
            
            for(ArrayList<Integer> list:neigh){
                int vertex=list.get(0);
                int wt=list.get(1);
                if(vis[vertex]==false){
                    q.add(new Pair(vertex,wt));
                }
            }
        }
        return ans;
    }
}
