package com.from_youtube.generics;

import java.util.ArrayList;

public class Controller<E> {

	private ArrayList<E> list = new ArrayList<>();

	public void add(E element) {
		list.add(element);
	}

	public E get(int index) {
		return list.get(index);
	}
}
