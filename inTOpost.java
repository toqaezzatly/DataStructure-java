import java.util.*;


interface IExpressionEvaluator {

    public void addToIndex(int index, Object element);
    public Object add(Object element);
    public Object get(int index);
    public void set(int index, Object element);
    public void clear();

    public Object remove(int index);


    public boolean contains(Object o);
    void printNodes();
    public Object pop();

    public Object peek();
    public void push(Object element);

    public boolean isEmpty();
    public int size();

    public static String infixToPostfix(String expression) {
        return null;
    }

    public int evaluate(String expression);
}


class Solution implements IExpressionEvaluator {
    private static final Solution DLL = new Solution();
    public static int dlls = 0;

    class Node {
        char element;
        Node prev; //object
        Node next; //object

        public Node(char element) {
            this.element = element;
        }
    }

    Node headNode;
    Node tailNode;
    public void addToIndex(int index, Object element) {
        Node newNode = new Node((char) element);
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


    public Object add(Object element) {
        Node newNode = new Node((Character) element);
        tailNode = headNode;
        newNode.next = null;


        if (headNode == null) {
            newNode.prev = null;
            headNode = newNode;
            return element;

        } else {


            while (tailNode.next != null) {
                tailNode = tailNode.next;
            }
            tailNode.next = newNode;
            newNode.prev = tailNode;

        }
        return element;
    } public Object addf(Object element) {
        Node newNode = new Node((Character) element);
        headNode = tailNode;
        newNode.prev = null;


        if (tailNode == null) {
            newNode.next = null;
            tailNode = newNode;
            return element;

        } else {


            while (headNode.prev != null) {
                headNode = headNode.prev;
            }
            headNode.prev = newNode;
            newNode.next = headNode;

        }
        return element;
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
        last.element= (char)element;

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
    public Object pop() {
        if (isEmpty())
            throw new EmptyStackException();
        remove(0);
        printNodes();

        return null;
    }
    @Override
    public Object peek() {
        try {
            boolean empty = isEmpty();
        }catch ( EmptyStackException empty){return 0;}
        return get(0);

    }

    @Override
    public void push(Object element) {
        addToIndex(0,element);
        printNodes();


    }




    public boolean precedenceCheck(char inOp , char outOP){
        if (inOp =='^') return true;
        if(inOp=='*' ||inOp=='*') return (outOP != '^');
        if(inOp=='+' ||inOp=='-') return (outOP != '^' &&outOP != '/' &&outOP != '*'  );

        return false;
    }
    public boolean isOPerator(char operator){
        return (operator == '^' ||operator == '/' ||operator == '*' ||operator == '-' ||operator == '+' ||operator == '(' );
    }

    public static String infixToPostfix(String expression) {
        String strout="";
        Solution emptyDll= new Solution();
        for (int i=0 ; i<expression.length();i++){
            if(expression.charAt(i)==' ') continue;// to skip the whitespace
            char in=expression.charAt(i);
            if(in=='a' || in=='b'|| in=='c')// To check whether it is a number
                strout += expression.charAt(i);
            else if (expression.charAt(i)=='(')
                emptyDll.push('('); //continue
            else if ((char)emptyDll.peek()!=')'){
                strout +=(char)DLL.peek();
                DLL.pop();
            }
            else {  boolean b= !emptyDll.isEmpty()&&DLL.precedenceCheck(expression.charAt(i), (Character) emptyDll.peek());

                while(  b) {
                    strout+=emptyDll.peek();
                    emptyDll.pop();
                    b= !emptyDll.isEmpty()&&emptyDll.precedenceCheck(expression.charAt(i), (Character) emptyDll.peek());

                }
                emptyDll.push(expression.charAt(i));
            }
            while (!(emptyDll.isEmpty())){
                strout+=emptyDll.pop();
            }


        }


        return strout;
    }

    @Override
    public int evaluate(String expression) {
        return 0;
    }


    public static void main(String[] args) {
        int sizeofdll=0;

        IExpressionEvaluator DLL = new Solution();


        Scanner sc = new Scanner(System.in);
        String infix =sc.next();

//        for (int i=0 ; i<infix.length();i++)
//            DLL.add(infix.charAt(i));
        // Solution.infixToPostfix(infix);
        String a =sc.next().replaceAll("a=","");
        int A=Integer.parseInt(a);

        String b =sc.next().replaceAll("b=","");
        int B=Integer.parseInt(b);

        String c =sc.next().replaceAll("c=","");
        int C=Integer.parseInt(c);
        System.out.println(A);
        System.out.println(B);
        System.out.println(C);























    }










}