package Graph.TopologicalSort;

import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;

public class topoBFS {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        int[] inDeg=new int[V];
        for(ArrayList<Integer> list:adj){
            for(int ele:list){
                inDeg[ele]++;
            }
        }
        ArrayList<Integer> arr=new ArrayList<>();
        
        int[] ans=new int[V];
        bfs(V,adj,arr,inDeg);
        int idx=0;
        for(int e:arr){
            ans[idx++]=e;
        }
        return ans;
        
        
        
    }
    static void bfs(int v,ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> arr,int[] inDeg){
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<v;i++){
            if(inDeg[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int curr=q.poll();
            arr.add(curr);
            
            for(int neigh:adj.get(curr)){
                if(--inDeg[neigh]==0){
                    q.add(neigh);
                }
            }
        }
    }
}
