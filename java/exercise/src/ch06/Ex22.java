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
					break;						// 숫자가 아닌 문자가 발견되면 for문 종료
				} else {
					result = true;
				}
			}
		} catch (NullPointerException e) {}		// 예외 : 문자열이 null인 경우 수행문 없음
		
		return result;
	}
	public static void main(String[] args) {
		String str = "123";
		System.out.println("\""+str+"\"은 숫자입니까?\n> "+isNumber(str));
		
		str = "1e345";
		System.out.println("\""+str+"\"은 숫자입니까?\n> "+isNumber(str));
		
		str = "";
		System.out.println("\""+str+"\"은 숫자입니까?\n> "+isNumber(str));
		
		str = null;
		System.out.println("\""+str+"\"은 숫자입니까?\n> "+isNumber(str));
	}
}
