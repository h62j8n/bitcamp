package com.bit.day16;

public class Ex01 {
	public static void main(String[] args) {
		// String
		String msg1 = "java";
		System.out.println(msg1);
		
		String msg5 = "java"+"web";
		System.out.println(msg5 == "javaweb");				// true
		String msg6 = "java".concat("web");
		System.out.println(msg6 == "javaweb");				// false
		
		// StringBuffer
		StringBuffer msg2 = new StringBuffer("Buffer");
		
//		StringBuffer msg3 = "buffer class";					// Err: StringBuffer msg3 = new String("buffer class");
		StringBuffer msg3 = new StringBuffer(" Class");
		StringBuffer msg4 = new StringBuffer("�� +");
		
		System.out.println("msg2 : \""+msg2+"\"");
//		System.out.println(msg2+msg3);						// Err : ��ü�� ��ü�� +������ StringŬ�������� ���ǵ�
		System.out.println(msg2.append(msg3).append(msg4));	// .append() : StringŬ������ + ������
		System.out.println("After append >");
		System.out.println("msg2 : \""+msg2+"\"");			// ��ü �ڽſ��� ������ �ش�.
	}
}
