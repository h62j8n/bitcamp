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
		
		// �� ����� (HashMap)
		map.put("key1", null);						// value���� ���ֱ�. (���� ���� ȣ��/����ϸ� null�� �����Ƿ�)
													// key���� ���忡�� �����, value���� ���忡�� �����
		map.remove("key2");							// ����⺸�� �̾Ƴ��� ����?
		
		
		
		// HashMap �迭�� Key���� �̿��� �迭�� Set���� ���
		Set<String> keys = map.keySet();			// ���� ������ map�� key�� ���׸�<String>�� ���� ������ ���󰡴� ���� ����
		Iterator<String> ite = keys.iterator();
		while(ite.hasNext()) {
			String key = ite.next();				// Set type�̶� ������ ����
			System.out.println(key+" : "+map.get(key));
		}
		System.out.println("-----");
		
		// ���� ������ ����� ���·� ���
		Set<Entry<String, Integer>> entrys = map.entrySet();
		entrys = map.entrySet();
		
		Iterator<Entry<String, Integer>> ite2;
		ite2 = entrys.iterator();
		while (ite2.hasNext()) {
			Entry<String, Integer> entry = ite2.next();	// Ű�� ���� ��ȯ�ϹǷ� Ű�� ���� ���׸� <String, Integer>
			System.out.print(entry.getKey()+" : ");
			System.out.println(entry.getValue());
		}
		System.out.println("-----");
		
		// ArrayList ��ü�� �����Ͽ� ��� (���� ���� ���)
		Set keys2 = map.keySet();
		List<String> list = new ArrayList<>(keys2);	// Ű���� �������� ��ȯ�ϹǷ� Ű�� ���׸� <String>
		for (int i=0; i<list.size(); i++) {
			String key = list.get(i);
			System.out.println(key+" : "+map.get(key));
		}
	}
}
