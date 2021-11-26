package com.from_youtube.collections.stack_queue;

import com.from_youtube.collections.stack_queue.queue.MyQueueArray;
import com.from_youtube.collections.stack_queue.stack.MyStackArray;

public class TestStackQueue {

	public static void main(String[] args) {
		// Giống Array phải khai báo trước số element
		MyStackArray myStack = new MyStackArray(3);
		myStack.push(1);
		myStack.push(2);
		System.out.println(myStack.push(3));
		System.out.println(myStack.push(4));
		
		myStack.show();
		
		MyQueueArray myQueue = new MyQueueArray(3);
		myQueue.push(1);
		myQueue.push(2);
		System.out.println(myQueue.push(3));
		System.out.println(myQueue.push(4));
		
		myQueue.show();
		
	}

}
