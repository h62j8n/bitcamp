package ch06;

public class Ex19 {
	public static void change(String str) {
		str += "456";
		// �Ű����� str�� ��. ���� �޼ҵ��� str������ ������ ���� �ʴ´�.
		System.out.println("in change() : "+str);
	}

	public static void main(String[] args) {
		String str = "ABC123";
		System.out.println(str);
		change(str);
		System.out.println("in main : " + str);
	}
}
