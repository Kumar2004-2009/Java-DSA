public class adjacencyMatrix{
    private static void addelement(int[][] a,int s,int d){
        a[s][d]=1;
        a[d][s]=1;
    }
    public static void main(String[] args) {
        int v=5;
        int e=10;

        int[][] matrix=new int[v+1][e+1];  // starting with1
        addelement(matrix, 1, 4);
        addelement(matrix, 1, 2);
        addelement(matrix, 1, 5);
        for(int i=1;i<6;i++){
            System.out.println(matrix[1][i]);
        }
    }
}