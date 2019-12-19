package com.bit.day16;

import java.util.Calendar;

public class Ex11 {
	public static void main(String[] args) {
		// Calendar cal = new Calendar();					// Err : ��ü ���� ����
		Calendar cal = Calendar.getInstance();				// .getInstance()�� ���� ��ü�� ���� �� �ִ�.

		System.out.println(cal);							// �پ��� ������ ��� �ִ�.

		System.out.println(cal.YEAR);						// ����� �ʵ�
		System.out.println(cal.MONTH);
		System.out.println(cal.DATE);

		System.out.print(cal.get(cal.YEAR) + "�� ");
		System.out.print(cal.get(cal.MONTH) + 1 + "�� ");	// 1~11
		System.out.print(cal.get(cal.DATE) + "�� ");
		System.out.print(cal.get(cal.HOUR) + "�� ");
		System.out.print(cal.get(cal.MINUTE) + "�� ");
		System.out.print(cal.get(cal.SECOND) + "��\n");

		System.out.print(cal.get(cal.AM) + ". ");
		System.out.print(cal.get(cal.AM_PM) + ".\n");		// ����: 0 ����: 1

		System.out.println(cal.get(cal.DAY_OF_MONTH));		// DATE�� ����
		
		char[] ch = { '��', '��', 'ȭ', '��', '��', '��', '��', '��' };
		System.out.print(ch[cal.get(cal.DAY_OF_WEEK)-1] + "���� ");
		
		if (cal.get(cal.AM_PM) == 0) {
			System.out.print("���� ");
		} else {
			System.out.print("���� ");
		}
		
		System.out.print(cal.get(cal.HOUR_OF_DAY) + "�� ");
		
		System.out.print(365-cal.get(cal.WEEK_OF_YEAR) + "���� ");		// �� ����
		System.out.print(cal.get(cal.DAY_OF_WEEK_IN_MONTH) + "����\n");	// �� ����
		
		System.out.print(cal.get(cal.DAY_OF_YEAR) + "�� ���� ");
		System.out.print(365-cal.get(cal.DAY_OF_YEAR) + "�� ����\n");
		
		System.out.println(cal.getTimeInMillis());

		cal.set(2002, 4, 1, 0, 0);
		System.out.print(cal.get(cal.YEAR) + "�� ");
		System.out.print(cal.get(cal.MONTH) + 1 + "�� ");	// 1~11
		System.out.print(cal.get(cal.DATE) + "�� ");
		System.out.print(cal.get(cal.HOUR) + "�� ");
		System.out.print(cal.get(cal.MINUTE) + "�� ");
		System.out.print(cal.get(cal.SECOND) + "��\n");
	}
}
