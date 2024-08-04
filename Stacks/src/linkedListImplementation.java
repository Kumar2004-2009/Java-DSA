public class linkedListImplementation {
    public static class Node{   //user defined data type
        int data;
        Node next;
        Node(int data){
            this .data=data;
        }
    }
    public static class Stack{   //user defined data structures
        private Node head=null;
        private int size=0;
        void push(int x){
            Node temp=new Node(x);
            temp.next=head;
            head=temp;
            size++;
        }
        int pop(){
            if(head==null){
                System.out.println("stack is empty");
                return -1;
            }
            int x=head.data;
            head=head.next;
            return x;
        }
        int peek(){
            if(head==null){
                System.out.println("stack is empty");
                return -1;
            }
            return head.data;
        }
        void displayrec(Node h){
            if(h==null) return;
            displayrec(h.next);
            System.out.print(h.data+" ");
        }
        void display(){
            displayrec(head);
            System.out.println();
        }
        void displayRev(){
            Node temp=head;
            while(temp!=null){
                System.out.println(temp.data+" ");
                temp=temp.next;
            }
            System.out.println();
        }
        int size(){   //getter
            return size;
        }
        boolean isEmpty(){
            if(size==0) return true;
            return false;
        }
    }
    public static void main(String[] args) {
        Stack st=new Stack();
        st.push(1);
        st.push(2);
        st.push(3);
        st.display();
//        System.out.println(st.size());
//        st.pop();
//        st.display();
//        System.out.println(st.peek());
    }
}
