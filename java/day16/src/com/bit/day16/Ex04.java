package com.bit.day16;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Ex04 {
	static Ex04 me;							// 1. 필드 (객체)
	
	public static void func01() {
		System.out.println("my func01");
	}
	public static void main(String[] args) {
		Ex04.me.func01();					// 1> 호출 : 클래스명.참조변수명.메소드명();
		
		PrintStream var1 = System.out;		// 2. out : 필드
		var1.println("출력");				// 2> 호출 : 클래스명System.필드명out.메소드명println(인자"출력");
		
		InputStream var2 = System.in;		// 3. in : 필드
		Scanner scan = new Scanner(var2);	// 3> 호출
		
		long sec = System.currentTimeMillis();
		System.out.println(Long.MAX_VALUE);			// long타입의 최대 값 반환
		System.out.println(sec);					// 현재 시간은 밀리세컨드로 표현할 수 있는 최대 범위에 가까워져있다.
//		최대범위에 이르면(2038년), 오버플로우로 인해 최소값으로 넘어간다. (유사 : Y2K 사건)
		
		Map<String, String> env = System.getenv();	// 맵 타입으로 받는 메소드
		Set<String> keys = env.keySet();
		Iterator<String> ite = keys.iterator();
		while (ite.hasNext()) {
			String key = ite.next();
			System.out.println(key+" = "+env.get(key));
		}
		
	}
}
