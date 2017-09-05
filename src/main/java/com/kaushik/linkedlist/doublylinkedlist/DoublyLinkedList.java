package com.kaushik.linkedlist.doublylinkedlist;

public class DoublyLinkedList<T> {

	private Node<T> head;
	private Node<T> tail;
	private int size;
	private int capacity = 100;

	private void expandList() {
		if (capacity - size < 5) {
			capacity = capacity + 20;
		}
	}

	public void add(T element) {
		expandList();
		Node<T> head = this.head;
		Node<T> n = new Node<>();
		n.setData(element);
		while (true) {
			if (head == null) {
				this.head = new Node<>();
				this.head.setData(element);
				this.tail = new Node<>();
				this.tail.setData(element);
				this.size++;
				break;
			} else if (head.getNext() == null) {
				n.setPrevious(head);
				head.setNext(n);
				this.tail = n;
				this.size++;
				break;
			} else {
				head = head.getNext();
			}
		}
	}

	public void traverse() {
		if (size != 0) {
			Node<T> head = this.head;
			while (true) {
				if (head != null) {
					System.out.println(head.getData().toString());
					head = head.getNext();
				} else {
					break;
				}
			}
		}
	}

	public void reverse() {
		Node<T> tail = this.tail;
		while (true) {
			if (tail != null) {
				System.out.println(tail.getData().toString());
				tail = tail.getPrevious();
			} else {
				break;
			}
		}
	}

	public void get(int index) {
		if (index > size) {
			throw new NullPointerException();
		}
		Node<T> head = this.head;
		int count = 0;
		while (true) {
			if (count == index) {
				System.out.println(head.getData().toString());
				break;
			} else {
				head = head.getNext();
				count++;
			}
		}
	}

	public void remove(int index) {
		if (index > size) {
			throw new NullPointerException();
		}
		Node<T> head = this.head;
		int count = 0;
		while (true) {
			if (count == index - 1) {
				Node<T> n = head.getNext();
				n.getNext().setPrevious(head);
				head.setNext(n.getNext());
				break;
			} else {
				head = head.getNext();
				count++;
			}
		}
		Node<T> newHead = this.head;
		while (true) {
			if (newHead.getNext() == null) {
				this.tail = newHead;
				break;
			} else {
				newHead = newHead.getNext();
			}
		}
	}

	public static void main(String[] args) {
		DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
		doublyLinkedList.add(11);
		doublyLinkedList.add(3);
		doublyLinkedList.add(34);
		doublyLinkedList.add(63);
		doublyLinkedList.add(38);
		doublyLinkedList.add(70);
		doublyLinkedList.traverse();
		System.out.println();
		doublyLinkedList.reverse();
		System.out.println();
		doublyLinkedList.get(5);
		System.out.println();
		doublyLinkedList.remove(2);
		System.out.println("---traverse---");
		doublyLinkedList.traverse();
		System.out.println("---reverse---");
		doublyLinkedList.reverse();
	}

	class Node<T> {
		private T data;
		private Node<T> previous;
		private Node<T> next;

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

		public Node<T> getPrevious() {
			return previous;
		}

		public void setPrevious(Node<T> previous) {
			this.previous = previous;
		}

		public Node<T> getNext() {
			return next;
		}

		public void setNext(Node<T> next) {
			this.next = next;
		}

	}
}
