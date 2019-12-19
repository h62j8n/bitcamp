package com.bit.day22;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Ex03 {
	public static void main(String[] args) {
		java.net.InetAddress ia1 = null;
		java.net.InetAddress ia2 = null;
		java.net.InetAddress ia3 = null;
		InetAddress[] arr = null;
		
		byte[] by = {125, (byte)209, (byte)222, (byte)142};		// 1byte, 1byte, 1byte, 1byte �� 4byte ü���� �ּ� (������ȣ ���� �����ϰ� 0-255)
		
//		ia1 = new InetAddress();								// ��ü ���� �Ұ�
		try {
			ia1 = InetAddress.getByName("naver.com");			// io�۾��� ���� Exception ����
			ia2 = InetAddress.getLocalHost();
			ia3 = InetAddress.getByAddress(by);
//			arr = InetAddress.getAllByName("www.naver.com");	// �ܱ��� �����ϴ� global IP
			arr = InetAddress.getAllByName("naver.com");		// ���������� �����ϴ� IP
			
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
