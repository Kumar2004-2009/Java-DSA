public class LLImplementation {
    public static class Node{
        int data;
        Node next;
         Node(int data){
             this.data=data;
        }
    }
    public static class queueLL{
        Node head=null;
        Node tail=null;
        int size=0;
        public void add(int x){
            Node temp=new Node(x);
            if(size==0){
                head=tail=temp;
            }
            else{
                tail.next=temp;
                tail=temp;
            }
            size++;
        }
        public int peek(){
            if(size==0){
                System.out.println("Queue is empty");
                return -1;
            }
            return head.data;
        }
        public int remove(){
            if(size==0){
                System.out.println("Queue is empty");
                return -1;
            }
            int x=head.data;
            head=head.next;
            size--;
            return x;

        }
        public void display(){
            if(size==0){
                System.out.println("queue is empty");
                return;
            }
            Node temp=head;
            while(temp.next!=null){
                System.out.print(temp.data+" ");
                temp=temp.next;
            }
        }
    }
    public static void main(String[] args) {
        queueLL q1=new queueLL();
        q1.add(1);
        q1.add(2);
        q1.add(3);
        q1.display();
    }
}
