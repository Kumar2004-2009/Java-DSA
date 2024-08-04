package Maze;

public class FourDirecMazePath {
    public static void main(String[] args){
        int rows=3;
        int cols=3;
        boolean[][] isvisted= new boolean[rows][cols];  // default false
        print(0,0,rows-1,cols-1,"",isvisted);
    }
    private static void print(int sr,int sc,int er,int ec,String s,boolean[][] isvisited){
        if(sr>er ||sc>ec) return;
        if(sr<0 || sc<0) return;
        if(isvisited[sr][sc]==true) return;

        if(sr==er && sc==ec){
            System.out.println(s);
            return;
        }
        isvisited[sr][sc]=true;
//        go down
        print(sr+1,sc,er,ec,s+"D",isvisited);
//        go right
        print(sr,sc+1,er,ec,s+"R",isvisited);
//        go left
        print(sr,sc-1,er,ec,s+"L",isvisited);
//        go up
        print(sr-1,sc,er,ec,s+"U",isvisited);
//        backtracing
        isvisited[sr][sc]=false;
    }
}
