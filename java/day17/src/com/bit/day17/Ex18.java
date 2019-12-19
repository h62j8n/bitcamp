package com.bit.day17;

import java.awt.Button;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;

public class Ex18 {
	public static void main(String[] args) {
		Frame f = new Frame();
//		FlowLayout layout = new FlowLayout();
//		GridLayout layout = new GridLayout(2, 2);
		CardLayout layout = new CardLayout();
		f.setLayout(layout);
		
		Panel p1 = new Panel();
		Panel p2 = new Panel();
		Panel p3 = new Panel();
		Panel p4 = new Panel();
		
		Button btn1 = new Button("Button1");
		Button btn2 = new Button("Button2");
		Button btn3 = new Button("Button3");
		Button btn4 = new Button("Button4");
		
		p1.add(btn1);
		p2.add(btn2);
		p3.add(btn3);
		p4.add(btn4);
		
		f.add(p1);
		f.add(p2);
		f.add(p3);
		f.add(p4);
		
		f.setSize(300, 200);
		f.setLocation(0, 0);
		f.setVisible(true);
		
		for (int i=0; i<3; i++) {		// CardLayoutÀÇ È°¿ë
			layout.next(f);
		}
	}
}
