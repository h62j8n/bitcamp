package com.bit.day11;

public class Ex04 {
	public static void main(String[] args) {
		
		String target = "java";
		String result = null;
		
		result = target.replace('v', 'V');
		result = target.replace("v", "V");				// ������ ��� ��ȯ (�������̵�)
		System.out.println(result);
		
		result = target.replace("va", "VA");
		System.out.println(result);

		result = target.replace("va", "");
		System.out.println(result);
		
		result = target.replace("av", "aWebv");
		System.out.println(result);
		
		System.out.println(target == result);			// result�� ��� ���ο� ��ü�� �����ؼ� ���� ����
														// result = new String(target.replace("av", "aWebv"));
		System.out.println(target);
		
		System.out.println(target.contains("V"));		// �ش� ���ڿ��� �����ϰ� �ִ���
		System.out.println(target.startsWith("jav"));	// �ش� ���ڿ��� �����ϴ���
		System.out.println(target.endsWith("a"));		// �ش� ���ڿ��� ��������
		
		System.out.println(target.indexOf('j'));		// Ư�� ���� �Ǵ� ���ڿ��� ����
		System.out.println(target.indexOf('a'));		// ���� ���ڰ� �������� ��� ���� ó���� ������ ��ġ ��ȯ
		System.out.println(target.indexOf('z'));		// ���Ե��� ���� ������ ��� -1 ��ȯ
		System.out.println(target.indexOf("av"));		// ���ڰ� ���ڿ��� ��� �ش� ���ڿ��� ó�� ������ ��ġ ��ȯ
		System.out.println(target.lastIndexOf('j'));	// Ư�� ���� �Ǵ� ���ڿ��� ���� (�ڿ�������)
		System.out.println(target.lastIndexOf('a'));	// ���� ���ڰ� �������� ��� ���� �������� ������ ��ġ ��ȯ
		System.out.println(target.indexOf("av"));		// ���ڰ� ���ڿ��� ��� ������ ���ڸ� ���� �������� ī��Ʈ
		
		target = "JavaWebSpring";
		System.out.println(target.substring(2));		// n��° ��ġ ������ ���ڿ� ��ȯ
		System.out.println(target.substring(4, 7));		// n1��° ��ġ ����, n2��° ��ġ ���������� ���ڿ� ��ȯ
		// 4: 0,1,2,3,4 | 7: 1,2,3,4,5,6,7	n1 ���� �� n1�� ���� ���� ��
		
		System.out.println(target.toLowerCase());		// �ҹ��ڷ� �ϰ� ��ȯ
		System.out.println(target.toUpperCase());		// �빮�ڷ� �ϰ� ��ȯ
		
		System.out.println(target);						// hashcode���� �ƴ� .toString()���� �ڵ� ��ȯ 
		
		target = "			ab		cd	e	\n";
		System.out.println("\""+target+"\"");
		System.out.println("\""+target.trim()+"\"");	// �� �� ����, ���� ����
	}
}
