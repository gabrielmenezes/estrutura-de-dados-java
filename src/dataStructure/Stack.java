package dataStructure;

public class Stack {

    private Node top;
    private int heigth;


    public class Node {
        public int getValue() {
            return value;
        }

        int value;
        Node next;

        Node(int value){
            this.value = value;
        }
    }

    public Stack(int value){
        Node newNode = new Node(value);
        this.top = newNode;
        heigth = 1;
    }

    public void getTop(){
        if (top != null){
            System.out.println("Topo: " + top.value);
        } else {
            System.out.println("Pilha vazia");
        }
    }

    public void getHeight(){
        System.out.println("Altura: " + heigth);
    }

    public void push(int value){
        Node newNode = new Node(value);
        if (heigth != 0) {
            newNode.next = top;
        }
        top = newNode;
        heigth++;
    }

    public Node pop(){
        if (heigth == 0) return null;
        if (heigth == 1){
            Node removed = top;
            top = null;
            heigth--;
            return  removed;
        }
        Node temp = top;
        top = temp.next;
        temp.next = null;
        heigth--;
        return temp;
    }

    public void print(){
        System.out.println("###################################");
        if(top == null) return;
        Node temp = top;
        while(temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
        System.out.println("###################################");
    }

    public static void main(String[] args) {
        Stack myStack = new Stack(4);
        myStack.push(5);
        myStack.push(4);
        myStack.push(3);
        myStack.getTop();
        myStack.getHeight();
        myStack.print();

        myStack.pop();
        myStack.pop();
        myStack.getTop();
        myStack.getHeight();
        myStack.print();

    }
}
