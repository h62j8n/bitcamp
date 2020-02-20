package com.bit.day12;
import java.util.Scanner;

public class Ex13 {
	public static void main(String[] args) {
		Scanner sc;
		sc = new Scanner("ABC\nDEF\n");
		
		System.out.print(sc.nextLine());	// 개행을 기준으로 잘라서 출력
	}
}
