package ch06;

public class Ex24 {
	public static int abs(int value) {
//		int result = Math.abs(value);
		int result = value;
		if (value < 0) {
			result = -(value);
		}
		return result;
	}
	public static void main(String[] args) {
		int value = 5;
		System.out.println(value+"의 절대값 : "+abs(value));
		value = -10;
		System.out.println(value+"의 절대값 : "+abs(value));

	}
}
