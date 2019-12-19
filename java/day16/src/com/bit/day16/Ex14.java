package com.bit.day16;

import java.util.Date;

public class Ex14 {
	public static void main(String[] args) {
		Date now = new Date();
		
		System.out.println(now);
		
		System.out.print(now.getYear()+1900+"년 ");			// 119
		System.out.print(now.getMonth()+1+"월 ");
		System.out.print(now.getDate()+"일 ");
		System.out.print(now.getDay()+"요일 ");
		System.out.print(now.getHours()+"시 ");
		System.out.print(now.getMinutes()+"분 ");
		System.out.print(now.getSeconds()+"초\n");
		
		Date d1 = new Date(2002-1900, 5-1, 1, 12, 0);
		System.out.println(d1);
		
		Date d2 = new Date(System.currentTimeMillis()+(long)24*60*60*1000*100);	// 오늘부터 100일 후 (마지막 100)
		System.out.println(d2);								// long타입 값을 받을 수 있기 때문에 밀리세컨즈 값을 변환하여 반환한다.
		
		Date d3 = new Date(System.currentTimeMillis());
		System.out.println(d2.after(d3));
		System.out.println(d2.before(d3));
		System.out.println(d2.compareTo(d3));				// .compareTo() : 비교대상이 after이면 1, before이면 -1 반환
		System.out.println(d3.compareTo(d2));
		
		System.out.println(Date.parse("2002/01/01 12:00"));	// .parse(String str) : 특정 포멧을 만족하는 문자열에 대해 DateFormat으로 파싱한 값 반환
		Date d4 = new Date("2002/01/01 12:00");				// 객체 생성 시에도 사용 가능하다
		System.out.println(d4);
	}
}
