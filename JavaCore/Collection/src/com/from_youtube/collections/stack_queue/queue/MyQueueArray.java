package com.from_youtube.collections.stack_queue.queue;

import com.from_youtube.collections.stack_queue.IStackQueue;

public class MyQueueArray implements IStackQueue{

	private int[] array;
	private int SIZE;
	private int head;
	private int tail;
	
	public MyQueueArray(int size) {
		SIZE = size;
		array = new int[size];
		head = tail = -1;
	}

	@Override
	public boolean push(int value) {
		if(!isFull()) {
			if(isEmpty()) {
				head++;
			}
			tail++;
			array[tail] = value;
			return true;
		}
		return false;
	}

	@Override
	public int pop() {
		if(!isEmpty()) {
			int result = array[head];
			head++;
			if(head > tail) {
				head = tail = -1;
			}
			return result;
		}
		return -1;
	}

	@Override
	public boolean isFull() {
		return tail == SIZE-1;
	}

	@Override
	public boolean isEmpty() {
		return head < 0 && tail < 0;
	}

	@Override
	public void show() {
		for(int i=head ; i<=tail; i++) {
			System.out.println(array[i]);
		}
	}
	
	public int count() {
		return isEmpty()?0:(tail-head+1);
	}
}
