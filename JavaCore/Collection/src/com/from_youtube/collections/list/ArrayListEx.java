package com.from_youtube.collections.list;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListEx {

	public static void main(String[] args) {
		// khởi tạo với mảng empty
		ArrayList<String> list = new ArrayList<>();
		// có thể khởi tạo với length cố định như cách new String[]
		ArrayList<String> list1 = new ArrayList<>(2);

		// Cơ chế add:
		// Mỗi lần Add sẽ thực hiện:
		// 1.new mảng mới với length=length+1
		// 2.copy lại các phần tử cũ
		// 3.Thêm phần tử mới vào cuối cùng
		list.add("A1");
		list.add("A2");
		list.add("A3");

		// Các cách duyệt mảng
		// cách 1
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		// Cách 2
		for (String string : list) {
			System.out.println(string);
		}
		// Cách 3: use Lamda expression
		list.forEach(item -> System.out.println(item));
		// cách 4
		Iterator<String> iteratorItems = list.iterator();
		while(iteratorItems.hasNext()) {
			System.out.println(iteratorItems.next());
		}
		// Cách 5: stream
		list.stream().forEach(System.out::println);
		// Cách 6: use in multi-thread env
		list.parallelStream().forEach(System.out::println);

		// xóa phần tử
		list.remove(0);
		list.add(0, "A1");
		list.set(2, "A33");
		list.forEach(item -> System.out.println(item));

		// xóa tất cả elements
		System.out.println("Delete all elements");
		list.clear();
		list.forEach(item -> System.out.println(item));
	}
}
