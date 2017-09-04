package com.kaushik.linkedlist.singlylinkedlist;

public class SinglyLinkedList<T> {

	private Node<T> head;
	private int size;
	private int capacity = 100;

	private void extendCapacity() {
		if ((this.capacity - this.size) < 5) {
			this.capacity = this.capacity + 20;
		}
	}

	public void add(T data) {
		extendCapacity();
		Node<T> temp = this.head;
		while(true){
			if (temp == null) {
				this.head = new Node<>();
				this.head.setElement(data);
				this.size++;
				break;
			} else if (temp.getNext() == null) {
				Node<T> node = new Node<>();
				node.setElement(data);
				temp.setNext(node);
				this.size++;
				break;
			} else {
				temp = temp.getNext();
			}
		}
	}
	public void traverse(){
		Node<T> temp = this.head;
		while(true){
			if(temp != null){
				System.out.println(temp.element.toString());
				temp = temp.getNext();
			} else {
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
		linkedList.add(11);
		linkedList.add(55);
		linkedList.add(5);
		linkedList.add(6);
		linkedList.traverse();
		
	}

	class Node<T> {
		private T element;
		private Node<T> next;

		public T getElement() {
			return element;
		}

		public void setElement(T element) {
			this.element = element;
		}

		public Node<T> getNext() {
			return next;
		}

		public void setNext(Node<T> next) {
			this.next = next;
		}

	}
}
