package Maze;

public class RatDeadMazeFinal {
    public static void main(String[] args){
        int rows=3;
        int cols=4;
        int[][] maze={{1,0},{1,0}};

        print(0,0,rows-1,cols-1,"",maze);
    }
    private static void print(int sr,int sc,int er,int ec,String s,int[][] maze){
        if(sr<0 ||sc<0) return;
        if(sr>er ||sc>ec) return;
        if(sr==er && sc==ec){
            System.out.println(s);
            return;
        }
        if(maze[sr][sc]==0) return;
        if(maze[sr][sc]==-1) return;
        maze[sr][sc]=-1;  // travelkar chuka hu
        print(sr+1,sc,er,ec,s+"D",maze);
//        go right
        print(sr,sc+1,er,ec,s+"R",maze);
//        go left
        print(sr,sc-1,er,ec,s+"L",maze);
//        go up
        print(sr-1,sc,er,ec,s+"U",maze);
//        backtracing
        maze[sr][sc]=1;   //travel nhi kiya hai
    }
}
