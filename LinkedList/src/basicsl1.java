public class basicsl1 {
    public static class Node{
        int data;  // value
        Node next;  //address of next node

        Node(int data){
            this.data=data;
        }
    }

    public static void displayR(Node head){
        if(head==null) return;
        System.out.print(head.data+" ");
        displayR(head.next);
    }

    public static void reverseLL(Node a){
        if(a==null) return;
        reverseLL(a.next);
        System.out.print(a.data+" ");
    }

    public static void display(Node a){
        Node temp=a;
        while(temp!=null){    // displaying
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }

    public static int count(Node head){
        int count=0;
        while(head!=null){
            count++;
            head=head.next;
        }
        return count;
    }

    public static void insertAtEnd(Node head,int val){
        Node temp=new Node(val);
        Node t=head;
        while(t.next!=null){
            t=t.next;
        }
        t.next=temp;
    }

    public static void main(String[] args) {
        Node a= new Node(5);
        Node b= new Node(3);
        Node c= new Node(9);
        Node d= new Node(10);
        Node e= new Node(311);
//        5 3 9 10 311
        a.next=b;  //        5->3 9 10 311
//        System.out.println(a.next.data);   //3
        b.next=c;
        c.next=d;
        d.next=e;
//        display(a);
        displayR(a);
        System.out.println();
        reverseLL(a);
        System.out.println();
        System.out.println(count(a));
        insertAtEnd(a,87);
        display(a);

    }
}
