package com.refactoring.common;

public class CreationThread {

	public static void main(String[] args) {
		Thread thread1 = new Thread(new Thread1());
		Thread thread2 = new Thread(new Thread2());
		thread1.start();
		thread2.start();
	}

	static class Thread1 implements Runnable {
        public void run() {
        	// mô phỏng làm chậm thời gian khởi tạo
    		try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println("Thread 1 run...");
        }
    }

    static class Thread2 implements Runnable {
        public void run() {
        	System.out.println("Thread 2 run...");
        }
    }
}
