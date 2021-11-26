package com.daomy.thread;

public class ThreadOne extends Thread{

	@Override
	public void run() {
		for(int i=0; i<20; i++) {
			System.out.println("ThreadONE: "+i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
