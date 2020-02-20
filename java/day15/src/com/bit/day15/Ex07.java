package com.bit.day15;

import java.util.Enumeration;
import java.util.Vector;

public class Ex07 {
	public static void main(String[] args) {
		Vector<String> vec1 = new Vector<>();
		vec1.addElement("하나");					// 벡터만의 메소드
		vec1.addElement("스물아홉");
		vec1.addElement("서른둘");
//		vec1.addElement(33);						// Err. 제네릭 <String>
		
		Enumeration<String> eles = vec1.elements();	// 커서 관점에서 벡터의 요소 확인
		while (eles.hasMoreElements()) {
			String ele = eles.nextElement();
			System.out.println(ele);
		}
		
		System.out.println("-----");
		
		vec1.add("넷");								// 컬렉션프레임워크 공통 메소드
		vec1.add("다섯");
		for (int i=0; i<vec1.size(); i++) {			// 공통 메소드로 벡터의 요소 확인
			String msg = vec1.elementAt(i);			// ?????elementAt() 이 공통 명령어인지는 체크해보기
			System.out.println(msg);
		}
	}
}
