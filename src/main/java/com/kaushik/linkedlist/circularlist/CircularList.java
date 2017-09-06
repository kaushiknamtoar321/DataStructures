package com.kaushik.linkedlist.circularlist;

import java.util.Iterator;

public class CircularList<T> implements Iterable<T> {

    // This class implements a simple singly linked list.
    // Elements of the list are nodes which contain a value
    // of type T and a pointer (reference) to the next node
    // on the list.
    private class Node {

        public T data;
        public Node next;
    }

    private Node head;		// The first node of the list
    private Node tail;		// The last node of the list
    private int size;		// The number of nodes in the list

    public CircularList() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    /**
     * The number of elements in the list.
     */
    public int size() {
        return this.size;
    }

    /**
     * Determines if a specified value is contained in the list.
     *
     * @param Item The value to be checked to see if it is in the list.
     */
    public boolean isMember(T item) {
        Node rover = head;
        for (int i=0; i<size; i++) {
            if (rover.data.equals(item)) { //?
                return true;
            }
            rover = rover.next;
        }
        return false;
    }

    /**
     * Appends a new node to the end of the list with the specified value.
     *
     * @param item The value of the item to be appended to the list.
     */
    public void append(T item) {
        Node node = new Node();
        node.data = item;
        if (head == null){ // if first node
            tail = node;
            head = tail;
        } 
        else{ // not first
            tail.next = node;
            tail = node;
        }
        tail.next = head;
        CircularList.this.size++;
    }

    /**
     * Prepends a new node at the head of the list with the specified value.
     *
     * @param item The value of the item to be prepended to the list.
     */
    public void prepend(T item) {
        Node node = new Node();
        node.data = item;
        if (head == null) {
            tail = node;
            head = tail;
        }
        else{ 
            node.next = head;
            head = node;
        }
        tail.next = head;
        CircularList.this.size++;
    }
    
    public void reverse(){
        if (head==null){ //if list is empty, may be redundent checking
            return;
        }
        Node reverse = head.next; 
        Node rover = head;  
        for (int i=0; i<size(); i++){
            Node temp = reverse; 
            reverse = reverse.next; 
            temp.next = rover; 
            rover = temp; 
        }
        Node temp = head; //switch head and tail
        head = tail;
        tail = temp;
    }

    /**
     * Constructs an iterator to traverse the elements of the list.
     */
    public Iterator<T> iterator() {
        return new ListIterator();
    }
    
    public Iterator<T> iterator(T item){
        return new OtherListIterator(item);
    }

    public class ListIterator implements Iterator<T> {

        Node rover;

        public ListIterator() {
            rover = head;
        }
        
        public boolean hasNext() { 
            if (head == null || rover.next==head){ //empty list or back at the beginning returns false
                return false;
            }
            return true;
        }

        public T next() {
            T data = rover.data;
            rover = rover.next;
            return data;
        }

        public void remove() {
            Node newRover = head;
            while (newRover != null) { //if not an empty list
                if (newRover.next == rover) {
                    newRover.next = rover.next;
                    rover = newRover.next;
                    newRover = null; //break out of while loop, since you have removed the element
                }
                CircularList.this.size--;
            }
        }
    }
    
     public class OtherListIterator extends ListIterator {
        public OtherListIterator (T item){
            super();
            for (int i=0; i<CircularList.this.size; i++){
                if (rover.data==item){ //if you found where you want to start
                    head = rover; 
                    i=CircularList.this.size; //break for loop
                }
            }
        }
     }
}