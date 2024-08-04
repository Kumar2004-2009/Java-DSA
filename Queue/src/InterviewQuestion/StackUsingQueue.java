package InterviewQuestion;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    public static class Mystack{
        Queue<Integer> q=new LinkedList<>();

        public void push(int x){
            q.add(x);
        }
        public int top(){
            for(int i=1;i<=q.size()-1;i++){
                q.add(q.remove());
            }
            int val=q.peek();
            q.add(q.remove());
            return val;
        }
        public boolean empty(){
            if(q.size()==0) return true;
            return false;
        }
        public int pop(){
            for(int i=1;i<=q.size()-1;i++){
                q.add(q.remove());
            }
            int val=q.peek();
            q.remove();
            return val;
        }
    }

    public static void main(String[] args) {
        Mystack obj=new Mystack();
        obj.push(1);
    }
}
