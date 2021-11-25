package com.from_youtube.generics;

public class GenericEx {

	public static void main(String[] args) {
		// Generic là cách định nghĩa các kiểu dữ liệu chung chung để có thể thao tác trên nhiều type
		// Có các loại:
		// - E: Element
		// - K: key
		// - V: value
		// - N: Number
		// - T: Type
		// S, U, V and so on

		Controller<String> controllerCustom = new Controller<String>();
		controllerCustom.add("custom 1");
		controllerCustom.add("custom 2");
		System.out.println(controllerCustom.get(0));

		// error
		// ControllerExtend<String> controllerExtends = new ControllerExtend<String>();
		// E extends from people
		ControllerExtend<Student> controllerExtends = new ControllerExtend<>();
		controllerExtends.add(new Student());
		controllerExtends.add(new Student());
		System.out.println(controllerExtends.get(0));
	}

}
