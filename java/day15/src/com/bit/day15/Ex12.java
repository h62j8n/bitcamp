package com.bit.day15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Ex12 {
	public static void main(String[] args) {
		Map<String, Integer> map;
		map = new HashMap();						// HashMap
//		map = new Hashtable<String, Integer>();		// HashTable
		
		for (int i=0; i<5/*0*/; i++) {
			map.put("key"+i, i);
		}
		
		// 값 지우기 (HashMap)
		map.put("key1", null);						// value값을 없애기. (없는 값을 호출/출력하면 null이 나오므로)
													// key값의 입장에선 덮어쓰기, value값의 입장에선 지우기
		map.remove("key2");							// 지우기보다 뽑아내는 개념?
		
		
		
		// HashMap 배열의 Key값을 이용해 배열을 Set으로 출력
		Set<String> keys = map.keySet();			// 먼저 생성된 map의 key가 제네릭<String>을 쓰기 때문에 따라가는 것이 좋다
		Iterator<String> ite = keys.iterator();
		while(ite.hasNext()) {
			String key = ite.next();				// Set type이라 순서가 없음
			System.out.println(key+" : "+map.get(key));
		}
		System.out.println("-----");
		
		// 보다 원형에 가까운 상태로 출력
		Set<Entry<String, Integer>> entrys = map.entrySet();
		entrys = map.entrySet();
		
		Iterator<Entry<String, Integer>> ite2;
		ite2 = entrys.iterator();
		while (ite2.hasNext()) {
			Entry<String, Integer> entry = ite2.next();	// 키와 값을 반환하므로 키와 값의 제네릭 <String, Integer>
			System.out.print(entry.getKey()+" : ");
			System.out.println(entry.getValue());
		}
		System.out.println("-----");
		
		// ArrayList 객체를 생성하여 출력 (가장 나은 방법)
		Set keys2 = map.keySet();
		List<String> list = new ArrayList<>(keys2);	// 키값을 기준으로 반환하므로 키의 제네릭 <String>
		for (int i=0; i<list.size(); i++) {
			String key = list.get(i);
			System.out.println(key+" : "+map.get(key));
		}
	}
}
