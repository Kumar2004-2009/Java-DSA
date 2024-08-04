import java.util.Stack;

public class display {

    public static void displayReverse(Stack<Integer> st){
        if(st.size()==0) return;
        int top=st.pop();
        System.out.print(top+" ");
        displayReverse(st);
        st.push(top);
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
    public static void display(Stack<Integer> st){
        if(st.size()==0) return;
        int top=st.pop();
        display(st);
        st.push(top);
        System.out.print(top+" ");

    }
    public static void main(String[] args) {
        Stack<Integer> st=new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);

//        Stack<Integer> t= new Stack<>();
//        while(st.size()>0){
//            t.push(st.pop());
//        }
//        while(t.size()>0){
//            int x=t.pop();
//            System.out.print(x+" ");
//            st.push(x);
//        }

        int n=st.size();
        int[] arr= new int[n];
        for(int i=n-1;i>=0;i--){
            arr[i]=st.pop();
        }
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
            st.push(arr[i]);
        }
        System.out.println();
        display(st);

        bottomPush(st,7,2);
        System.out.println();
        System.out.print(st);

    }
}
