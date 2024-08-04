public class doublyLL {
    public static class Node{
        int data;
        Node next;
        Node prev;
       Node(int data){
            this.data=data;
       }
    }
    public static void display(Node head){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }
    public static void display2(Node head){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.prev;
        }
        System.out.println();
    }
    public static void displayR(Node random){
        Node temp=random;
//        move it to backward
        while(temp.prev!=null){
            temp=temp.prev;
        }
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }

    public static Node insertAtHead(Node head,int val){
        Node t=new Node(val);
        t.next=head;
        head.prev=t;
        head=t;
        return t;
    }

    public static void inserAtTail(Node head,int val){
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        Node t= new Node(val);
        temp.next=t;
        t.prev=temp;
        temp=t;
    }

    public static void insertAtIndex(Node head,int idx,int val){
        Node s=head;
        for(int i=1;i<=idx;i++){
            s=s.next;
        }
//        s is st that idx
        Node r=s.next;
        Node t= new Node(val);
        s.next=t;
        t.prev=s;
        t.next=r;
        r.prev=t;
    }

    public static void deleteHead(Node head){
        head=head.next;
        head.prev=null;
        display(head);


    }
    public static void deleteTail(Node head){
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp=temp.prev;
        temp.next=null;
    }
    public static void deleteAtIndex(Node head,int idx){
        Node temp=head;
        if(idx==0) {
            deleteHead(temp);
            return;
        }

        for(int i=1;i<=idx;i++){
            temp=temp.next;
        }
        temp=temp.prev;
        temp.next=temp.next.next;
        temp.next.prev=temp;
    }

    public static boolean palindrome(Node head){
        Node h=head;
        Node temp=head;
        while(h.next!=null){
            h=h.next;
        }
        Node t=h;
        h=temp;
        while(h!=t){
            if(h.data!=t.data) return false;
        }
        return true;
    }

    public static void twoSum(Node head,int target){
        Node h=head;
        Node temp=head;
        while(h.next!=null){
            h=h.next;
        }
        Node t=h;
        h=temp;
        while(h.data<t.data){
//        while(h!=t && t.next!=h){     // for sorted  h.data<t.data
            if(h.data+t.data == target){
                System.out.print(h.data+" "+t.data);
                h=h.next;
                t=t.prev;
            }
            else if(h.data+t.data> target){
                t=t.prev;
            }
            else h=h.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node a=new Node(0);
        Node b=new Node(6);
        Node c=new Node(8);
        Node d=new Node(10);
        Node e=new Node(13);
        a.prev=null;
        a.next=b;
        b.prev=a;
        b.next=c;
        c.prev=b;
        c.next=d;
        d.prev=c;
        d.next=e;
        e.prev=d;
        e.next=null;
//        display2(e);
//        displayR(c);
//        display(a);
//        Node newhead=insertAtHead(a,35);
//        inserAtTail(a,90);
//        insertAtIndex(a,3,56);
//        display(newhead);
//        deleteTail(a);
//        a=deleteHead(a);
//        deleteAtIndex(a,0);

//        System.out.println(palindrome(a));

        twoSum(a,6);

    }
}
