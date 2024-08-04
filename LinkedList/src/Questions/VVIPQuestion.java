package Questions;

public class VVIPQuestion {
    class Node{
        int data;
        Node next;
        Node random;

        public Node(int data){
            this.data=data;
        }
    }
    public Node copyRandomList(Node head){
        Node head2=new Node(0);
        Node temp1=head;
        Node temp2=head2;
//        Deep copy
        while(temp1!=null){
            Node t=new Node(temp1.data);
            temp2.next=t;
            temp2=t;
            temp1=temp1.next;
        }
        head2=head2.next;
        temp2=head2;
        temp1=head;

//        Alternate connections
        Node temp=new Node(-1);
        while(temp1!=null){
            temp.next=temp1;
            temp1=temp1.next;
            temp=temp.next;

            temp.next=temp2;
            temp2=temp2.next;
            temp=temp.next;
        }
        temp2=head2;
        temp1=head;

//        Assigning random point
        while(temp1!=null){
            if(temp1.random==null) temp2.random=null;
            else temp2.random=temp.random.next;
            temp1=temp2.next;
            if(temp1!=null) temp2=temp1.next;
        }
        temp2=head2;
        temp1=head;

//        Separating the list
        while(temp1!=null){
            temp1.next=temp2.next;
            temp1=temp1.next;
            if(temp1==null) break;
            temp2.next=temp1.next;
            if(temp2.next==null) break;
            temp2=temp2.next;
        }
        return head2;
    }
}
