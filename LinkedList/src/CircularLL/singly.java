package CircularLL;

public class singly {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
        }
    }
    public static void display(Node head){
        Node temp=head.next;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }

    public static void main(String[] args) {
        Node a= new Node(5);
        Node b= new Node(3);
        Node c= new Node(9);
        Node d= new Node(10);
        Node e= new Node(311);
        a.next=b;
        b.next=c;
        c.next=d;
        d.next=e;
        e.next=a;
    }
}
