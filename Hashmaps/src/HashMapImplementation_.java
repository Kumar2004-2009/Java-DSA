import java.util.*;
public class HashMapImplementation_ {
    static class myhashmap<K,V>{
        public static final int default_capacity=4;
        public static final float default_loadfactor=0.75f;
        private class Node{
            K key;
            V value;

            Node(K key,V value){
                this.key=key;
                this.value=value;
            }
        }

        private int n;
        private LinkedList<Node>[] buckets;
        private void initbuckets(int n){
            buckets=new LinkedList[n];
            for(int i=0;i< buckets.length;i++){
                buckets[i]=new LinkedList<>();
            }
        }
        private int hasfunc(K key){
            int hc=key.hashCode();
            return(Math.abs(hc))% buckets.length;
        }
        private int searchinbucket(LinkedList<Node> currbucket,K key){
            for(int i=0;i<currbucket.size();i++){
                if(currbucket.get(i).key==key){
                    return i;
                }
            }
            return -1;
        }
        public myhashmap(){
            initbuckets(default_capacity);
        }
        private void rehash(){
            LinkedList<Node>[] oldbuckets=buckets;
            initbuckets(oldbuckets.length*2);
            n=0;
            for(var bucket:oldbuckets){
                for(var node:bucket){
                    put(node.key, node.value);
                }
            }
        }
        public int size(){
            return n;
        }
        public void put(K key,V value){
            int bi=hasfunc(key);
            LinkedList<Node> currbucket=buckets[bi];
            int ei=searchinbucket(currbucket,key);
            if(ei==-1){
                Node node=new Node(key,value);
                currbucket.add(node);
                n++;
            }else{
                Node currnode=currbucket.get(ei);
                currnode.value=value;
            }
            if(n>=buckets.length*default_loadfactor){
                rehash();
            }
        }

        public V get(K key){
            int bi=hasfunc(key);
            LinkedList<Node> currbucket=buckets[bi];
            int ei=searchinbucket(currbucket,key);
            if(ei!=-1){
                Node currnode=currbucket.get(ei);
                return currnode.value;
            }
            return null;
        }

        public V remove(K key){
            int bi=hasfunc(key);
            LinkedList<Node> currbucket=buckets[bi];
            int ei=searchinbucket(currbucket,key);
            if(ei!=-1){
                Node currnode=currbucket.get(ei);
                V val=currnode.value;
                currbucket.remove(ei);
                n--;
                return val;
            }
            return null;
        }
        public int capacity(){
            return buckets.length;
        }
        public float load(){
            return (n*1.0f)/buckets.length;
        }

    }

    public static void main(String[] args) {
        myhashmap<String,Integer> map=new myhashmap<>();
        System.out.println("Testing put");
        map.put("a",1);
        map.put("b",2);
        System.out.println(map.capacity());
        System.out.println(map.load());
        map.put("c",3);
        map.put("f",61);
        map.put("y",45);

        System.out.println(map.size());
        map.put("c",30);
        System.out.println(map.get("a"));
        System.out.println(map.get("c"));
        System.out.println(map.get("d"));
        System.out.println(map.remove("c"));
        System.out.println(map.remove("c"));
        System.out.println(map.get("f"));

        System.out.println(map.capacity());
        System.out.println(map.load());
    }
}
