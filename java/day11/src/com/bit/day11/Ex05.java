package com.bit.day11;

public class Ex05 {
	public static void main(String[] args) {
		String target1 = "java";
		String target2 = "java";								// ���ڿ��� ���̰� �ٸ� ���
		System.out.println(target1.compareTo(target2));				// 0: �� ���� ��ġ
		target2 = "javaWebString";
		System.out.println(target1.compareTo(target2));				// 9: ���ڿ� ������ ���� ���� ��ȯ
		System.out.println(target2.compareTo(target1));				// (char �迭�� �ٲپ� �� ���ھ� ��)
		
		target2 = "javd";										// ���̰� ���� ���
		System.out.println(target1.compareTo(target2));				// 3: 'd'�� 'a'�� �������� �� ��ȯ
		target2 = "jaVa";
		System.out.println(target1.compareTo(target2));				// 32: 'v'�� �빮�� 'V'�� �������� �� ��ȯ
	}
}
