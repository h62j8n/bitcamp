package com.bit.day16;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Ex13 {
	public static void main(String[] args) {
		GregorianCalendar gc = null;
		gc = new GregorianCalendar(2002, 4, 1, 12, 0, 0);
		System.out.print(gc.get(Calendar.YEAR)+"년 ");
		System.out.print(gc.get(Calendar.MONTH)+"월 ");
		System.out.print(gc.get(Calendar.DAY_OF_MONTH)+"일 ");
		System.out.print(gc.get(Calendar.HOUR)+"시 ");
		System.out.print(gc.get(Calendar.MINUTE)+"분 ");
		System.out.print(gc.get(Calendar.SECOND)+"초 ");
	}
}
