package ch06;

public class Ex15 {
	public static void main(String[] args) {
		String a = "�⺻��";
		String b = "����� �ʱ�ȭ";
		String c = "������";
		String d = "�ʱ�ȭ ��";
		
		System.out.println("�ν��Ͻ������� �ʱ�ȭ ������ �ùٸ� ����?\n");
		
		String[] answer = new String[4];
		answer[0] = a;
		answer[1] = b;
		answer[2] = d;
		answer[3] = c;
		
		for (int i=0; i<answer.length; i++) {
			if (i != 0) {System.out.print(" > ");}
			System.out.print(answer[i]);
		}
	}
}
