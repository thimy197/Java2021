package com.from_youtube.collections.map;

import java.util.HashMap;
import java.util.Set;

public class HashMapEx {

	public static void main(String[] args) {
		// HashMap<K, V>

		HashMap<String, String> hashMaps = new HashMap<>();
		hashMaps.put("firstName", "My");
		hashMaps.put("address", "HCM");

		// Duyệt các phần tử
		Set<String> keys = hashMaps.keySet();
		keys.forEach(key ->{
			System.out.println("Key: "+key +" ; value:"+ hashMaps.get(key));
		});

		// containsKey
		if(hashMaps.containsKey("fullName")) {
			System.out.println("Contain fullName key");
		}
	}

}
