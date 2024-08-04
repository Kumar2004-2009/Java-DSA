package InterviewQuestion;
import java.util.*;

public class ReverseK {
    public static void main(String[] args) {
        Queue<Integer> q=new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        System.out.println(q);
        Stack<Integer> st=new Stack<>();
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the number element to be reversed");
        int k=sc.nextInt();

        for(int i=0;i<k;i++){
            st.push(q.remove());
        }
        while(st.size()>0){
            q.add(st.pop());  //4 5 3 2 1
        }
        int n=q.size();
        for(int i=0;i<n-k;i++){
            q.add(q.remove());
        }
        System.out.println(q);
    }
}
