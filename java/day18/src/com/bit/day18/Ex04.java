package com.bit.day18;

import java.awt.Choice;
import java.awt.Frame;
import java.awt.Panel;

public class Ex04 extends Frame {
	public Ex04() {
		Panel p1 = new Panel();
		
		Choice cho = new Choice();
		cho.addItem("item1");
		cho.addItem("item2");
		cho.addItem("item3");
		cho.addItem("item4");
		cho.addItem("item5");
		
		p1.add(cho);
		add(p1);
		
		setBounds(0, 0, 200, 200);
		setLocation(0, 0);
//		setSize(200, 200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ex04();
	}
}
