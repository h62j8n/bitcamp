package com.bit.day18;

import java.awt.Frame;
import java.awt.List;
import java.awt.Panel;

public class Ex05 extends Frame {
	public Ex05() {
		Panel p1 = new Panel();
		
		List list = new List(5, true);		// 한번에 보여지는 아이템의 숫자, true : 다중선택 여부
		list.addItem("item2", 2);		// 인덱스 알아보기
		list.add("item1", 1);
		list.add("item3");
		list.add("item4");
		list.add("item5");
		list.setMultipleMode(false);
		
		p1.add(list);
		
		add(p1);
		setBounds(0, 0, 200, 200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ex05();
	}
}
