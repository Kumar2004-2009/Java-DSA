import java.util.Stack;

public class reverseStack {
    public static void reverseStack(Stack<Integer> st){
        if(st.size()==1) return;
        int top=st.pop();
        reverseStack(st);
        bottomPush(st,top,0);

    }
    public static void bottomPush(Stack<Integer> st,int x,int idx){
        if(st.size()==idx){
            st.push(x);
            return;
        }
        int top=st.pop();
        bottomPush(st,x,idx);
        st.push(top);
    }
    public static void main(String[] args) {
        Stack<Integer> st=new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        System.out.println(st);

//        Stack<Integer> rt=new Stack<>();
//        while(st.size()>0){
//            rt.push(st.pop());
//        }
//        System.out.println(rt);
//        Stack<Integer> temp=new Stack<>();
//        while(rt.size()>0){
//            temp.push(rt.pop());
//        }
//        System.out.println(temp);
//        while(temp.size()>0){
//            st.push(temp.pop());
//        }
//        System.out.println(st);
        reverseStack(st);
        System.out.println(st);

////        Remove element from bottom
//        Stack<Integer> rt=new Stack<>();
//        while(st.size()>1){
//            rt.push(st.pop());
//        }
//        st.pop();
//        while(rt.size()>0){
//            st.push(rt.pop());
//        }
//        System.out.println(st);
//
////        Remove element from bottom at specific index
//        Stack<Integer> temp=new Stack<>();
//        int idx=2;
//        while(st.size()>idx){
//            temp.push(st.pop());
//        }
//        st.pop();
//        while(temp.size()>0){
//            st.push(temp.pop());
//        }
//        System.out.println(st);
    }
}
