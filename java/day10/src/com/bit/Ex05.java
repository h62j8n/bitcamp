package com.bit;
public class Ex05 {
	public static void main(String[] args) {
		Character ch1;
		ch1 = new Character('A');
		
		System.out.println(Character.MIN_VALUE);
		System.out.println(Character.MAX_VALUE);			// �� �ǹ̰� ����.
		
		System.out.println(Character.isDefined('a'));		// ?? 'A'�� 'a'
		
		char target = '@';									// �빮��,�ҹ���,Ư������,���� �� �پ��ϰ� �Ẹ�� ���ϱ�
		
		System.out.println(Character.isDefined(target));	// �����ڵ�����
		
		System.out.println(Character.isAlphabetic(target));	// ��������
		System.out.println(Character.isLetter(target));
		
		System.out.println(Character.isDigit(target));		// ��������
		
		System.out.println(Character.isUpperCase(target));	// �빮������
		
		System.out.println(Character.isLowerCase(target));	// �ҹ�������
		
		System.out.println(Character.isSpace(target));	// (��)��������
		System.out.println(Character.isWhitespace(target));	// ��������
	}
}
