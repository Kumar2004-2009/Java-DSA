package Graph;

import java.util.ArrayList;

class Edge implements Comparable<Edge> {
    int src,dest,wt;

    Edge(int src,int dest,int wt){
        this.src=src;
        this.dest=dest;
        this.wt=wt;
    }
    public int compareTo(Edge that){
        return this.wt-that.wt;
    }
}

public class Kruskal {
    static int[] rank,parent;

    static void union(int x,int y){
        int xRoot=find(x),yRoot=find(y);

        if(xRoot == yRoot){
            return;
        }
        parent[yRoot]=xRoot;
    }
    static int find(int x){
        if(parent[x]==x){
            return x;
        }
        return find(parent[x]);
    }
    static int spanningTree(int V, int E, ArrayList<ArrayList<ArrayList<Integer>>> adj){
        

    }
}
