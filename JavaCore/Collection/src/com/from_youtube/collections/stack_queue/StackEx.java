package com.from_youtube.collections.stack_queue;

import java.util.ArrayDeque;

public class StackEx {

	public static void main(String[] args) {
		// LIFO - Last in first out

		// Deque chính là Stack
		ArrayDeque<String> stack = new ArrayDeque<String>();
		stack.push("Element 1");
		stack.push("Element 2");
		stack.push("Element 3");
		System.out.println(stack.pop());
	}

}
