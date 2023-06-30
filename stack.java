import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import java.util.*;


interface IStack   {

    public void addToIndex(int index, Object element);
    public void add(Object element);
    public Object get(int index);
    public void set(int index, Object element);
    public void clear();

    public Object remove(int index);


    public boolean contains(Object o);
    void printNodes();
    public void pop();

    public Object peek();
    public void push(Object element);

    public boolean isEmpty();
    public int size();
}


class Solution implements IStack {
    private static final Solution DLL = new Solution();
    public static int dlls = 0;

    class Node {
        int element;
        Node prev; //object
        Node next; //object

        public Node(int element) {
            this.element = element;
        }
    }

    Node headNode;
    Node tailNode;
    public void addToIndex(int index, Object element) {
        Node newNode = new Node((Integer) element);
        Node insertedNode = headNode;


        int temp = 0;
        boolean flag = true;
        while (flag) {
            if (index < 0 || index > dlls) {
                System.out.println("Error");
                break;
            }
            else {

                if (index == 0 && headNode != null) {
                    newNode.next = headNode;
                    headNode.prev = newNode;
                    headNode = newNode;
                } else if (index == dlls) {
                    newNode.prev = tailNode;
                    tailNode.next = newNode;
                    tailNode = newNode;

                } else {
                    for (int i = 1; i < index; i++)//Start from 1 since there is a special case for index=0
                        insertedNode = insertedNode.next;
                    // insertedNode.next is where the value is contained Not insertedNode
                    //then
                    newNode.next = insertedNode.next;
                    insertedNode.next = newNode;
                    newNode.prev = insertedNode;
                    newNode.next.prev = newNode;

                }
            }

            flag = false;


        }

    }


    public void add(Object element) {
        Node newNode = new Node((Integer) element);
        tailNode = headNode;
        newNode.next = null;


        if (headNode == null) {
            newNode.prev = null;
            headNode = newNode;
            return;

        } else {


            while (tailNode.next != null) {
                tailNode = tailNode.next;
            }
            tailNode.next = newNode;
            newNode.prev = tailNode;

        }
    }


    public Object get(int index) {
        Node current = headNode;
        int i=0;
        if(index >= dlls || index <0){
            System.out.println("Error");
            return null;

        }
        else {

            while (current != null) {
                if (i == index)
                    break;

                i++;
                current = current.next;
            }
        }
        return current.element;

    }

    public void set(int index, Object element) {

        Node last=headNode;
        for(int i=0 ; i<index ; i++) {
            last=last.next;
        }
        last.element= (int)element;

    }


    public void clear() {
        Node C=headNode;
        Node N ;
        for(int i=0 ;i<dlls ;i++) {
            C=C.next;
            N=C;
            N=null;
        }
        headNode=null;


    }

    @Override
    public boolean isEmpty() {
        boolean isempty;
        if (headNode == null){
            isempty=true;
        }
        else {
            isempty=false;
        }
        return isempty;

    }

    @Override
    public Object remove(int index) {


        if(index==0) {
            Node last = headNode;
            headNode=headNode.next;
            headNode.prev=null;
            last = null;
        }
        else {
            Node temp = headNode;
            Node prev=null;
            for(int i=0 ; i<index && temp.next != null ; i++) {
                prev = temp;
                temp=temp.next;
            }

            prev.next=temp.next;
            temp=null;
        }

        return null;
    }

    public int size() {
        int sizedll=0;
        Node current = headNode;
        if(headNode == null) {
            sizedll=0;
        }
        else {
            while (current != null) {
                if (current.next != null)
                    sizedll++;
                current = current.next;
            }
            sizedll++;
        }
        return sizedll;

    }



    @Override
    public boolean contains(Object o) {
        int i = 1;
        boolean flag = false;
        //Node current will point to head
        Node current = headNode;
        //Checks whether the list is empty
        if(headNode == null) {
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

    public void printNodes() {
        //Node current will point to head
        Node current = headNode;
        if(headNode == null) {
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

    public void delByVal (Node del) {
        boolean flag =true;
        while (flag){
            if(headNode == null || tailNode==null) {
                System.out.println("Error");
                break;
            }

            else{
                if (del == headNode) {
                    headNode = headNode.next;
                    headNode.prev = null;
                }
                else if (del==tailNode) {
                    tailNode=tailNode.prev;
                    tailNode.next=null;



                }//General Case


                else if(del.prev != null)
                    del.prev.next=del.next;
                del=null;

            }
            flag=false;
        }

    }
    @Override
    public void pop() {
        if (isEmpty())
            System.out.println("Error");
        remove(0);
        printNodes();

    }
    @Override
    public Object peek() {
        if (isEmpty())
            System.out.println("Error");
        System.out.println(get(0));
        return null;
    }

    @Override
    public void push(Object element) {
        addToIndex(0,element);
        printNodes();

    }


    public static void main(String[] args) {
        int sizeofdll=0;




        Scanner sc = new Scanner(System.in);
        String sin = sc.nextLine().replaceAll("\\[|\\]", "");
        String[] s = sin.split(", ");;
        LinkedList<String> List = new LinkedList<>();
        if (s.length == 1 && s[0].isEmpty())
            List = new LinkedList<>();
        else {
            for(int i = 0; i < s.length; ++i)
                DLL.add(Integer.parseInt(s[i]));


        }

        dlls= DLL.size();
        String method = sc.next();
        switch (method){
            case "pop":
                DLL.pop();

                break;
            case "push":
                int x = sc.nextInt();
                DLL.push(x);
                break;
            case "isEmpty":
                if(DLL.isEmpty())
                    System.out.println("True");
                else
                    System.out.println("False");
                break;
            case "peek":
                DLL.peek();
                break;
            case "size":
                System.out.println(DLL.size());
                break;
            default:
                System.out.println("Error");


        }





    }







}