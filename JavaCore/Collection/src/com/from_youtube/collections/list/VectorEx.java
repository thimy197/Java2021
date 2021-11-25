package com.from_youtube.collections.list;

import java.util.Vector;

public class VectorEx {

	public static void main(String[] args) {
		Vector<String> vectors = new Vector<String>();
		vectors.add("Vector1");
		System.out.println(vectors.size());

		// Về các hàm chức năng có sẵn thì giống với Arraylist
		// Khác với ArrayList là về cơ chế
		// 1. Default của constructor Vector là khởi tạo 10 element 
		// 2. Khi add tới phần tử thứ 10 thì sẽ tạo ra mảng mới 20 phần tử(mỗi lần tăng 10)
		// ==> không cần khởi tạo mảng mới khi add, nên xử lý nhanh hơn, bù lại chiếm nhiều bộ nhớ hơn

		// Khi thực hiện size()
		// 		returns the size or the number of elements present in the Vector.
	}
}
