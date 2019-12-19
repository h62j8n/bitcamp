package com.bit.day16;

import java.util.Calendar;

public class Ex12 {
	public static void main(String[] args) {
		Calendar start = Calendar.getInstance();
		Calendar current = Calendar.getInstance();

		start.set(2019, 10 - 1, 21);
		System.out.print("���� : " + start.get(Calendar.YEAR) + "�� ");
		System.out.print(start.get(Calendar.MONTH) + 1 + "�� ");
		System.out.print(start.get(Calendar.DATE) + "��\n");

		System.out.print("���� : " + current.get(Calendar.YEAR) + "�� ");
		System.out.print(current.get(Calendar.MONTH) + 1 + "�� ");
		System.out.print(current.get(Calendar.DATE) + "��\n");

		int startD = (start.get(Calendar.DAY_OF_YEAR));
		int currentD = (current.get(Calendar.DAY_OF_YEAR));
		int startW = (start.get(Calendar.WEEK_OF_YEAR));
		int currentW = (current.get(Calendar.WEEK_OF_YEAR));

		System.out.print(currentW - startW + 1 + "���� ");
		System.out.println(currentD - startD + 1 + "�� �Ǿ����ϴ�.");
	}
}
