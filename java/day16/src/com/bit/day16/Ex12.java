package com.bit.day16;

import java.util.Calendar;

public class Ex12 {
	public static void main(String[] args) {
		Calendar start = Calendar.getInstance();
		Calendar current = Calendar.getInstance();

		start.set(2019, 10 - 1, 21);
		System.out.print("개강 : " + start.get(Calendar.YEAR) + "년 ");
		System.out.print(start.get(Calendar.MONTH) + 1 + "월 ");
		System.out.print(start.get(Calendar.DATE) + "일\n");

		System.out.print("오늘 : " + current.get(Calendar.YEAR) + "년 ");
		System.out.print(current.get(Calendar.MONTH) + 1 + "월 ");
		System.out.print(current.get(Calendar.DATE) + "일\n");

		int startD = (start.get(Calendar.DAY_OF_YEAR));
		int currentD = (current.get(Calendar.DAY_OF_YEAR));
		int startW = (start.get(Calendar.WEEK_OF_YEAR));
		int currentW = (current.get(Calendar.WEEK_OF_YEAR));

		System.out.print(currentW - startW + 1 + "주차 ");
		System.out.println(currentD - startD + 1 + "일 되었습니다.");
	}
}
