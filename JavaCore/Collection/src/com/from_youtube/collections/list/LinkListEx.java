package com.from_youtube.collections.list;

import java.util.LinkedList;

public class LinkListEx {

	public static void main(String[] args) {
		LinkedList<String> linkedLists = new LinkedList<>();
		linkedLists.add("Linked 1");

		// Các hàm chức năng sẽ giống với ArrayList<> vì đều extends từ AbstractList<>

		// LinkedList khác với ArrayList về cách khởi tạo và quản lý các phần tử:
		// LinkedList quản lý các element qua các Node

		// Xử lý thêm Element trong LinkedList:
		// - Tạo thông tin currentNode = [tempNode, Element, null]
		// 		Ở currentNode này đã linked preNode với lastNode
		// - Gán nextNode của lastNode là currentNode
		// => linked 2 đầu

		// 1 Node có chứa các thông tin sau
		// - pre: Node
		// - next: Node
		// - value: Object

		// Ngoài ra vì quản lý theo Node nên sẽ có 1 số method đặc biệt:
		linkedLists.addFirst("Linked first");
		linkedLists.addLast("Linked last");
		linkedLists.getFirst();
		linkedLists.getLast();
		linkedLists.removeFirst();
		linkedLists.removeLast();
	}
}
