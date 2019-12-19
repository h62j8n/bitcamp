package com.bit.day14;

import java.util.ArrayList;


public class Ex03 {
	public static void main(String[] args) {
		ArrayList list;
		list = new ArrayList();
		
		list.add(0);
		list.add("��");
		System.out.println(list.add(2));			// .add(num) : boolean���� ������ �ִ�
		list.add("�ѱ�");
		
		list.remove(0);								// .remove(idx) : �ش� �ε�����ȣ�� ��� ����
		list.remove("�ѱ�");						// .remove(val) : �ش� ���� ���� ��� ����
		list.set(0, "one");							// .set(idx, val) : �ش� �ε����� ���� val�� ����
		
		for (int i=0; i<list.size(); i++) {			// .get(idx) : �ε�����ȣ�� �� ȣ��
			System.out.print(list.get(i)+" ");
		}
		System.out.println();
		
		list.clear();								// .clear() : �迭�� ��� ����
		
		list.add(0);
		list.add(0);
		
		list.add(1,3);								// .add(idx, num) : [idx]�� ���� �����ֱ�
		list.add(list.size(),4);					// �������� ���� �����ֱ� (�� �ڽŵ� +1��)
		ArrayList list2 = (ArrayList)list.clone();	// .clone() : �迭�� ���� ����
		
		for (int i=0; i<list.size(); i++) {
			System.out.print(list.get(i)+" ");
//			int suI = list.get(i);					// ����: ArrayList�� su�� type mismatch
			Object suO = list.get(i);				// �Ϲ� (����)
/*			int suI1 = (int)list.get(i);			// ���� �迭�� ���) �ٿ�ĳ���������� ������ �ս��� ���輺 ���� 
 *			int suI2 = (Integer)list.get(i);			// �������� ����ȯ
 *			System.out.print(suI2+" ");
 */
		}
		System.out.println();
		
		System.out.println(list.contains(0));		// .contains(num) : �ش� ���ڰ� ���ԵǾ����� Ȯ��
		System.out.println(list.contains(5));
		
		System.out.println(list.indexOf(0));		// .indexOf(num) : �ش� ������ �ε�����ȣ ȣ��(�տ��� ī��Ʈ)
		System.out.println(list.lastIndexOf(0));	// .indexOf(num) : �ش� ������ �ε�����ȣ ȣ��(�ڿ��� ī��Ʈ)
		
		ArrayList list3 = new ArrayList();
		System.out.println(list3.isEmpty());		// .isEmpty() : ����ִ��� Ȯ��
		ArrayList list4 = null;						// �� �迭�� �ƴ϶� ��ü�� ����. �������÷��ǿ� ���� ��������.
		
		Object[] arr = list2.toArray();				// .toArray() : ArrayList�� �迭[]�� ��ȯ.  
		for (int i=0; i<arr.length; i++) {				// ArrayList�� �ּҰ��� ���� ������ �迭�̱� ������
			System.out.print(arr[i]+" ");				// .toArray()�� ������ �迭[]�� ��ȯ�� �� ����.
		}
		
		
	}
}
