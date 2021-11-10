package com.refactoring.single_threaded;

import com.refactoring.common.Singleton;

public class DemoSingleThread {

	public static void main(String[] args) {
		System.out.println("Nếu bạn thấy cùng một value, thì singleton đã được sử dụng lại (yay!)" + "\n" +
				"Nếu bạn thấy các value khác nhau, thì 2 instance single đã được tạo (booo !!)" + "\n\n" +
				"RESULT:" + "\n");
		Singleton singleton = Singleton.getSingleton("FOO");
		Singleton anotherSingleton = Singleton.getSingleton("BAR");
		System.out.println(singleton.getValue());
		System.out.println(anotherSingleton.getValue());
	}

}
