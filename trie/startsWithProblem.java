public class startsWithProblem {
    static class Node{
        Node[] children;
        boolean eow;

        public Node(){
            children = new Node[26];
            eow = false;
            for(int i=0;i<26;i++){
                children[i]=null;
            }
        }
    }
    static Node root=new Node();

    private static void insert(String word){
        Node curr=root;
        for(int i=0;i<word.length();i++){

            int idx=word.charAt(i)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new Node();
            }
            if(i== word.length()-1){
                curr.children[idx].eow=true;
            }
            curr=curr.children[idx];
        }
    }

    private static boolean startsWith(String key){
        Node curr=root;
        for(int i=0;i<key.length();i++){
            int idx=key.charAt(i)-'a';

            if(curr.children[idx]==null){
                return false;
            }
            curr=curr.children[idx];
        }
        return true;
    }
    public static void main(String[] args) {
        String[] words={"apple","app","mango","man","women"};
        for(int i=0;i<words.length;i++){
            insert(words[i]);
        }
        String prefix="moon";
        System.out.println(startsWith(prefix));

    }
}
