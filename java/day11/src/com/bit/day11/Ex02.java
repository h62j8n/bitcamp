package com.bit.day11;
import com.bit.sec.Lec03;
import static com.bit.sec.Lec03.su2;
import java.util.*;												// 와일드카드 java.util.Scanner

public class Ex02 {
	public static void main(String[] args) {
		// 클래스에 접근하기 위해 패키지명 작성
//		com.bit.sec.Lec03 ex03;
//		ex03 = new com.bit.sec.Lec03;
		
//		java.lang.String msg = "java";							// String msg = "java";
		
		// import : 패키지명을 생략하고 작성
		Lec03 ex03 = new Lec03();
		ex03.func01();
		
		Scanner sc = new Scanner(System.in);
	}
}
