import java.util.ArrayList;

public class maximumXor {
    static class Node{
        Node links[]=new Node[2];
    
        public Node(){
        }
        boolean containsKey(int ind){
            return (links[ind]!=null);
        }
        Node get(int ind){
            return links[ind];
        }
        void put(int ind,Node node){
            links[ind]=node;
        }
    }
    static Node root=new Node();
    public static void insert(int num){
        Node curr=root;
        for(int i=31;i>=0;i--){
            int bit=(num >> i) & 1;
            if(!curr.containsKey(bit)) {
                curr.put(bit, new Node());
            }
            curr=curr.get(bit);
        }
    }
    public static int getMax(int num){
        Node curr=root;
        int maxNum=0;
        for(int i=31;i>=0;i--){
            int bit=(num >> i) & 1;
            if(curr.containsKey(1-bit)){
                maxNum =maxNum | (1<<i);
                curr=curr.get(1-bit);
            }
            else{
                curr=curr.get(bit);
            }
        }
        return maxNum;
    }
    public static int maxXor(int n, int m,ArrayList<Integer> arr1,ArrayList<Integer> arr2){
        for(int i=0;i<n;i++){
            insert(arr1.get(i));
        }
        int maxi=0;
        for(int i=0;i<m;i++){
            maxi=Math.max(maxi, getMax(arr2.get(i)));
        }
        return maxi;
    }
    public static void main(String[] args) {
        
    }
}
