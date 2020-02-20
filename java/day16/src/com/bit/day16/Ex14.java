package com.bit.day16;

import java.util.Date;

public class Ex14 {
	public static void main(String[] args) {
		Date now = new Date();
		
		System.out.println(now);
		
		System.out.print(now.getYear()+1900+"�� ");			// 119
		System.out.print(now.getMonth()+1+"�� ");
		System.out.print(now.getDate()+"�� ");
		System.out.print(now.getDay()+"���� ");
		System.out.print(now.getHours()+"�� ");
		System.out.print(now.getMinutes()+"�� ");
		System.out.print(now.getSeconds()+"��\n");
		
		Date d1 = new Date(2002-1900, 5-1, 1, 12, 0);
		System.out.println(d1);
		
		Date d2 = new Date(System.currentTimeMillis()+(long)24*60*60*1000*100);	// ���ú��� 100�� �� (������ 100)
		System.out.println(d2);								// longŸ�� ���� ���� �� �ֱ� ������ �и������� ���� ��ȯ�Ͽ� ��ȯ�Ѵ�.
		
		Date d3 = new Date(System.currentTimeMillis());
		System.out.println(d2.after(d3));
		System.out.println(d2.before(d3));
		System.out.println(d2.compareTo(d3));				// .compareTo() : �񱳴���� after�̸� 1, before�̸� -1 ��ȯ
		System.out.println(d3.compareTo(d2));
		
		System.out.println(Date.parse("2002/01/01 12:00"));	// .parse(String str) : Ư�� ������ �����ϴ� ���ڿ��� ���� DateFormat���� �Ľ��� �� ��ȯ
		Date d4 = new Date("2002/01/01 12:00");				// ��ü ���� �ÿ��� ��� �����ϴ�
		System.out.println(d4);
	}
}
