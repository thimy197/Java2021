package com.from_youtube.collections;

public class HashTable {

	/*
	 * HashTable - Mảng băm
	 * Tổ chức data sử dụng Hash function, để hỗ trợ insert và search
	 * 
	 * Vấn đề:
	 * <K, V> làm sao với key có thể lấy chính xác value???
	 * 
	 * Giải quyết:
	 * Cách tối ưu thông thường:
	 * 	- Mỗi cặp <key, value> sẽ được lưu vào 1 array
	 * 	- Duyệt mảng có chứa key thì lấy value ra
	 * 
	 * Bình thường cách tối ưu nhất để get element đó là lưu chúng trong 1 array[]
	 * Thì HashTable cũng sẽ tối ưu việc truy xuất giá trị => sử dụng Array
	 * 
	 * Ý tưởng:
	 * "Key" sẽ đc hash thành "index array"
	 * "Value" sẽ được lưu trong array[index], với index đã đc hash ở trên
	 * 
	 * Clear Ý tưởng:
	 * "Key" => Hash Function => "Hash value"
	 * Array lưu [HashValue-value] được gọi là "Bucket"
	 * => HashTable chứ [Key-HashValue]
	 * 
	 */
}
