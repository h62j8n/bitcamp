package com.bit.day15;

import java.util.ArrayList;
import java.util.List;

public class Ex01 {
	public static void main(String[] args) {
		List<String> list = null;					// #1-3. <String> : 제네릭.
		list = new ArrayList();
		
		list.add("하나");
		list.add("둘");
//		list.add(new Integer(3333));				// #1-2> 수행(String 타입으로 가공하여 출력) 시  형변환 오류 발생
		list.add("넷");								// #1-3> 컴파일 전에 String 타입 값만 받도록 에러로 표시 (제네릭)
		list.add("다섯");
		
		for (int i=0; i<list.size(); i++) {
			Object obj0 = list.get(i);				// #1-1. 원본 값
			String obj = (String)list.get(i);		// #1-2. 사용하기 위해 형변환(가공)
			
			System.out.println(obj);
		}
	}
}
