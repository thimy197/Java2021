package com.daomy.thread;

/**
 * Các cách tạo Thread
 * - implements Runnable
 * - extends Thread
 * 
 * Thread extends Runnable
 * Run thread bằng hàm: .start()
 * Dừng thread bằng: .stop()
 * Nghỉ "time" thời gian: Thread.sleep(time)
 * Nối luồng: .join()
 * 		Những lệnh sau .join() sẽ phải đợi thread đó chạy xong 
 * 		mới tiếp tục thực hiện các dòng tiếp theo
 *  
 * @author daoth
 *
 */
public class ThreadMain {

	public static void main(String[] args) {

		System.out.println("Start........"); // threads: "main"
		
		// cách 1 
		ThreadOne thread1 = new ThreadOne();
		thread1.start();// threads: main & thread1

		// cách 2: gọi trực tiếp Runnable
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0; i<20; i++) {
					System.out.println("ThreadRunnable: "+i);
					try {
						Thread.sleep(700);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		thread2.start();// threads: main & thread1 & thread2
		
		
		// cách 2: Đưa phần tạo Runnable ra bên ngoài
		// Thread threadRunable = new Thread(new ThreadTwo());
		// threadRunable.start();

		System.out.println("........END");
		
		// join thread
		// 3 threads: (main & thread1 & thread2) đang chạy song song
		// đang ở thread main có lệnh thread1.join()
		// nghĩa là các lệnh sau join này sẽ không chạy song song với thread1,
		// mà chạy sau lệnh thread1.join()
		try {
			System.out.println("Lệnh này chạy song song với all threads");
			System.out.println("Join thread1 vào thread main");
			thread1.join();// join 1 into main
			System.out.println("Lệnh này luôn chạy sau thread1");
			System.out.println("Join thread2 vào thread main");
			thread2.join();// join 2 into main
			System.out.println("Lệnh này luôn chạy sau thread1&thread2");
			System.out.println("thread main complete");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Làm thế nào để thread1 join trong thread 2, mà 2 threads này đều đang trong thread main
		// chúng ta sẽ tạo constructor trong thread2 có truyền tham số thread1 vào thread2(xem trong ThreadTwo class)
		// ThreadOne thread1 = new ThreadOne();
		// Thread thread2 = new Thread(new ThreadTwo(thread1));
		// thread1.start();
		// thread2.start();
		
		// sau 5s thì stop các luồng
//		try {
//			Thread.sleep(2000);
//			System.out.println("Stop threadOne");
//			thread1.stop();
//			System.out.println("Stop threadTwo");
//			thread2.stop();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
