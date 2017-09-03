package com.kaushik.stack;

public class MyStack {
	int top;
	int size;
	int capacity;
	int [] stack;
	
	public MyStack(int capacity) {
		this.capacity = capacity;
		this.top = 0;
		this.size = 0;
		this.stack = new int[this.capacity];
	}
	
	public void push(int data) throws Exception{
		if(this.isStackFull()) {
			throw new Exception("Stack is full");
		}
		this.stack[this.size] = data;
		this.size++;
		this.top++;
		System.out.println("Adding : "+ data);
	}

	private boolean isStackFull() {
		return this.size == this.capacity;
	}
	
	public int pop() throws Exception{
		if(this.isStackEmpty()) {
			throw new Exception("Stack is empty");
		}
		int data = this.stack[this.size-1];
		this.top--;
		this.size--;
		System.out.println("Removing : "+ data);
		return data;
	}

	private boolean isStackEmpty() {
		return this.size == 0;
	}
	
	public void traverse() {
		if(this.isStackEmpty()) {
			System.out.println("Stack is empty");
		} else {
			for(int i = 0;i<=this.size-1;i++) {
				System.out.println(this.stack[i]);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		MyStack stack = new MyStack(10);
		stack.push(10);
		stack.push(19);
		stack.push(11);
		stack.push(14);
		stack.push(12);
		stack.push(17);
		System.out.println();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		System.out.println();
		stack.traverse();
		stack.push(22);
		System.out.println();
		//stack.pop();
		System.out.println();
		stack.traverse();
	}
}







