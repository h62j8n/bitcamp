package com.bit.day15;

import java.util.ArrayList;
import java.util.List;

public class Ex01 {
	public static void main(String[] args) {
		List<String> list = null;					// #1-3. <String> : ���׸�.
		list = new ArrayList();
		
		list.add("�ϳ�");
		list.add("��");
//		list.add(new Integer(3333));				// #1-2> ����(String Ÿ������ �����Ͽ� ���) ��  ����ȯ ���� �߻�
		list.add("��");								// #1-3> ������ ���� String Ÿ�� ���� �޵��� ������ ǥ�� (���׸�)
		list.add("�ټ�");
		
		for (int i=0; i<list.size(); i++) {
			Object obj0 = list.get(i);				// #1-1. ���� ��
			String obj = (String)list.get(i);		// #1-2. ����ϱ� ���� ����ȯ(����)
			
			System.out.println(obj);
		}
	}
}
