package com.from_youtube.generics;

import java.util.ArrayList;

public class ControllerExtend<E extends People> {

	private ArrayList<E> list = new ArrayList<>();

	public void add(E element) {
		list.add(element);
	}

	public E get(int index) {
		return list.get(index);
	}
}

class People{
	String Name;
}
class Student extends People{
	String MSSV;
}
