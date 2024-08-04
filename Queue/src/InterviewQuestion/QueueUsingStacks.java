package InterviewQuestion;

import java.util.Stack;

public class QueueUsingStacks {
    public static class MyQueue{
        Stack<Integer> st=new Stack<>();
        Stack<Integer> helper=new Stack<>();

        public void push(int val){
//            st.push(val);
            if(st.size()==0) st.push(val);

            else{
                while(st.size()>0){
                    helper.push(st.pop());
                }
                st.push(val);
                while(helper.size()>0){
                    st.push(helper.pop());
                }
            }
        }
        public int pop(){
//            while(st.size()>1){
//                helper.push(st.pop());
//            }
//            int x=st.pop();
//            while(helper.size()>0){
//                st.push(helper.pop());
//            }
//            return x;
            return st.pop();
        }
        public int peek(){
//            while(st.size()>1){
//                helper.push(st.pop());
//            }
//            int x=st.peek();
//            while(helper.size()>0){
//                st.push(helper.pop());
//            }
//            return x;
            return st.peek();
        }
        public void display(){
            System.out.println(st);
        }
    }

    public static void main(String[] args) {
        MyQueue q=new MyQueue();
        q.push(1);
        q.push(2);
        q.display();
        System.out.println(q.pop());


    }
}
