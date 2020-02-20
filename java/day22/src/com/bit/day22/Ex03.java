package com.bit.day22;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Ex03 {
	public static void main(String[] args) {
		java.net.InetAddress ia1 = null;
		java.net.InetAddress ia2 = null;
		java.net.InetAddress ia3 = null;
		InetAddress[] arr = null;
		
		byte[] by = {125, (byte)209, (byte)222, (byte)142};		// 1byte, 1byte, 1byte, 1byte 총 4byte 체계의 주소 (음수부호 값을 제외하고 0-255)
		
//		ia1 = new InetAddress();								// 객체 생성 불가
		try {
			ia1 = InetAddress.getByName("naver.com");			// io작업에 의한 Exception 수반
			ia2 = InetAddress.getLocalHost();
			ia3 = InetAddress.getByAddress(by);
//			arr = InetAddress.getAllByName("www.naver.com");	// 외국과 공유하는 global IP
			arr = InetAddress.getAllByName("naver.com");		// 국내에서만 접근하는 IP
			
		} catch (UnknownHostException e) {
		}
		
		System.out.println(ia1.getHostName());
		System.out.println(ia1.getHostAddress());
		System.out.println(ia1.getCanonicalHostName());
		System.out.println("-----");
		
		System.out.println(ia2.getHostName());
		System.out.println(ia2.getHostAddress());
		System.out.println(ia2.getCanonicalHostName());
		System.out.println("-----");
		
		System.out.println(ia3.getHostName());
		System.out.println(ia3.getHostAddress());
		System.out.println(ia3.getCanonicalHostName());
		
		for (int i=0; i<arr.length; i++) {
			InetAddress temp = arr[i];
			System.out.println(temp.getHostAddress());
		}
	}
}
