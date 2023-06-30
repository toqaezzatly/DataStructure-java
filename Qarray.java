import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


interface IQueue {
    /*** Inserts an item at the queue front.*/
    public void enqueue(Object item);
    /*** Removes the object at the queue rear and returnsit.*/
    public Object dequeue();
    /*** Tests if this queue is empty.*/
    public boolean isEmpty();
    /*** Returns the number of elements in the queue*/
    public int size();
}

class Solution<T> implements IQueue {
    static Object[] QArray;
    int rear; //where values are enqueued
    int front; //where values are dequeued
    int size;

    public Solution(int size) {
        this.size = size;
        QArray = new Object[this.size];
        rear = -1;
        front = -1;

    }

    public void enqueue(Object item) {
        if (isFull()) return;;

        rear=rear+1;
        QArray[rear] = item;

        if(front==-1)
            front=1;

    }

    @Override
    public Object dequeue() {
        if (isEmpty())
            return null;
        System.out.print(Arrays.deepToString(Arrays.copyOf(QArray, QArray.length - 2)));

        return null;
    }

    @Override
    public boolean isEmpty() {
        return (QArray[0]==null);
    }

    // It will be needed
    public boolean isFull() {
        return (rear == size-1);
    }

    @Override
    public int size() {
        if(QArray[0]==null) {
            return 0;
        }
        else {
            return QArray.length-1;}
    }
    public  void printQ() {

        if(isEmpty()) {
            System.out.println("[]");
            return;
        }
        System.out.print(Arrays.deepToString(QArray));



    }







    public static void main(String[] args) {

        int n=0;
        Scanner sc = new Scanner(System.in);
        String sin = sc.nextLine().replaceAll("\\[|\\]", "");
        String[] s = sin.split(", ");
        ;
        int[] arr = new int[s.length];
        n=s.length;
        Solution<Integer> queue = new Solution<>(n);
        Solution<Integer> tempqueue = new Solution<>(n+1);
        if (s.length == 1 && s[0].isEmpty())
            arr = new int[]{};
        else {
            for (int i = 0; i < s.length; ++i) {
                queue.enqueue(Integer.parseInt(s[i]));

            }
        }



        String method = sc.next();

        switch (method) {

            case("enqueue"):
                int num = sc.nextInt();
                if(QArray[0]==null) {
                    System.out.print("["+num+"]");
                }
                else {
                    tempqueue.enqueue(num);
                    for (int i = 0; i < s.length; ++i)
                        tempqueue.enqueue(Integer.parseInt(s[i]));
                    tempqueue.printQ();
                }
                break;
            case("dequeue"):
                if(queue.isEmpty()) {
                    System.out.print("Error");
                }
                else{
                    queue.dequeue();

                }
                break;
            case("isEmpty"):
                if(queue.isEmpty()) {
                    System.out.print("True");}
                else {
                    System.out.print("False");
                }
                break;
            case("size"):
                System.out.print(queue.size());
                break;
            default:
                System.out.print("Error");
                break;
        }
    }

}
