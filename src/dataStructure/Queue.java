package dataStructure;

public class Queue {

    private Node first;
    private Node last;
    private int length;

    public class Node{
        public int getValue() {
            return value;
        }

        int value;
        Node next;

        Node(int value){
            this.value = value;
        }
    }

    public Queue(int value){
        Node newNode = new Node(value);
        first = newNode;
        last = newNode;
        length++;
    }

    public void getFirst(){
        if (first != null){
            System.out.println("Primeiro: " + first.value);
        } else {
            System.out.println("Lista vazia");
        }
    }

    public void getLast(){
        if (last != null){
            System.out.println("Ultimo: " + last.value);
        } else {
            System.out.println("Lista vazia");
        }
    }

    public void getLength(){
        System.out.println("Length: "+ length);
    }

    public void print(){
        System.out.println("#####################################");
        Node temp = first;
        while (temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
        System.out.println("#####################################");
    }

    public void enqueue(int value){
        Node newNode = new Node(value);
        if(length == 0){
            first = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
        length++;
    }

    public Node dequeue(){
        if (length == 0) return null;
        Node temp = first;
        if (length == 1) {
            first = null;
            last = null;
        } else {
            first = temp.next;
            temp.next = null;
        }
        length--;
        return temp;
    }

    public static void main(String[] args) {
        Queue myQueue = new Queue(2);

        myQueue.getFirst();
        myQueue.getLast();
        myQueue.getLength();
        myQueue.print();

        myQueue.enqueue(4);

        myQueue.getFirst();
        myQueue.getLast();
        myQueue.getLength();
        myQueue.print();

        myQueue.dequeue();

        myQueue.getFirst();
        myQueue.getLast();
        myQueue.getLength();
        myQueue.print();
    }
}
