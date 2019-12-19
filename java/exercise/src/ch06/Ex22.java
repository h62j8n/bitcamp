package ch06;

public class Ex22 {
	public static boolean isNumber(String str) {
		boolean result = false;
		int min = (int)'0';
		int max = (int)'9';
		
		try {
			for (int i=0; i<str.length(); i++) {
				int target = str.charAt(i);
				if (target<min || target>max) {
					result = false;
					break;						// ���ڰ� �ƴ� ���ڰ� �߰ߵǸ� for�� ����
				} else {
					result = true;
				}
			}
		} catch (NullPointerException e) {}		// ���� : ���ڿ��� null�� ��� ���๮ ����
		
		return result;
	}
	public static void main(String[] args) {
		String str = "123";
		System.out.println("\""+str+"\"�� �����Դϱ�?\n> "+isNumber(str));
		
		str = "1e345";
		System.out.println("\""+str+"\"�� �����Դϱ�?\n> "+isNumber(str));
		
		str = "";
		System.out.println("\""+str+"\"�� �����Դϱ�?\n> "+isNumber(str));
		
		str = null;
		System.out.println("\""+str+"\"�� �����Դϱ�?\n> "+isNumber(str));
	}
}
