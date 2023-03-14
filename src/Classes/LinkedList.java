/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;


/**
 *
 * @author Hallo
 */
public class LinkedList<T> {
    
    private Node<T> head;
    private Node<T> tail;
    private T data1;
    private int counter1;;

    /**
     * Constructor for initially empty list
     */
    public LinkedList() {
        this.head = this.tail = null;
    }
    
    /**
     * Constructor for list initially with one node
     * @param n
     */
    public LinkedList(Node<T> n) {
        this.head = this.tail = n;
    }

    public LinkedList(T data1,int counter1){
        this.data1=data1;
        this.counter1=counter1;
    }
    
    public Node<T> getHead() {
        return this.head;
    }
    
    public void setHead(Node<T> head) {
        this.head = head;
    }
    
    public void setTail(Node<T> tail) {
        this.tail = tail;
    }
    
    /**
     * Checks whether list is empty or not
     * @return 
     */
    private boolean isEmpty() {
        return this.head == null;
    }
    
    /**
     *  Get the current size of the list
     * @return 
     */
    public int size() {
        int i = 0;
        
        if (isEmpty()) {
            return 0;
        }
        
        Node<T> aux = this.head;
        while(aux != null) {
            i++;
            aux = aux.getNext();
        }
        return i;
    }
    
    /**
     * Add datum to the first position of the list
     * @param datum Datum to be added
     */
    public void addFirst(T datum,int counter) {
        Node<T> n = new Node(datum, counter);
        if (isEmpty()) {
            this.head = n;
            this.tail = n;
            this.head.setNext(this.tail);
            this.tail.setNext(null);
        } else {
            n.setNext(this.head);
            this.head = n;
        }
    }
    
    /**
     * Add datum to the last position of the list
     * @param datum Datum to be added
     */
    public void addLast(T datum, int counter) {
        Node<T> n = new Node(datum,counter);
        if (isEmpty()) {
            this.head = n;
            this.tail = n;
            this.head.setNext(this.tail);
            this.tail.setNext(null);
        } else {
            this.tail.setNext(n);
            this.tail = n;
        }
    }
    
    

    /**
     * Deletes first element of the list
     * @return The data of the first element
     */
    public LinkedList deleteFirst() {
        if (isEmpty()) {
            return null;
        }
        Node<T> temp = this.head;
        this.head= this.head.getNext();
        temp.setNext(null);
        return new LinkedList(temp.getData(),temp.getCounter());
    }
    
    /**
     * Deletes last element of the list
     * @return The data of the last element
     */
    public LinkedList deleteLast() {
        if (isEmpty()) {
            return null;
        }
        Node<T> pre = this.head;
        while(pre.getNext().getNext() != null) {
            pre = pre.getNext();
        }
        Node<T> temp = pre.getNext();
        pre.setNext(null);
        this.tail = pre;
        temp.setNext(null);
        
        return new LinkedList(temp.getData(),temp.getCounter());
        
    }
    
    /**
     * Prints the list in a pretty format
     */
    public void print() {
        if (isEmpty()) {
            System.out.println("Vacia");
        } else {
            Node aux = this.head;
            int i = 0;
            while (aux != null) {
                System.out.print(aux.getData() + "(" + i + ")" + " -> ");
                aux = aux.getNext();
                i++;
            }
            System.out.println("");
        }
    }
    
    
    public void reverse() {
        Node prev = null;
        Node current = this.head;
        Node next = null;
        this.setTail(current);
        while(current != null) {
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        
        this.setHead(prev);
        
    }
    
//    public void completeList() {
//        Node current = this.head;
//        int index = 0;
//        // 7, 8, 10, 13
//        while (current != null) {
//            if (current.getData() + 1 != current.getNext().getData()) {
//                this.add(current.getData() + 1, index+1);
//            }
//            current = current.getNext();
//            index++;
//        }
//    }
//    
    
    
    /**
     * @return the counter1
     */
    public int getCounter1() {
        return counter1;
    }

    /**
     * @param counter1 the counter1 to set
     */
    public void setCounter1(int counter1) {
        this.counter1 = counter1;
    }

    /**
     * @return the data1
     */
    public T getData1() {
        return data1;
    }

    /**
     * @param data1 the data1 to set
     */
    public void setData1(T data1) {
        this.data1 = data1;
    }
}

