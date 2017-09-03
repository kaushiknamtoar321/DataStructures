package com.kaushik.queue;

public class MyQueue {
	int front;
	int rear;
	int size;
	int capacity;
	int[] array;

	public MyQueue(int capacity) {
		this.capacity = capacity;
		this.size = 0;
		this.front = 0;
		this.rear = this.capacity - 1;
		this.array = new int[this.capacity];
	}

	public void enqueue(int data) throws Exception {
		if (this.isQueueFull()) {
			throw new Exception("Queue is full");
		}
		this.rear = (this.rear + 1) % this.capacity;
		this.array[this.rear] = data;
		this.size++;
		System.out.println("Adding : " + data);
	}

	private boolean isQueueFull() {
		return this.size == this.capacity;
	}

	public int dequeue() throws Exception {
		if (this.isQueueEmpty()) {
			throw new Exception("Queue is empty");
		}
		int data = this.array[this.front];
		this.front = (this.front + 1) % this.capacity;
		this.size--;
		System.out.println("Removing : " + data);
		return data;
	}

	private boolean isQueueEmpty() {
		return this.size == 0;
	}
	
	public void traverse() {
		if(this.isQueueEmpty()) {
			System.out.println("Queue is empty");
		} else {
			for(int i = this.front ;i<= this.rear;i++) {
				System.out.println(this.array[i]);
			}
			
		}
	}
	public static void main(String[] args) throws Exception {
		MyQueue queue = new MyQueue(10);
		queue.enqueue(10);
		queue.enqueue(2);
		queue.enqueue(13);
		queue.enqueue(17);
		queue.enqueue(11);
		System.out.println();
		queue.dequeue();
		queue.dequeue();
		System.out.println();
		queue.traverse();
	}
}






