package com.refactoring.multi_threaded;

import com.refactoring.common.Singleton;

public class DemoMultiThread {

	public static void main(String[] args) {
		System.out.println("Nếu bạn thấy cùng một value, thì singleton đã được sử dụng lại (yay!)" + "\n" +
                "Nếu bạn thấy các value khác nhau, thì 2 instance single đã được tạo (booo !!)" + "\n\n" +
                "RESULT:" + "\n");
		Thread threadFoo = new Thread(new ThreadFoo());
		Thread threadBar = new Thread(new ThreadBar());
        threadFoo.start();
        threadBar.start();
	}

	static class ThreadFoo implements Runnable {
        public void run() {
            Singleton singleton = Singleton.getSingleton("FOO");
            System.out.println(singleton.getValue());
        }
    }

    static class ThreadBar implements Runnable {
        public void run() {
            Singleton singleton = Singleton.getSingleton("BAR");
            System.out.println(singleton.getValue());
        }
    }
}
