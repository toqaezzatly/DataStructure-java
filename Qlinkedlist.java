import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;



interface IQueue {
    /* Inserts an item at the queue front.*/
    public void enqueue(Object item);
    /* Removes the object at the queue rear and returnsit.*/
    public Object dequeue();
    /* Tests if this queue is empty.*/
    public boolean isEmpty();
    public int size();
}




public class LinkedListQueue implements IQueue {

    public class Node{

        int element;
        Node next;
        public Node(int element) {
            this.element = element;
        }
    }

    Node head;


    public void enqueue(Object item) {
        Node newnode = new Node((Integer)item);
        if(head==null) {
            head=newnode ;
            newnode.next=null;
        }
        else {
            newnode.next=head;
            head=newnode;

        }
    }

    public Object dequeue() {
        Node last=head;
        Node prev=null;
        if(head.next==null) {
            head=null;
            return last;
        }else {
            while(last.next!=null) {
                prev=last;
                last=last.next;
            }
            prev.next=null;
            last=null;
            return prev;
        }
    }

    public boolean isEmpty() {
        if(head==null)
            return true ;
        else
            return false;
    }


    public int size() {
        int size;
        if(head==null)
            size=0;
        else {
            size=1;

            Node last=head;
            while(last.next!=null) {
                size=size+1;
                last=last.next;
            }}
        return size;
    }


    public void add(Object element) {

        Node newnode = new Node((Integer)element);
        if(head==null) {
            head=newnode ;
            newnode.next=null;
        }
        else {
            Node last=head;
            while(last.next!=null) {
                last=last.next;
            }
            last.next=newnode;
            newnode.next=null;
        }
    }

    public  void printNodes() {
        Node current = head;
        if(head == null) {
            System.out.println("[]");
            return;
        }
        System.out.print("[");
        while(current != null) {
            //Print each node and then go to next.
            System.out.print(current.element );
            if(current.next!=null)
                System.out.print(", ");
            current = current.next;
        }
        System.out.println("]");

    }


    public static void main(String[] args) {

        LinkedListQueue List = new LinkedListQueue();
        Scanner sc = new Scanner(System.in);
        String sin = sc.nextLine().replaceAll("\\[|\\]", "");
        String[] s = sin.split(", ");
        if (s.length == 1 && s[0].isEmpty())
            List = new LinkedListQueue();
        else {
            for (int i = 0; i < s.length; ++i)
                List.add(Integer.parseInt(s[i]));
        }


        String method = sc.next();


        switch (method) {

            case("enqueue"):
                int num = sc.nextInt();
                List.enqueue(num);
                List.printNodes();
                break;
            case("dequeue"):
                if(List.size()==0) {
                    System.out.print("Error");
                }else {
                    List.dequeue();
                    List.printNodes();
                }
                break;
            case("isEmpty"):
                if(List.isEmpty()) {
                    System.out.print("True");}
                else {
                    System.out.print("False");
                }
                break;
            case("size"):
                System.out.print(List.size());
                break;
            default:
                System.out.print("Error");
                break;
        }
    }

}