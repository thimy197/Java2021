package com.from_youtube.collections.stack_queue;

import java.util.PriorityQueue;

public class QueueEx {

	public static void main(String[] args) {
		// Queue - Hàng đợi
		// FIFO - first in first out
		// Breadth-First search (BFS) algorithm,...

		// Không thể khởi tạp trực tiếp Queue
		PriorityQueue<String> queue = new PriorityQueue<String>();
		queue.offer("Element1");
		queue.offer("Element2");
		System.out.println(queue.poll());
	}

}
