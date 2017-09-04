package com.kaushik.linkedlist.singlylinkedlist;

public class SinglyLinkedList<T> {

	private Node<T> head;
	private int size;
	private int capacity = 7;

	private void extendCapacity() {
		if ((this.capacity - this.size) < 5) {
			this.capacity = this.capacity + 20;
		}
	}

	public void add(T data) {
		extendCapacity();
		Node<T> temp = this.head;
		while (true) {
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

	public void traverse() {
		Node<T> temp = this.head;
		while (true) {
			if (temp != null) {
				System.out.println(temp.element.toString());
				temp = temp.getNext();
			} else {
				break;
			}
		}
	}

	public void get(int index) throws Exception {
		Node<T> temp = this.head;
		if (temp == null) {
			throw new Exception("List is empty");
		} else if (index > this.size) {
			throw new ArrayIndexOutOfBoundsException();
		} else {
			int count = 0;
			while (true) {
				if (count == index) {
					System.out.println(temp.getElement().toString());
					break;
				} else {
					temp = temp.getNext();
					count++;
				}
			}
		}
	}
	
	public void delete(int index) throws Exception{
		Node<T> temp = this.head;
		if (temp == null) {
			throw new Exception("List is empty");
		} else if (index > this.size) {
			throw new ArrayIndexOutOfBoundsException();
		} else {
			int count = 0;
			while (true) {
				if (count == index-1) {
					Node<T> e = temp.getNext(); 
					temp.setNext(e.getNext());
					
					System.out.println("Removing : "+e.getElement().toString());
					break;
				} else {
					temp = temp.getNext();
					count++;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
		linkedList.add(11);
		linkedList.add(55);
		linkedList.add(5);
		linkedList.add(6);
		linkedList.traverse();
		System.out.println();
		linkedList.get(0);
		System.out.println();
		linkedList.delete(1);
		System.out.println();
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
