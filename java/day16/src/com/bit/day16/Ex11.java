package com.bit.day16;

import java.util.Calendar;

public class Ex11 {
	public static void main(String[] args) {
		// Calendar cal = new Calendar();					// Err : 객체 생성 제한
		Calendar cal = Calendar.getInstance();				// .getInstance()를 통해 객체를 받을 수 있다.

		System.out.println(cal);							// 다양한 정보를 담고 있다.

		System.out.println(cal.YEAR);						// 상수형 필드
		System.out.println(cal.MONTH);
		System.out.println(cal.DATE);

		System.out.print(cal.get(cal.YEAR) + "년 ");
		System.out.print(cal.get(cal.MONTH) + 1 + "월 ");	// 1~11
		System.out.print(cal.get(cal.DATE) + "일 ");
		System.out.print(cal.get(cal.HOUR) + "시 ");
		System.out.print(cal.get(cal.MINUTE) + "분 ");
		System.out.print(cal.get(cal.SECOND) + "초\n");

		System.out.print(cal.get(cal.AM) + ". ");
		System.out.print(cal.get(cal.AM_PM) + ".\n");		// 오전: 0 오후: 1

		System.out.println(cal.get(cal.DAY_OF_MONTH));		// DATE와 동일
		
		char[] ch = { '일', '월', '화', '수', '목', '금', '토', '일' };
		System.out.print(ch[cal.get(cal.DAY_OF_WEEK)-1] + "요일 ");
		
		if (cal.get(cal.AM_PM) == 0) {
			System.out.print("오전 ");
		} else {
			System.out.print("오후 ");
		}
		
		System.out.print(cal.get(cal.HOUR_OF_DAY) + "시 ");
		
		System.out.print(365-cal.get(cal.WEEK_OF_YEAR) + "주차 ");		// 연 단위
		System.out.print(cal.get(cal.DAY_OF_WEEK_IN_MONTH) + "주차\n");	// 월 단위
		
		System.out.print(cal.get(cal.DAY_OF_YEAR) + "일 지남 ");
		System.out.print(365-cal.get(cal.DAY_OF_YEAR) + "일 남음\n");
		
		System.out.println(cal.getTimeInMillis());

		cal.set(2002, 4, 1, 0, 0);
		System.out.print(cal.get(cal.YEAR) + "년 ");
		System.out.print(cal.get(cal.MONTH) + 1 + "월 ");	// 1~11
		System.out.print(cal.get(cal.DATE) + "일 ");
		System.out.print(cal.get(cal.HOUR) + "시 ");
		System.out.print(cal.get(cal.MINUTE) + "분 ");
		System.out.print(cal.get(cal.SECOND) + "초\n");
	}
}
