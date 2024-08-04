package Maze;

public class RatInDeadMaze4Direction {
    public static void main(String[] args){
        int rows=3;
        int cols=4;
        int[][] maze={{1,0,1,1,1},
                {1,1,1,1,0},
                {0,1,1,1,1}};
        boolean[][] isvisted=new boolean[rows][cols];
        print(0,0,rows-1,cols-1,"",maze,isvisted);
    }
    private static void print(int sr,int sc,int er,int ec,String s,int[][] maze,boolean[][] isvisited){
        if(sr<0 ||sc<0) return;
        if(sr>er ||sc>ec) return;
        if(sr==er && sc==ec){
            System.out.println(s);
            return;
        }
        if(maze[sr][sc]==0) return;
        if(isvisited[sr][sc]==true) return;
        isvisited[sr][sc]=true;
        print(sr+1,sc,er,ec,s+"D",maze,isvisited);
//        go right
        print(sr,sc+1,er,ec,s+"R",maze,isvisited);
//        go left
        print(sr,sc-1,er,ec,s+"L",maze,isvisited);
//        go up
        print(sr-1,sc,er,ec,s+"U",maze,isvisited);
//        backtracing
        isvisited[sr][sc]=false;
    }
}
