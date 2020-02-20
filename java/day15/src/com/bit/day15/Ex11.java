package com.bit.day15;

import java.util.HashMap;

public class Ex11 {
	public static void main(String[] args) {
// 기본형
		HashMap map1 = new HashMap();
		map1.put("key1", "value1");
		map1.put(2, '둘');
		map1.put(2, "value2");			// value : 중복 가능
		map1.put("key3", true);
		
		map1.put("key1", "00000");		// key : 중복 시 나중의 값 출력 (덮어쓰기 또는 수정)
		
		System.out.println(map1.get("key1"));
		
// 제네릭
		HashMap<String, String> map = new HashMap<String, String>();
//		map.put(key, 12345);				// Err : 제네릭에 의해 <String>만 가능
		map.put("key2", "value2");
		map.put("key3", "value2");
		map.put("key4", "value4");
		map.put("key5", "value5");
		
		System.out.println(map.get("key1"));
	}
}
