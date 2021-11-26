package com.from_youtube.collections.stack_queue.stack;

import com.from_youtube.collections.stack_queue.IStackQueue;

public class MyStackArray implements IStackQueue{

	private int[] array;
	private int SIZE;
	private int topIndex;
	
	public MyStackArray(int initSize) {
		SIZE = initSize;
		array = new int[initSize];
		topIndex = -1;
	}

	public boolean push(int value) {
		
		if(!isFull()) {
			topIndex++;
			array[topIndex] = value;
			return true;
		}
		return false;
	}
	
	public int pop() {
		if(!isEmpty()) {
			int result = array[topIndex];
			topIndex--;
			return result;
		}
		return -1;
	}
	
	public boolean isFull() {
		return topIndex == SIZE - 1;
	}
	
	public boolean isEmpty() {
		return topIndex < 0;
	}
	
	public void show() {
		for(int i=0; i<=topIndex; i++) {
			System.out.println(array[i]);
		}
	}
}
