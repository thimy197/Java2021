package com.refactoring.common;

import java.util.Objects;

/**
 * Singleton class 
 * 	final keywork to cannot inheritance
 * 
 * @author daoth
 *
 */
public final class Singleton {

	private static Singleton singleton;
	private String value;

	private Singleton(String value) {
		// mô phỏng làm chậm thời gian khởi tạo
		try {
			Thread.sleep(1000);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		this.value = value;
	}

	public static Singleton getSingleton(String value) {
		if(Objects.isNull(singleton)) {
			singleton = new Singleton(value);
		}
		return singleton;
	}

	public String getValue() {
		return this.value;
	}
}

/**
 * Base singleton class
 * @author daoth
 *
 */
//public final class Singleton {
//	
//	private static Singleton singleton;
//	
//	private Singleton() {}
//	
//	public static Singleton getSingleton() {
//		if(Objects.isNull(singleton)) {
//			singleton = new Singleton();
//		}
//		return singleton;
//	}
//}
