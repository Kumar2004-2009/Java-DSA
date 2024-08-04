public class AddTwoNumber {
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }
    public static Node addTwoNumber(Node h1,Node h2){
        Node result=new Node(0);
        Node temp=result;

        int num=0;
        while(h1!=null || h2!=null|| num!=0){
            int sum=0;
            if(h1!=null){
                sum+=h1.data;
                h1=h1.next;
            }
            if(h2!=null){
                sum+=h2.data;
                h2=h2.next;
            }
            sum+=num;
            num=sum/10;
            Node var=new Node(sum%10);
            temp.next=var;
            temp=var;
        }
        return result.next;
    }

    public static void display(Node h){
        Node temp=h;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node a=new Node(5);
        Node b=new Node(9);
        Node c=new Node(3);
        a.next=b;
        b.next=c;
        c.next=null;

        Node d=new Node(4);
        Node e=new Node(6);
        Node f=new Node(7);
        d.next=e;
        e.next=f;
        f.next=null;
        Node res=addTwoNumber(a,d);
        display(res);

    }
}
