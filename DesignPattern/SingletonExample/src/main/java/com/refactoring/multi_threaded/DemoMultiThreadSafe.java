package com.refactoring.multi_threaded;

import com.refactoring.common.SingletonSafe;

public class DemoMultiThreadSafe {

	public static void main(String[] args) {
		System.out.println("Nếu bạn thấy cùng một value, thì SingletonSafe đã được sử dụng lại (yay!)" + "\n" +
				"Nếu bạn thấy các value khác nhau, thì 2 instance single đã được tạo (booo !!)" + "\n\n" +
				"RESULT:" + "\n");
		Thread threadFoo = new Thread(new ThreadFoo());
		Thread threadBar = new Thread(new ThreadBar());
		threadFoo.start();
		threadBar.start();
	}

	static class ThreadFoo implements Runnable {
		public void run() {
			// mô phỏng làm chậm thời gian khởi tạo
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
			SingletonSafe singletonSafe = SingletonSafe.getSingletonSafe("FOO");
			System.out.println(singletonSafe.getValue()+" thread1");
		}
	}

	static class ThreadBar implements Runnable {
		public void run() {
			SingletonSafe singletonSafe = SingletonSafe.getSingletonSafe("BAR");
			System.out.println(singletonSafe.getValue() + " thread2");
		}
	}

}
