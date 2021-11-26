package com.daomy.thread;

public class ThreadTwo implements Runnable{
	
	ThreadOne thread1;
	
	public ThreadTwo() {
	}

	public ThreadTwo(ThreadOne thread1) {
		this.thread1 = thread1;
	}

	@Override
	public void run() {
		System.out.println("Thread2 is running");
		if(thread1.isAlive()) {
			try {
				System.out.println("Join thread1 into thread2");
				thread1.join();
				System.out.println("thread1 is finish");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for(int i=0; i<20; i++) {
			System.out.println("ThreadTwo: "+i);
		}
		System.out.println("Thread2 is finish");
	}

}
