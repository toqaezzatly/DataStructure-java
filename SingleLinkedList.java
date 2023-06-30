import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;







interface ILinkedList {
    public void addToIndex(int index, Object element);
    public void add(Object element);
    public Object get(int index);
    public void set(int index, Object element);
    public void clear();
    public boolean isEmpty();
    public void remove(int index);
    public int size();
    public ILinkedList sublist(int fromIndex, int toIndex);
    public boolean contains(Object o);
    public void printNodes();
}



public class SingleLinkedList implements ILinkedList {

    public class Node{

        int element;
        Node next;
        public Node(int element) {
            this.element = element;
        }
    }

    Node head;
    public int size(){
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


    public void addToIndex(int index,Object element) {

        int size;
        size=1;
        Node last=head;
        while(last.next!=null) {
            size=size+1;
            last=last.next;
        }
        Node tailNode=last;
        Node newNode = new Node((Integer) element);
        Node insertedNode = head;

        
        boolean flag = true;
        while (flag) {
            if (index < 0 || index > size) {
                System.out.println("Error");
                break;
            } else {

                if (index == 0 && head != null) {
                    newNode.next = head;
                    head = newNode;
                } else if (index == size) {
                    
                    tailNode.next = newNode;
                    tailNode = newNode;

                } else {
                    for (int i = 1; i < index; i++)
                        insertedNode = insertedNode.next;
                   
                    newNode.next = insertedNode.next;
                    insertedNode.next = newNode;
                    

                }


            }

            flag = false;


        }
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



    public Object get(int index) {
        Node search=head;
        int i=0;
        int size;
        if(head==null) {
            size=0;
        }
        else {
            size=1;
            Node last=head;
            while(last.next!=null) {
                size=size+1;
                last=last.next;
            }
        }
        if(index>=size || index <0 || head==null) {
            System.out.print("Error");
        }
        else {
            while(search!=null) {
                if(i==index)
                    break;
                i++;
                search=search.next;
            }
        }
        return search.element;
    }


    public void set(int index, Object element){


        Node last=head;
        for(int i=0 ; i<index ; i++) {
            last=last.next;
        }
        last.element= (int)element;
}



    public void clear() {
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
        Node C=head;
        Node N ;
        for(int i=0 ;i<size ;i++) {
            C=C.next;
            N=C;
            N=null;
        }
        head=null;
    }


    public boolean isEmpty() {
        if(head==null)
            return true ;
        else
            return false;
    }


    public void remove(int index) {

       if(index==0) {
    	   Node last = head;
    	   head=head.next;
    	   last = null;
       }
       else {
    	   Node temp = head;
    	   Node prev=null;
    	   for(int i=0 ; i<index && temp.next != null ; i++) {
    		   prev = temp;
    		   temp=temp.next;
    	   }
    	   prev.next=temp.next;
    	   temp=null;
       }       
    }


    public ILinkedList sublist(int fromIndex, int toIndex) {


        if(fromIndex<0 || fromIndex>size()-1 || toIndex<0 || toIndex>size()-1){
            System.out.print("Error");
        }

        ILinkedList n=new SingleLinkedList();
        Node startNode = head;
        int counter=0;
        while(startNode!=null){
            if(counter>=fromIndex && counter<=toIndex){
                n.add(startNode.element);
            }
            startNode=startNode.next;
            counter=counter+1;}

        return n;
    }




    public boolean contains(Object o) {
        int i = 1;
        boolean flag = false;
        //Node current will point to head
        Node current = head;




        //Checks whether the list is empty
        if(head == null) {
            flag=false;


        }
        while(current != null) {
            //Compare value to be searched with each node in the list
            if(current.element ==o.hashCode()) {
                flag = true;
                break;
            }
            current = current.next;
            i++;
        }

        return flag;
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

        ILinkedList List = new SingleLinkedList();
        Scanner sc = new Scanner(System.in);
        String sin = sc.nextLine().replaceAll("\\[|\\]", "");
        String[] s = sin.split(", ");
        if (s.length == 1 && s[0].isEmpty())
            List = new SingleLinkedList();
        else {
            for (int i = 0; i < s.length; ++i)
                List.add(Integer.parseInt(s[i]));
        }


        String method = sc.next();


        switch (method) {

            case ("add"):

                int number = sc.nextInt();
                List.add(number);
                List.printNodes();
                break;

            case ("addToIndex"):

                int x = sc.nextInt();
                int y = sc.nextInt();
                if (x >= List.size() || x < 0) {
                    System.out.print("Error");
                } else {  
                    List.addToIndex(x, y);
                    List.printNodes();
                }
                break;

            case ("get"):

                int x1 = sc.nextInt();
                if (x1 >= List.size() || x1 < 0) {
                    System.out.print("Error");
                } else {
                    Object r = List.get(x1);
                    System.out.print(r);
                }
                break;

            case ("set"):

                int x2 = sc.nextInt();
                int y2 = sc.nextInt();
                if (x2 >= List.size() || x2 < 0) {
                    System.out.print("Error");
                } else {
                    List.set(x2, y2);
                    List.printNodes();
                }
                break;

            case ("clear"):
                List.clear();
                List.printNodes();
                break;

            case ("isEmpty"):
                if (List.isEmpty())
                    System.out.print("True");
                else
                    System.out.print("False");
                break;

            case ("remove"):

                int x3 = sc.nextInt();
               
                if (x3 >= List.size() || x3 < 0) {
                    System.out.print("Error");
                } else {
                    List.remove(x3);
                    List.printNodes();
                }
                break;

            case ("sublist"):

                    int x4 = sc.nextInt();
                    int x5 = sc.nextInt();
                    if (x5 >= List.size() || x5 < 0 || x5 < x4 || x4>= List.size() || x4<0) {
                        System.out.print("Error");
                    }else {
                    SingleLinkedList List1 = new SingleLinkedList();
                    List1 = (SingleLinkedList) List.sublist(x4, x5);
                    List1.printNodes();}
                
                break;

            case ("contains"):

                int y3 = sc.nextInt();
                if (List.size() == 0) {
                    System.out.print("Error");
                } else if (List.contains(y3))
                    System.out.print("True");
                else
                    System.out.print("False");
                break;

            case ("size"):
                System.out.print(List.size());
                break;

            default:
                System.out.print("Error");

        }
    }

}