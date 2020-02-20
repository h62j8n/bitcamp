package com.bit.day14;

import java.util.ArrayList;


public class Ex03 {
	public static void main(String[] args) {
		ArrayList list;
		list = new ArrayList();
		
		list.add(0);
		list.add("일");
		System.out.println(list.add(2));			// .add(num) : boolean값을 가지고 있다
		list.add("한글");
		
		list.remove(0);								// .remove(idx) : 해당 인덱스번호의 요소 삭제
		list.remove("한글");						// .remove(val) : 해당 값을 가진 요소 삭제
		list.set(0, "one");							// .set(idx, val) : 해당 인덱스의 값을 val로 변경
		
		for (int i=0; i<list.size(); i++) {			// .get(idx) : 인덱스번호의 값 호출
			System.out.print(list.get(i)+" ");
		}
		System.out.println();
		
		list.clear();								// .clear() : 배열의 요소 삭제
		
		list.add(0);
		list.add(0);
		
		list.add(1,3);								// .add(idx, num) : [idx]에 값을 끼워넣기
		list.add(list.size(),4);					// 마지막에 값을 끼워넣기 (나 자신도 +1됨)
		ArrayList list2 = (ArrayList)list.clone();	// .clone() : 배열의 깊은 복사
		
		for (int i=0; i<list.size(); i++) {
			System.out.print(list.get(i)+" ");
//			int suI = list.get(i);					// 오류: ArrayList와 su의 type mismatch
			Object suO = list.get(i);				// 일반 (정상)
/*			int suI1 = (int)list.get(i);			// 정수 배열의 경우) 다운캐스팅이지만 데이터 손실의 위험성 내포 
 *			int suI2 = (Integer)list.get(i);			// 정상적인 형변환
 *			System.out.print(suI2+" ");
 */
		}
		System.out.println();
		
		System.out.println(list.contains(0));		// .contains(num) : 해당 인자가 포함되었는지 확인
		System.out.println(list.contains(5));
		
		System.out.println(list.indexOf(0));		// .indexOf(num) : 해당 인자의 인덱스번호 호출(앞에서 카운트)
		System.out.println(list.lastIndexOf(0));	// .indexOf(num) : 해당 인자의 인덱스번호 호출(뒤에서 카운트)
		
		ArrayList list3 = new ArrayList();
		System.out.println(list3.isEmpty());		// .isEmpty() : 비어있는지 확인
		ArrayList list4 = null;						// 빈 배열이 아니라 객체가 없음. 가비지컬렉션에 의해 지워진다.
		
		Object[] arr = list2.toArray();				// .toArray() : ArrayList를 배열[]로 반환.  
		for (int i=0; i<arr.length; i++) {				// ArrayList는 주소값을 가진 참조형 배열이기 때문에
			System.out.print(arr[i]+" ");				// .toArray()로 정수형 배열[]로 반환할 수 없다.
		}
		
		
	}
}
