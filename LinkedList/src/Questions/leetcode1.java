package Questions;

public class leetcode1 {
//       Merge Two Sorted List withextra space
       public Node mergeTwoList(Node head1, Node head2){
              Node temp1=head1;
              Node temp2=head2;

              Node head= new Node(100);
              Node temp=head;

              while(temp1!=null && temp2!=null){
                     if(temp1.data< temp2.data){
                            Node a=new Node(temp1.data);
                            temp.next=a;
                            temp=a;
                            temp1=temp1.next;
                     }
                     else{
                            Node a=new Node(temp2.data);
                            temp.next=a;
                            temp=a;
                            temp2=temp2.next;
                     }

              }
              if(temp1==null){
                     temp.next=temp2;
              }
              if(temp2==null){
                     temp.next=temp1;
              }
              return head.next;
       }
//       Merge two List without extra space

       public Node Merge2(Node head1,Node head2){
              Node t1=head1;
              Node t2=head2;
              Node h= new Node(100);
              Node t=h;
              while(t1!=null && t2!=null){
                     if(t1.data<t2.data){
                            t.next=t1;
                            t=t1;
                            t1=t1.next;
                     }
                     else{
                            t.next=t2;
                            t=t2;
                            t2=t2.next;
                     }
              }
              if(t1==null){
                     t.next=t2;
              }
              else{
                     t.next=t1;
              }
              return h.next;
       }


//       Reversse Linked list
       public static void display(Node head){
              if(head==null){
                     System.out.println();
                     return;
              }
              System.out.print(head.data+" ");  //call
              display(head.next);    //recursive work
       }
       public static Node reverse(Node head){
              if(head.next==null)  return head;
              Node newhead=reverse(head.next);
              head.next.next=head;
              head.next=null;
              return newhead;
       }

//       Reverse Linked List without recursion
       public static Node reverWR(Node head){
              Node prev=null;
              Node curr=head;
              Node after=null;
              while(curr!=null){
                     after=curr.next;
                     curr.next=prev;
                     prev=curr;
                     curr=after;
              }
              return prev;
       }

       public boolean palindrome(Node head){
              Node slow=head;
              Node fast=head;
              while(fast.next!=null && fast.next.next!=null){
                     slow=slow.next;
                     fast=fast.next.next;
              }
              Node temp=reverWR(slow.next);
              slow.next=temp;  //connection
              Node p1=head;
              Node p2=slow.next;
              while(p2!=null){
                     if(p1.data!=p2.data) return false;
                     p1=p1.next;
                     p2=p2.next;
              }
              return true;
       }

//       Odd even indicies Linked List
       public Node oddEvenList(Node head){
              Node odd=new Node(0);
              Node even=new Node(0);
              Node tempo=odd;
              Node tempe=even;
              Node temp=head;
              while(temp!=null){
                     tempo.next=temp;
                     temp=temp.next;
                     tempo=tempo.next;

                     tempe.next=temp;
                     if(temp==null)  break;
                     temp=temp.next;
                     tempe=tempe.next;

              }
              odd=odd.next;
              even=even.next;
              tempo.next=even;
              return odd;
       }

       public static void main(String[] args) {
              Node a= new Node(3);
              Node b= new Node(5);
              Node c= new Node(1);
              Node d= new Node(2);
              Node e= new Node(4);
              a.next=b;
              b.next=c;
              c.next=d;
              d.next=e;
              e.next=null;
              display(a);
              a=reverse(a);
              display(a);
       }
}
