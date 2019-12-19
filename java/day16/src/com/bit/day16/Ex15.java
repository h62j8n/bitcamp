package com.bit.day16;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex15 {
	public static void main(String[] args) {
		Date now = new Date();
		System.out.println(now);
		
		String myString = null;
		
		DateFormat df1 = DateFormat.getDateInstance();
		myString = df1.format(now);
		System.out.println(myString);
		
		DateFormat df4 = DateFormat.getDateInstance(DateFormat.MEDIUM);			// default
		myString = df4.format(now);
		System.out.println(myString);
		
		DateFormat df3 = DateFormat.getDateInstance(DateFormat.SHORT);
		myString = df3.format(now);
		System.out.println(myString);
		
		DateFormat df2 = DateFormat.getDateInstance(DateFormat.LONG);
		myString = df2.format(now);
		System.out.println(myString);
		
		DateFormat df5 = DateFormat.getDateInstance(DateFormat.FULL);
		myString = df5.format(now);
		System.out.println(myString);
		
		SimpleDateFormat sdf1 = new SimpleDateFormat();
		myString = sdf1.format(now);
		System.out.println(myString);
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("yy-M-dd hh:mm:ss");
		myString = sdf2.format(now);
		System.out.println(myString);
	}
}
