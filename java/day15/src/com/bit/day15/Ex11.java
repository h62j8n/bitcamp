package com.bit.day15;

import java.util.HashMap;

public class Ex11 {
	public static void main(String[] args) {
// �⺻��
		HashMap map1 = new HashMap();
		map1.put("key1", "value1");
		map1.put(2, '��');
		map1.put(2, "value2");			// value : �ߺ� ����
		map1.put("key3", true);
		
		map1.put("key1", "00000");		// key : �ߺ� �� ������ �� ��� (����� �Ǵ� ����)
		
		System.out.println(map1.get("key1"));
		
// ���׸�
		HashMap<String, String> map = new HashMap<String, String>();
//		map.put(key, 12345);				// Err : ���׸��� ���� <String>�� ����
		map.put("key2", "value2");
		map.put("key3", "value2");
		map.put("key4", "value4");
		map.put("key5", "value5");
		
		System.out.println(map.get("key1"));
	}
}
