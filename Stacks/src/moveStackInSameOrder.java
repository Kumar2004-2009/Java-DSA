import java.util.Scanner;
import java.util.Stack;

public class moveStackInSameOrder {
//    public static void inputStack(Stack st,int n){
//        for(int i=1;i<=n;i++){
//            int x= sc.nextInt();
//            st.push(x);
//        }
//        System.out.println(st);
//    }
    public static void main(String[] args) {
        Stack<Integer> st=new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);

//        reverse order
        Stack<Integer> rt=new Stack<>();
        while(st.size()>0) {
//        int x=st.peek();
            rt.push(st.pop());
        }
        Stack<Integer> gt= new Stack<>();
        while(rt.size()>0){
            gt.push(rt.pop());
        }
        System.out.println(gt);
    }
}
