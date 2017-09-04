package com.kaushik.linkedlist.singlylinkedlist;

public class SinglyLinkedList<T> {

	private Node<T> head;
	private int size;
	private int capacity = 100;

	private void expandList() {
		if (capacity - size < 5) {
			capacity = capacity + 20;
		}
	}

	public void add(T data) {
		expandList();
		Node<T> temp = head;
		while (true) {
			if (temp == null) {
				head = new Node<>();
				head.setElement(data);
				size++;
				break;
			}else if(temp.getNext() == null) {
				Node<T> n = new Node<>();
				n.setElement(data); 
				temp.setNext(n);
				size++;
				break;
			} else {
				temp = temp.getNext();
			}
		}
	}
	
	public void traverse() {
		if(size == 0) {
			System.out.println("List is empty");
		} else {
			Node<T> temp = head;
			while(true) {
				if(temp == null) {
					break;
				} else {
					System.out.println(temp.getElement());
					temp = temp.getNext();
				}
			}
		}
	}
	
	public void get(int index) {
		if(index > size) {
			throw new ArrayIndexOutOfBoundsException();
		} else {
			Node<T> temp = head;
			int count = 0;
			while (true) {
				if(count == index) {
					System.out.println(temp.getElement());
					break;
				}else {
					temp = temp.getNext();
					count++;
				}
			}
		}
	}
	
	public void remove(int index) {
		if(index > size) {
			throw new ArrayIndexOutOfBoundsException();
		} else {
			Node<T> temp = head;
			int count = 0;
			while(true) {
				if(count == index-1) {
					Node<T> n = temp.getNext();
					temp.setNext(n.getNext());
					System.out.println("Removing : "+ n.getElement());
					break;
				} else {
					temp = temp.getNext();
					count++;
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
		linkedList.add(22);
		linkedList.add(4);
		linkedList.add(54);
		linkedList.add(7);
		linkedList.add(31);
		System.out.println();
		linkedList.traverse();
		System.out.println();
		linkedList.get(2);
		linkedList.remove(3);
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
