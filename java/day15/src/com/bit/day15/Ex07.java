package com.bit.day15;

import java.util.Enumeration;
import java.util.Vector;

public class Ex07 {
	public static void main(String[] args) {
		Vector<String> vec1 = new Vector<>();
		vec1.addElement("�ϳ�");					// ���͸��� �޼ҵ�
		vec1.addElement("������ȩ");
		vec1.addElement("������");
//		vec1.addElement(33);						// Err. ���׸� <String>
		
		Enumeration<String> eles = vec1.elements();	// Ŀ�� �������� ������ ��� Ȯ��
		while (eles.hasMoreElements()) {
			String ele = eles.nextElement();
			System.out.println(ele);
		}
		
		System.out.println("-----");
		
		vec1.add("��");								// �÷��������ӿ�ũ ���� �޼ҵ�
		vec1.add("�ټ�");
		for (int i=0; i<vec1.size(); i++) {			// ���� �޼ҵ�� ������ ��� Ȯ��
			String msg = vec1.elementAt(i);			// ?????elementAt() �� ���� ��ɾ������� üũ�غ���
			System.out.println(msg);
		}
	}
}
