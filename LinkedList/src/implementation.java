import java.util.LinkedList;

public class implementation {
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static class linkedlist {
        Node head = null;
        Node tail = null;
        int size = 0;

        void insertAtEnd(int val) {
            Node temp = new Node(val);
            if (head == null) {
                head = temp;
            } else {
                tail.next = temp;
            }
            tail = temp;   //dono mai hii karna hai
            size++;
        }

        void display() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }

//        int size() {
//            Node temp = head;
//            int count = 0;
//            while (temp != null) {
//                count++;
//                temp = temp.next;
//            }
//            return count;
//        }

        void insertAtBeg(int val) {
            Node temp = new Node(val);

            if (head == null) {
                insertAtEnd(val);
            } else {
                temp.next = head;
            }
            head = temp;   // dono mai hi karna hai
            size++;
        }

        void inserAt(int idx, int val) {
            Node t = new Node(val);
            Node temp = head;
            if (idx == size) {
                insertAtEnd(val);
                return;
            }
            if (idx == 0) {
                insertAtBeg(val);
                return;
            } else if (idx < 0 && idx > size) {
                System.out.println("Wrong index");
                return;
            }
            for (int i = 1; i <= idx - 1; i++) {
                temp = temp.next;
            }
            t.next = temp.next;
            temp.next = t;

        }

        int getAt(int idx) {
            Node temp = head;
            if (idx < 0 && idx > size) {
                System.out.println("Wrong index");
                return -1;
            }
            for (int i = 1; i <= idx; i++) {
                temp = temp.next;
            }
            return temp.data;
        }

        void deleteAt(int idx){
            if(idx==0) {
                head=head.next;
                size--;
                return;
            }
            Node temp=head;
            for(int i=1;i<=idx-1;i++){
                temp=temp.next;
            }
            temp.next=temp.next.next;
            if(idx==size-1){
                tail=temp;
            }
            size--;
        }
    }


    public static void main(String[] args) {
        linkedlist ll = new linkedlist();
        ll.insertAtEnd(5);
        ll.insertAtEnd(10);
        ll.insertAtBeg(15);
        ll.display();

        ll.insertAtBeg(12);
        ll.display();
        ll.inserAt(3, 13);  //last par
        ll.display();
        System.out.println(ll.tail.data);
        System.out.println(ll.getAt(2));
        System.out.println(ll.size);

    }

}