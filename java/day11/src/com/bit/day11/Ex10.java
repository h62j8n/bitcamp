package com.bit.day11;
import java.util.Scanner;

public class Ex10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = null;
		int su = 0;
		int[] target = {1, 4, 6, 12};
		
		System.out.print("숫자를 입력하세요.\n>");
		input = sc.nextLine();
		try {
			su = Integer.parseInt(input);
//			System.out.println("10÷"+su+" = "+(10/su));
			System.out.println(target[su]+"÷"+su+" = "+(target[su]/su));
		} catch (NumberFormatException e) {
			System.out.println("문자 입력으로 인한 오류");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("배열 오류");
		} catch (ArithmeticException e) {
			System.out.println("0 입력으로 인한 오류");
		}
	}
}
