public class trie{
    static int ALPHABET_SIZE=26;
    static class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];

        // isEndOfWord is true if the node represents
        // end of a word
        boolean isEndOfWord;

        TrieNode() {
            isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++) children[i] = null;
        }
    };

    static void insert(TrieNode root, String key){
        TrieNode currNode=root;
        for(int i=0;i<key.length();i++){
            char temp=key.charAt(i);

            if(currNode.children[temp-'a']==null){
                TrieNode newNode=new TrieNode();
                currNode.children[temp-'a']=newNode;
            }
            currNode=currNode.children[temp-'a'];
        }
        currNode.isEndOfWord=true;
    }

    static boolean search(TrieNode root, String key){
        TrieNode currNode=root;
        for(int i=0;i<key.length();i++){
            char temp=key.charAt(i);

            if(currNode.children[temp-'a']==null){
                return false;
            }
            currNode=currNode.children[temp-'a'];
        }
        return currNode.isEndOfWord;
    }
}