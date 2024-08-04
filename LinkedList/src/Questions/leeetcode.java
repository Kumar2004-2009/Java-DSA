package Questions;

public class leeetcode {
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }
//    Quest 1
    static void deleteNode(Node node){
        node.data= node.next.data;
        node.next=node.next.next;
    }
//    Ques 2
    public static Node nthNode(Node head, int idx){
        int size=0;
        Node temp=head;
        while(temp!=null){
            size++;
            temp=temp.next;
        }
        int a= size-idx+1;
        temp=head;
//        nth node from start
        for(int i=1;i<=a-1;i++){
            temp=temp.next;
        }
        return temp;

    }
    public static Node nthNode1(Node head,int idx){
        Node slow=head;
        Node fast=head;
        for(int i=1;i<=idx;i++){
            fast=fast.next;
        }
        while(fast!=null){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }

//    Ques3
    public static Node removeNth(Node head,int idx){
        Node slow=head;
        Node fast=head;
        for(int i=1;i<=idx;i++){
            fast=fast.next;
        }
        if(fast==null){
            head=head.next;
            return head;
        }
        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        slow.next=slow.next.next;
        return head;
    }

//    Ques4
    public static Node getIntersection(Node head1,Node head2){
        Node temp1=head1;
        Node temp2=head2;
        int lengthA=0;
        while(temp1!=null){
            lengthA++;
            temp1=temp1.next;
        }
        int lengthB=0;
        while(temp2!=null){
            lengthB++;
            temp2=temp2.next;
        }
        temp1=head1;
        temp2=head2;
        if(lengthA>lengthB){
            int steps=lengthA-lengthB;
            for(int i=1;i<=steps;i++){
                temp1=temp1.next;
            }
        }else{
            int step=lengthB-lengthA;
            for(int i=1;i<=step;i++){
                temp2=temp2.next;
            }
        }
        while(temp1!=temp2){
            temp1=temp1.next;
            temp2=temp2.next;
        }
        return temp1;
    }

//    Ques 5
    public static Node middle(Node head){
        Node slow=head;
        Node fast=head;
        while(fast.next.next!=null && fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    public static Node deleteMiddle(Node head){
        if(head.next==null)  return null;
        Node slow=head;
        Node fast=head;
        while(fast.next.next!=null && fast.next.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        slow.next=slow.next.next;
        return head;
    }
    public boolean CyleList(Node head){
        Node slow=head;
        Node fast=head;
        if(head==null || head.next==null) return false;
        while(fast!=null){
            if(slow==null) return false;
            slow=slow.next;
            if(fast.next==null)  return false;
            fast=fast.next.next;
            if(fast==slow) return true;
        }
        return false;
    }

    public Node cylceStartNode(Node head){
        Node slow=head;
        Node fast=head;
        if(head==null || head.next==null) return null;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast) break;
        }
        Node temp=head;
        while(temp!=slow){
            temp=temp.next;
            if(slow==null) break;
            slow=slow.next;
        }
        return slow;
    }
    public static void display(Node head){
        Node tem=head;
        while(tem!=null){
            System.out.print(tem.data+" ");
            tem=tem.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node a= new Node(100);
        Node b= new Node(13);
        Node c= new Node(4);
        Node d= new Node(5);
        Node e= new Node(12);
        Node f= new Node(10);
        a.next=b;
        b.next=c;
        c.next=d;
        d.next=e;
        e.next=f;
//        Node temp= nthNode(a,3);
//        System.out.println(temp.data);
//        Node q=nthNode1(a,3);
//        System.out.println(q.data);
//        display(a);
//        a= removeNth(a,6);
//        display(a);
        Node r=middle(a);
        System.out.println(r.data);
    }
}
