public class CircularQueueLL {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
        }
    }
    public static class Cql{
        Node head=null;
        Node tail=null;

        public void add(int val){
            Node temp=new Node(val);
            if(head==null)  head=tail=temp;
            else tail.next=temp;

            tail=temp;
            tail.next=head;
        }
        public int remove() throws Exception{
            if(head==null){
                throw new Exception("queue is empty");
            }
            int x;
            if(head==tail){
                x=head.data;
                head=null;
                tail=null;
            }
            else{
                Node temp=head;
                x=temp.data;
                head=head.next;
                tail.next=head;
            }
            return x;
        }
        public int peek(){
            if(head==null){
                System.out.println("Queue is empty");
                return -1;
            }
            return head.data;

        }
        public void display(){
            Node temp=head;
            while(temp.next!=head){
                System.out.print(temp.data+" ");
                temp=temp.next;
            }
            System.out.println(temp.data);
        }
    }
    public static void main(String[] args) throws Exception {
        Cql q=new Cql();
        q.add(1);
        q.add(2);
        q.display();
        System.out.println(q.remove());
        q.display();
        q.add(3);
        q.add(4);
        q.display();
        System.out.println(q.peek());
        q.remove();
        System.out.println(q.peek());

    }
}
