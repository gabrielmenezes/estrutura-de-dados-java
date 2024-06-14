package dataStructure;

public class LinkedList {

    private Node head;
    private Node tail;
    private int length;


    static class Node {
        String data;
        Node next;

        Node(String data){
            this.data = data;
        }
    }

    public LinkedList(String data){
        length = 1;
        Node newNode = new Node(data);
        head = newNode;
        tail = newNode;
    }

    public void getTail(){
        if (this.tail == null){
            System.out.println("List vazia.");
        } else {
            System.out.println("Tail: " + tail.data);
        }
    }

    public void getHead(){
        if (this.head == null){
            System.out.println("List vazia.");
        } else {
            System.out.println("Head: " + head.data);
        }
    }

    public void getLength(){
        System.out.println("List Length: " + this.length);
    }

    public void makeEmpty(){
        head = null;
        tail = null;
        length = 0;
    }

    public void print(){
        Node temp = this.head;
        System.out.println("###########################");
        while (temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println("###########################");
    }

    public void append(String data){
        Node newNode = new Node(data);
        if (length == 0){
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public Node removeLast(){
        if (length == 0){
            System.out.println("Lista vazia");
            return null;
        } else {
            Node pre = head;
            Node temp = null;
            while (pre.next != tail){
                pre = pre.next;
            }
            temp = tail;
            tail = pre;
            tail.next = null;
            length--;
            if(length == 0){
                head = null;
                tail = null;
            }
            return temp;
        }
    }

    public void prepend(String data){
        Node newNode = new Node(data);
        if (length == 0){
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public Node removeFirst(){
        if (length == 0){
            System.out.println("Lista vazia.");
            return null;
        } else {
            Node removed = head;
            head = head.next;
            removed.next = null;
            length --;
            if (length == 0){
                head = null;
                tail = null;
            }
            return removed;
        }
    }

    public Node get(int index){
        if (index >= length || index < 0){
            System.out.println("Fora da lista.");
            return null;
        } else {
            Node temp = head;
            for (int i = 0; i < index; i++){
                temp = temp.next;
            }
            return temp;
        }
    }

    public Node delete(int index){
        if (index < 0 || index >= length){
            return null;
        }
        if (index == 0) return removeFirst();
        if (index == length -1) return removeLast();

        Node prev = get(index-1);
        Node deleted = prev.next;

        prev.next = deleted.next;
        deleted.next = null;
        length--;
        return deleted;


    }

    public boolean set(int index, String data){
        Node temp = get(index);
        if(temp != null){
            temp.data = data;
            return true;
        }
        return false;
    }

    public boolean insert(int index, String data){
        if (index > length || index < 0){
            System.out.println("Indice incorreto");
            return false;
        }
        if (index == 0){
            prepend(data);
            return true;
        }
        if (index == length){
            append(data);
            return true;
        }
        Node newNode = new Node(data);
        Node temp = get(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }


    public static void main(String[] args) {
        LinkedList list = new LinkedList("Oi 1");
        list.append("Oi 2");
        list.append("Oi 3");
        list.append("Oi 4");
        list.prepend("Oi 0");
        System.out.println("Inserido?: " + list.insert(5, "Surpresa"));
//        list.insert(2,"Surpresa");
        System.out.println("No removido do fim: " + list.removeLast().data);
        System.out.println("No removido do inicio: " + list.removeFirst().data);
        System.out.println("No na posicao 1: " + list.get(3).data);

        list.getHead();
        list.getTail();
        list.getLength();
        list.print();

//        list.set(1, "Novo 02");
//        list.print();

        list.delete(6);
        list.print();

//        list.append("vamos lá");
//        list.getTail();
//        list.getHead();
//        list.getLength();
//        list.print();

    }
}
