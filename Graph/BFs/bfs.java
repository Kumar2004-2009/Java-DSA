import java.util.*;
public class bfs{
    private static boolean bfs(int v,ArrayList<ArrayList<Integer>>adj,int s,int d,int[] pred,int[] dis){
        Queue<Integer> q=new LinkedList<>();
        boolean vis[]=new boolean[v+1];
        for(int i=1;i<=v;i++){
            vis[i]=false;
            pred[i]=-1;
            dis[i]=Integer.MAX_VALUE;
        }
        vis[s]=true;
        dis[s]=0;
        q.add(s);
        while(!q.isEmpty()){
            int curr=q.remove();
            for(int i=0;i<adj.get(curr).size();i++){
                int neighbour=adj.get(curr).get(i);
                if(vis[neighbour]==false){
                    vis[neighbour]=true;
                    dis[neighbour]=dis[curr]+1;
                    pred[neighbour]=curr;
                    q.add(neighbour);

                    if(neighbour==d){
                        return true;
                    }
                }
                
            }
        }
        return false;
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int v=6;
        int e=8;

        int pred[]=new int[v+1];
        int d[]=new int[v+1];

        boolean ans=bfs(6, adj, 1, 6, pred, d);
    }
}